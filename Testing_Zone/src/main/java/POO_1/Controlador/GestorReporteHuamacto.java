/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Controlador;

import POO_1.Modelo.ReporteHuamacto; // No olvidar la importación
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestorReporteHuamacto {
    // Separadores visuales para formato del reporte
    private static final String SEPARADOR = String.format("%44S\n", " ").replace(" ", "-");
    private static final String SEPARADOR2 = String.format("%561S\n", " ").replace(" ", "=");
    private static GestorErrores ge1 = new GestorErrores();
    
    // Método principal que genera el reporte completo
    public static String GenerarReporte2(int anio_nacimiento_inicio, int anio_nacimiento_final, int sexo) {
        
        StringBuilder sb = new StringBuilder(); 
        
        sb.append("Reporte 2: Nacimiento de alumnos y sexo\n");
        sb.append(SEPARADOR);
        
        sb.append(EncontrarAlumnos2(10, 15, anio_nacimiento_inicio, anio_nacimiento_final, sexo));

        sb.append(SEPARADOR);
        sb.append("Fin del reporte\n");

        return sb.toString();
    }
    
    public static String EncontrarAlumnos2(int indice1, int indice2, int anio_nacimiento_inicial, int anio_nacimiento_final, int sexo) {
        // Hecho por Huamacto Robles, Jimmy Leonardo Sebastian
        // Uso del try y catch
        try {
            StringBuilder reporte = new StringBuilder();
            int contador = 1;
            FileReader fr = new FileReader(Archivo.getArchivo(2));
            BufferedReader br = new BufferedReader(fr);

            String linea;
            br.readLine(); //Para evitar encabezados
            
            // Determina el texto del sexo según el valor ingresado
            String s = "";
            
            switch (sexo){
                case 1 -> {
                    s = "Masculino";
                }
                case 2 -> {
                    s = "Femenino";
                }
            }

            reporte.append(SEPARADOR2);
            
            // Aquí se realiza la iteración, es toda la magia
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                
                if (partes.length > 21) {
                    partes[18] = partes[18] + "," + partes[19];
                    partes[19] = partes[20];
                    partes[20] = partes[21];
                }
                
                if ((Integer.parseInt(partes[indice1]) >= anio_nacimiento_inicial &&
                        Integer.parseInt(partes[indice1]) <= anio_nacimiento_final) && (partes[indice2].equals(s.toUpperCase()))) {
                    if (contador == 1) {
                        // Imprime encabezados solo una vez, al primer alumno
                        reporte.append(String.format("%-6S || "
                            + "%-19S || "
                            + "%-25S || "
                            + "%-35S || "
                            + "%-5S || "
                            + "%-8S || "
                            + "%-30S || "
                            + "%-20S || "
                            + "%-25S || "
                            + "%-28S || "
                            + "%-17S || "
                            + "%-16S || "
                            + "%-25S || "
                            + "%-30S || "
                            + "%-35S || "
                            + "%-25S || "
                            + "%-50S || "
                            + "%-20S || "
                            + "%-60S || "
                            + "%-50S || "
                            + "%-15S || \n", "ID", "COLEGIO_DEPA", "COLEGIO_PROV", "COLEGIO_DIST",
                            "ANIO", "PERIODO", "TIPO_MATRICULA", "DOMICILIO_DEPA",
                            "DOMICILIO_PROV", "DOMICILIO_DIST", "ANIO_NACIMIENTO",
                            "NACIMIENTO_PAIS", "NACIMIENTO_DEPA", "NACIMIENTO_PROV",
                            "NACIMIENTO_DIST", "SEXO", "MODALIDAD", "METODOLOGIA",
                            "FACULTAD", "ESPECIALIDAD", "CICLO_RELATIVO"));
                        reporte.append(SEPARADOR2);
                    }

                    // Informa exitosamente que se encontró un alumno
                    reporte.append(String.format("%-6d || ", contador));
                    ReporteHuamacto DataAlumno = new ReporteHuamacto (partes[1],partes[2],partes[3],Integer.parseInt(partes[4]),Integer.parseInt(partes[5]),partes[6],partes[7],partes[8],partes[9],Integer.parseInt(partes[10]),partes[11],partes[12],partes[13],partes[14],partes[15],partes[16],partes[17],partes[18],partes[19], Integer.parseInt(partes[20]));
                    reporte.append(DataAlumno.toString().replace('Ñ', 'N').replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U"));
                    reporte.append("\n");
                    contador++;
                }
            }
            br.close();
            return reporte.toString();
        } catch (IOException error) {
            // Si ocurre un error, lo muestra y lo registra en auditoría
            System.err.println("Hubo un error al intentar leer el archivo de datos abiertos (se está registrando el error en la auditoría)");
            ge1.EscribirAuditoria(error, "Aplicación de filtros en el archivo CSV");
            return null;
        }
    }
}
    