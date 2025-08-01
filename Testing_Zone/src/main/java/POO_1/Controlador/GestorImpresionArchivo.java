package POO_1.Controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GestorImpresionArchivo {
    private static GestorErrores ge1 = new GestorErrores();
    public static void imprimirReporteAlumno(String contenidoReporte) {
        int contador = 0;
        try{
            //Nombre del archivo y la informacion
            File Reporte;
            do {
                String name_reporte = "Reporte_" + contador + ".txt";
                Reporte = new File(name_reporte);
                contador++;
            } while (Reporte.exists());
            
            //crear archivo
            FileWriter fw = new FileWriter(Reporte);
            BufferedWriter bw = new BufferedWriter(fw);
            
            //Encabezado del reporte
            bw.write("=== REPORTE DE ALUMNOS ===\n");
            bw.write("Fecha y Hora: " +java.time.LocalDateTime.now().toString() + "\n");
            bw.write("=========================\n\n");
            // Escribir el contenido del reporte
            bw.write(contenidoReporte);

            // Pie del reporte
            bw.write("\n=== FIN DEL REPORTE ===\n");

            //confirmacion buena
            System.out.println("--------------------------------------");
            System.out.println("MUY BIEN...");
            System.out.println("El reporte se guardo correctamente...");
            System.out.println("Se guardo en: " + Reporte);
            System.out.println("--------------------------------------");

        }catch (IOException error){
            System.err.println("Hubo un error al intentar escribir un nuevo archivo (se está registrando el error en la auditoría)");
            ge1.EscribirAuditoria(error, "Impresión del reporte a un nuevo archivo");
        }
    }
    
    public static void mostrarYguardarReporteAlumno(String contenidoReporte) {
        // Generar el reporte
        
        if (contenidoReporte != null) {
            // Mostrar el reporte en consola
            System.out.println("El reporte se está generando...");
            
            // Preguntar si desea guardar
            imprimirReporteAlumno(contenidoReporte);
        } else {
            System.err.println("No se pudo generar el reporte debido a un error.");
            if (contenidoReporte != null) 
            System.err.println("   Detalles: " + contenidoReporte);
        }
    }
}

