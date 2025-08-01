package POO_1.Modelo;
// Clase que representa un usuario del sistema con su información básica
public class Usuario {
    // Atributos privados del usuario
    private String usuario;
    private String contraseña;
    private String correo;
    // Constructor para inicializar un objeto Usuario con sus datos
    public Usuario(String usuario, String contraseña, String correo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
    }
    // Métodos getter y setter para acceder o modificar los atributos privados
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    // Método que convierte los datos del usuario a una cadena de texto con formato CSV
    // Esto sirve para guardar fácilmente el usuario en un archivo
    @Override
    public String toString() {
        return String.format("%s,%s,%s", usuario, contraseña, correo);
    }
}
