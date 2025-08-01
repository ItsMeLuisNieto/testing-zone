/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Controlador;

import POO_1.Modelo.ReporteNieto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestorReporteNieto {
    private static final String SEPARADOR = String.format("%44S\n", " ").replace(" ", "-");
    private static final String SEPARADOR2 = String.format("%561S\n", " ").replace(" ", "=");
    private static GestorErrores ge1 = new GestorErrores();
    
    public static String GenerarReporte3(int año_inicio, int año_fin, int periodo_inicio, int periodo_fin) {
        // Se realiza la iterarión sobre una lista de usuarios y agruparlos por año y periodo

        StringBuilder sb = new StringBuilder();

        // Adjuntamos la data al StringBuilder
        sb.append("Reporte 3: Usuarios por año y periodo de ingreso\n");
        sb.append(SEPARADOR);
        
        sb.append(EncontrarAlumnos3(4, año_inicio, año_fin, periodo_inicio, periodo_fin));

        sb.append(SEPARADOR);
        sb.append("Fin del reporte\n");

        return sb.toString();
    }
    
        public static String EncontrarAlumnos3(int datos, int rango_inicio1, int rango_fin1, int rango_inicio2, int rango_fin2) {
        // Hecho por Nieto Paz, Luis Angel
        // Uso del try y catch
        try {
            // Declaración de variables
            StringBuilder reporte = new StringBuilder();
            int contador = 1, total_lineas = 0;
            FileReader fr = new FileReader(Archivo.getArchivo(2));
            BufferedReader br = new BufferedReader(fr);

            String linea;
            br.readLine(); //Para evitar encabezados

            reporte.append(SEPARADOR2);
            
            // Aquí se realiza la iteración
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                
                // Aumentamos total_lineas para ver el total de datos
                total_lineas++;
                
                // Unimos algunas elementos debido a que la facultad a veces incluye 
                // una coma (se separa cada elemento de partes a través de dicha coma)
                if (partes.length > 21) {
                    partes[18] = partes[18] + partes[19];
                    partes[19] = partes[20];
                    partes[20] = partes[21];
                }
                
                if ((Integer.parseInt(partes[datos]) >= rango_inicio1 || Integer.parseInt(partes[datos + 1]) >= rango_inicio1) && (Integer.parseInt(partes[datos]) <= rango_fin2 || Integer.parseInt(partes[datos + 1]) <= rango_fin2)) {
                    if (contador == 1) {
                        // Adjuntamos el encabezado en el reporte
                        reporte.append(String.format("%-6S || "
                                    + "%-5S || "
                                    + "%-8S || "
                                    + "%-17S || "
                                    + "%-16S || "
                                    + "%-25S || "
                                    + "%-30S || "
                                    + "%-40S || "
                                    + "%-20S || "
                                    + "%-60S || "
                                    + "%-50S || "
                                    + "%-15S || \n", "ID", "ANIO", "PERIODO", "ANIO_NACIMIENTO",
                            "NACIMIENTO_PAIS", "NACIMIENTO_DEPA", "NACIMIENTO_PROV",
                            "NACIMIENTO_DIST", "SEXO", "FACULTAD", "ESPECIALIDAD", 
                            "CICLO_RELATIVO"));

                        reporte.append(SEPARADOR2);
                    }
                    
                    // Informa exitosamente que se encontró un alumno
                    reporte.append(String.format("%-6d || ", contador));
                    ReporteNieto DataAlumno = new ReporteNieto(Integer.parseInt(partes[4]),Integer.parseInt(partes[5]),Integer.parseInt(partes[10]),partes[11],partes[12],partes[13],partes[14],partes[15],partes[18],partes[19],Integer.parseInt(partes[20]));
                    reporte.append(DataAlumno.toString().replace('Ñ', 'N').replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U"));
                    reporte.append("\n");
                    contador++;
                }
            }
            
            // Si el contador es 1 entonces no se encontraron datos
            if (contador == 1) {
                System.out.println("No se encontraron alumnos con dichos filtros");
            } else {
                // De ser distinto ejecuta el código de aquí
                reporte.append(SEPARADOR2);
                reporte.append("Se han encontrado ").append((contador - 1)).append(" alumnos de ").append(total_lineas).append("\n");
            }
            
            br.close();
            return reporte.toString();
        } catch (IOException error) {
            System.err.println("Hubo un error al intentar leer el archivo de datos abiertos (se está registrando el error en la auditoría)");
            ge1.EscribirAuditoria(error, "Aplicación de filtros en el archivo CSV");
            return null;
        }
    } 
}
