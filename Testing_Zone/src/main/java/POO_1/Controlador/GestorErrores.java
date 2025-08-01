/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Controlador;

import POO_1.Modelo.LogErrores;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestorErrores {
    // Objeto para guardar los datos del error actual
    private LogErrores ErrorActual = new LogErrores();
    
    // Registra errores del tipo IOException en un archivo de auditoría
    public void EscribirAuditoria(IOException error, String motivo) {
        try {
            // Verifica si el archivo de auditoría existe; si no, lo crea
            if(!Archivo.getArchivo(1).exists()) {
                Archivo.getArchivo(1).createNewFile();
            }
            // Prepara los flujos para escribir al final del archivo
            FileWriter fw = new FileWriter(Archivo.getArchivo(1), true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            // Llena el objeto con los datos del error y asigna un ID
            ErrorActual = new LogErrores(error.getMessage(), motivo, java.time.LocalDateTime.now().toString());
            DefinirID();
            
            bw.write(ErrorActual.toString());
            bw.newLine();

            bw.close();
        } catch (IOException newE) {
            System.err.println("Hubo un error en la creación y/o escritura del archivo de auditoría");
        } finally {
            System.out.println("Volviendo al menú principal...");
        }
    }
     // Versión alternativa para registrar errores de tipo Exception (más general)
    public void EscribirAuditoriaMain(Exception error, String motivo) {
        try {
            if(!Archivo.getArchivo(1).exists()) {
                Archivo.getArchivo(1).createNewFile();
            }
            FileWriter fw = new FileWriter(Archivo.getArchivo(1), true);
            BufferedWriter bw = new BufferedWriter(fw);

            ErrorActual = new LogErrores(error.getMessage(), motivo, java.time.LocalDateTime.now().toString());
            DefinirID();
            
            bw.write(ErrorActual.toString());
            bw.newLine();

            bw.close();
        } catch (IOException newE) {
            System.err.println("Hubo un error en la creación y/o escritura del archivo de auditoría");
        }
    }
    // Asigna un ID al error actual según el último disponible en el archivo
    public void DefinirID() {
        if (Archivo.EncontrarID() != -1) {
            ErrorActual.setID(Archivo.EncontrarID());
        } else {
            ErrorActual.setID(0);
        }
    }
}
