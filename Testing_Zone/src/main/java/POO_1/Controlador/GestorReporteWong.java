/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Controlador;

import POO_1.Modelo.ReporteWong;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestorReporteWong {
    // Separadores para dividir visualmente el contenido del reporte
    private static final String SEPARADOR = String.format("%44S\n", " ").replace(" ", "-");
    private static final String SEPARADOR2 = String.format("%561S\n", " ").replace(" ", "=");
    private static GestorErrores ge1 = new GestorErrores();
    
    public static String GenerarReporte5(int modalidad) {
        // Genera un reporte filtrando alumnos por modalidad y metodología
        StringBuilder sb = new StringBuilder();

        sb.append("Reporte: Alumnos por Modalidad\n");
        sb.append(SEPARADOR);

        sb.append(EncontrarAlumnos5(modalidad));

        sb.append(SEPARADOR);
        sb.append("Fin del reporte\n");

        return sb.toString();
    }
    
    public static String EncontrarAlumnos5(int modalidad) {
    // Hecho por Fernando Wong
    // Uso del try y catch
    // Busca alumnos según la modalidad de ingreso seleccionada
        try {
            StringBuilder reporte = new StringBuilder();
            int contador = 1;

            FileReader fr = new FileReader(Archivo.getArchivo(2));
            BufferedReader br = new BufferedReader(fr);
            String modalidadBuscada = "";

            String linea;
            br.readLine(); // Saltar encabezado

            reporte.append(SEPARADOR2);
            
            // Traduce el número ingresado por el usuario a su respectiva modalidad
            switch (modalidad) {
                case 1 -> { modalidadBuscada = "Ordinario"; }
                case 2 -> { modalidadBuscada = "Ingreso directo"; }
                case 3 -> { modalidadBuscada = "Ingreso directo CEPRE"; }
                case 4 -> { modalidadBuscada = "Dos primeros alumnos"; }
                case 5 -> { modalidadBuscada = "Concurso nacional escolar"; }
                case 6 -> { modalidadBuscada = "Ingreso escolar nacional"; }
                case 7 -> { modalidadBuscada = "Ingreso directo CEPRE-UNI"; }
                case 8 -> { modalidadBuscada = "Traslado externo"; }
                case 9 -> { modalidadBuscada = "Titulados o graduados de la UNI"; }
                case 10 -> { modalidadBuscada = "Victimas de terrorismo"; }
            }

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                // Si hay campos con comas internas, se ajustan los índices
                if (partes.length > 21) {
                    partes[18] = partes[18] + partes[19];
                    partes[19] = partes[20];
                    partes[20] = partes[21];
                }
                    
                    // Verifica si la modalidad coincide con la que se busca
                    if (partes[16].equalsIgnoreCase(modalidadBuscada)) {
                        if (contador == 1) {
                            // Imprimir los encabezados solo una vez, al encontrar el primer alumno
                            reporte.append(String.format("%-6S || "
                            + "%-20S || "
                            + "%-30S || "
                            + "%-40S || "
                            + "%-5S || "
                            + "%-8S || "
                            + "%-30S || "
                            + "%-25S || "
                            + "%-30S || "
                            + "%-33S || "
                            + "%-17S || "
                            + "%-16S || "
                            + "%-25S || "
                            + "%-30S || "
                            + "%-40S || "
                            + "%-20S || "
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
                        // Se crea un objeto ReporteWong con los datos del estudiante
                        ReporteWong alumno = new ReporteWong(
                            partes[0], partes[1], partes[2], Integer.parseInt(partes[3]),
                            Integer.parseInt(partes[4]), (partes[5]),
                            partes[6], partes[7], partes[8], Integer.parseInt(partes[9]),
                            (partes[10]), partes[11], partes[12],
                            partes[13], partes[14], partes[15], partes[16],
                            partes[17], partes[18], Integer.parseInt(partes[19])
                        );
                        // Imprime la fila del alumno formateada
                        reporte.append(String.format("%-6d || ", contador));
                        reporte.append(alumno.toString().replace('Ñ', 'N').replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U")).append("\n");
                        contador++;
                    }
            }

            br.close();
            // Si no se encontró ningún alumno con esa modalidad
            if (contador == 1) {
                reporte.append("No se encontraron alumnos con esos filtros.\n");
            }

            return reporte.toString();

        } catch (IOException error) {
            // Captura cualquier error al leer el archivo y lo registra
            System.err.println("Hubo un error al intentar leer el archivo.");
            ge1.EscribirAuditoria(error, "Filtrado por modalidad y metodología");
            return null;
        }
    }
}