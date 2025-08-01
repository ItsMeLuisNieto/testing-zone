/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Modelo;
// Clase que representa un error registrado en el sistema
public class LogErrores {
    // Atributos que almacenan la información del error
    private int ID;
    private String mensaje;
    private String tipo;
    private String fecha;
    
    // Métodos getter y setter para acceder y modificar los atributos del error
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    // Constructor vacío: útil cuando se desea crear un objeto e ir estableciendo sus atributos después
    public LogErrores() {}
    
    // Constructor que permite crear un objeto LogErrores directamente con sus valores iniciales (excepto el ID)    
    public LogErrores(String mensaje, String tipo, String fecha) {
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    // Método toString para mostrar el error en un formato claro y legible.
    // Este formato puede usarse para imprimir en consola o guardar en archivos de auditoría
    @Override
    public String toString() {
        return String.format("ID: %d ||--> Mensaje: %s | Tipo: %s | Fecha: %s", ID, mensaje, tipo, fecha);
    }
}
