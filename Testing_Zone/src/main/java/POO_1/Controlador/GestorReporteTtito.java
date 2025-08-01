/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Controlador;

import POO_1.Modelo.ReporteTtito;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Clase que genera un reporte filtrado por distrito de nacimiento
public class GestorReporteTtito {
    // Separadores para dividir visualmente el contenido del reporte
    private static final String SEPARADOR = String.format("%44S\n", " ").replace(" ", "-");
    private static final String SEPARADOR2 = String.format("%561S\n", " ").replace(" ", "=");
    private static GestorErrores ge1 = new GestorErrores();
    
    public static String GenerarReporte4(String distritoBuscado) {
        StringBuilder sb = new StringBuilder();

        sb.append("Reporte: Alumnos por Distrito de nacimiento\n");
        sb.append(SEPARADOR);

        sb.append(EncontrarAlumnos4(distritoBuscado));

        sb.append(SEPARADOR);
        sb.append("Fin del reporte\n");

        return sb.toString();
    }
    
        // Método que encuentra y devuelve los alumnos nacidos en un distrito específico
        public static String EncontrarAlumnos4(String distritoBuscado) {
        //Hecho por Ttito
        // Verifica si el nombre del distrito no es nulo ni vacío
        if (distritoBuscado == null || distritoBuscado.equals("")) {
            return "Error: El distrito no puede ser nulo ni vacío.\n";
        }

        try {
            StringBuilder reporte = new StringBuilder();
            int contador = 1;
            
            // Inicializa el StringBuilder para formar el reporte
            FileReader fr = new FileReader(Archivo.getArchivo(2));
            BufferedReader br = new BufferedReader(fr);
            
            // Lee el archivo con los datos (posición 2 en el arreglo de archivos)
            String linea;
            br.readLine(); // Saltar encabezados

            reporte.append(SEPARADOR2);
            
            while ((linea = br.readLine()) != null) {
                
                String[] partes = linea.split(","); // Se separa por comas el contenido


                String distrito = partes[9];// Obtiene el distrito de nacimiento
                
                // Compara el distrito actual con el distrito buscado (ignora mayúsculas o minúsculas)
                if (distrito.equalsIgnoreCase(distritoBuscado)) {
                    // Si es el primer alumno encontrado, se imprime el encabezado de la tabla
                    if (contador == 1) {
                        reporte.append(String.format("%-6S || "
                        + "%-5S || "
                        + "%-8S || "
                        + "%-17S || "
                        + "%-35S || "
                        + "%-30S || "
                        + "%-33S || "
                        + "%-16S || "
                        + "%-25S || "
                        + "%-30S || "
                        + "%-40S || "
                        + "%-20S || "
                        + "%-50S || "
                        + "%-20S || "
                        + "%-60S || "
                        + "%-50S || "
                        + "%-15S || \n", "ID", "ANIO", "PERIODO", "ANIO_NACIMIENTO", "DOMICILIO_DEPA",
                        "DOMICILIO_PROV", "DOMICILIO_DIST",
                        "NACIMIENTO_PAIS", "NACIMIENTO_DEPA", "NACIMIENTO_PROV",
                        "NACIMIENTO_DIST", "SEXO", "MODALIDAD", "METODOLOGIA",
                        "FACULTAD", "ESPECIALIDAD", "CICLO_RELATIVO"));
                        reporte.append(SEPARADOR2);
                    }
                    // Crea un objeto alumno con los datos de esa línea
                    ReporteTtito alumno = new ReporteTtito(
                    Integer.parseInt(partes[0]), Integer.parseInt(partes[1]), Integer.parseInt(partes[2]),
                    partes[3], partes[4], partes[5],
                    partes[6], partes[7], partes[8], partes[9],
                    partes[10], partes[11], partes[12],
                    partes[13], partes[14], Integer.parseInt(partes[15])
                    );
                    // Agrega una fila con el contador y los datos del alumno
                    reporte.append(String.format("%-6d || ", contador));
                    reporte.append(alumno.toString().replace('Ñ', 'N').replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U")).append("\n");
                    contador++;
                }
            }

            br.close();
            
            // Si no se encontró ningún alumno con ese distrito
            if (contador == 1) {
                reporte.append("No se encontraron alumnos con ese distrito.\n");
                reporte.append("Criterio de búsqueda: ").append(distritoBuscado).append("\n");
            } else {
                reporte.append("\nTotal de alumnos encontrados: ").append(contador - 1).append("\n");
            }

            return reporte.toString();

        } catch (IOException error) {
             // Manejo del error en la lectura del archivo
            System.err.println("Hubo un error al intentar leer el archivo");
            ge1.EscribirAuditoria(error, "Aplicación de filtro por distrito");
            return null;
        }
    }  
}
