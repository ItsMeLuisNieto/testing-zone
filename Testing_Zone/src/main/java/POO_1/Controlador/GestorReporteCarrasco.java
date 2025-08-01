/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Controlador;

import POO_1.Modelo.ReporteCarrasco; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestorReporteCarrasco {
    private static final String SEPARADOR = String.format("%44S\n", " ").replace(" ", "-");
    private static final String SEPARADOR2 = String.format("%561S\n", " ").replace(" ", "=");
    private static GestorErrores ge1 = new GestorErrores();
    
    public static String generarReporte1(String facultadFiltro,
        String especialidadFiltro,
        String tipoMatriculaFiltro) {
        
        StringBuilder sb = new StringBuilder();

        
        sb.append("Reporte 1: Usuarios por Facultad, Especialidad y Tipo de Matrícula\n");
        sb.append(SEPARADOR);

        sb.append(EncontrarAlumnos1(facultadFiltro,especialidadFiltro,tipoMatriculaFiltro));

        sb.append(SEPARADOR);
        sb.append("Fin del reporte\n");

        return sb.toString();
    }
    
    public static String EncontrarAlumnos1(String facultadBuscada,String especialidadBuscada,String tipoMatriculaBuscada) {
        // Hecho por Carrasco
        
        if (facultadBuscada == null || especialidadBuscada == null || tipoMatriculaBuscada == null) {
           return "Error: Los parámetros de búsqueda no pueden ser nulos.\n";
        }
    
        if (facultadBuscada.trim().isEmpty() || especialidadBuscada.trim().isEmpty() || tipoMatriculaBuscada.trim().isEmpty()) {
           return "Error: Los parámetros de búsqueda no pueden estar vacíos.\n";
        }
     
        try {
            StringBuilder reporte = new StringBuilder();
            int contador = 1;

            FileReader fr = new FileReader(Archivo.getArchivo(2));
            BufferedReader br = new BufferedReader(fr);
            
            reporte.append(SEPARADOR2);

            String linea;
            br.readLine(); // Saltar encabezados

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                if (partes.length > 21) {
                    partes[18] = partes[18] + "," + partes[19];
                    partes[19] = partes[20];
                    partes[20] = partes[21];
                }
                
                String facultad = partes[18].trim();
                String especialidad = partes[19].trim();
                String tipoMatricula = partes[6].trim();
                
                // Verifica si coincide con los filtros
                if (facultadBuscada.toUpperCase().contains(facultad.toUpperCase())
                && especialidadBuscada.toUpperCase().contains(especialidad.toUpperCase())
                && tipoMatriculaBuscada.toUpperCase().contains(tipoMatricula.toUpperCase())){

                    if(contador == 1) {
                        reporte.append(String.format("%-6S || "
                        + "%-5S || "
                        + "%-8S || "
                        + "%-30S || "
                        + "%-17S || "
                        + "%-16S || "
                        + "%-25S || "
                        + "%-30S || "
                        + "%-35S || "
                        + "%-20S || "
                        + "%-60S || "
                        + "%-50S || "
                        + "%-15S || \n", "ID", "ANIO", "PERIODO", "TIPO_MATRICULA",
                        "ANIO_NACIMIENTO", "NACIMIENTO_PAIS", "NACIMIENTO_DEPA", "NACIMIENTO_PROV",
                        "NACIMIENTO_DIST", "SEXO", "FACULTAD", "ESPECIALIDAD", "CICLO_RELATIVO"));
                        reporte.append(SEPARADOR2);
                    }
                    // Muestra Facultad, Especialidad y Tipo de Matrícula (ajusta índice)
                    reporte.append(String.format("%-6d || ", contador));
                    ReporteCarrasco DataAlumno = new ReporteCarrasco (Integer.parseInt(partes[4]),Integer.parseInt(partes[5]),Integer.parseInt(partes[10]), partes[6], partes[11],partes[12],partes[13],partes[14],partes[15],partes[18],partes[19],Integer.parseInt(partes[20]));
                    reporte.append(DataAlumno.toString().replace('Ñ', 'N').replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U"));
                    reporte.append("\n");
                    contador++;
                }
            }

            br.close();
            
            if (contador == 1) {
                reporte.append("No se encontraron alumnos con esos filtros.\n");
                reporte.append("Criterios de búsqueda:\n");
                reporte.append("- Facultad: ").append(facultadBuscada).append("\n");
                reporte.append("- Especialidad: ").append(especialidadBuscada).append("\n");
                reporte.append("- Tipo de Matrícula: ").append(tipoMatriculaBuscada).append("\n");
            } else {
            reporte.append("\nTotal de alumnos encontrados: ").append(contador - 1).append("\n");
           }
            return reporte.toString();
            

        } catch (IOException error) {
            System.err.println("Hubo un error al intentar leer el archivo");
            ge1.EscribirAuditoria(error, "Aplicación de filtros en el archivo CSV");
            return null;
        }
        
    }
}