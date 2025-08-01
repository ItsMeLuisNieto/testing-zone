package POO_1.Controlador; //declaracion de la clase
import POO_1.Controlador.GestorErrores; //registrar errores,
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;// trabajar con archivos de texto
import java.io.IOException; //manejar errores de entrada/salida,
import POO_1.Modelo.Usuario;//clase que represneta a un usuario dle sistema

public class Archivo { //definicion de la clase
    private static final File[] ARCHIVOS = {new File("usuarios.txt"), new File("auditoria.log"), new File("Datos_abiertos_matriculas_2016_1_2024_1.csv")};
                                           // guarga los registro        // guarda los errores       //contiene la base de datos 
    private static String UsuarioEncontrado; //variable estatico para guardar usuario encontrado en la busqueda 
    private static GestorErrores ge1 = new GestorErrores();// para registrar los errores que ocurran
    
    public static String getUsuarioEncontrado() {//obtener nombre del usuario
        return UsuarioEncontrado;
    }
    
    public static File getArchivo(int index) {//Retorna el archivo que corresponde según la posición
        return ARCHIVOS[index];
    }
                   //(usuario, contraseña o correo) //(0: usuario, 1: contraseña, 2: correo).
    public static boolean EncontrarData(String data, int tipo_dato, int tipo_encuentro) {
                                  //lo que buscas //posición en la línea  //0 para coincidencia exacta, 1 para coincidencia parcial.
        try {
            if(!ARCHIVOS[0].exists()) {
                ARCHIVOS[0].createNewFile(); //Si el archivo de usuarios no existe, lo crea
            }

            FileReader fr = new FileReader(ARCHIVOS[0]);
            BufferedReader br = new BufferedReader(fr);
            //Abre el archivo para leerlo línea por línea.
            
            String linea;
            while ((linea = br.readLine()) != null) { //Recorre cada línea.
                String[] partes = linea.split(","); //se divide con una coma
                
                switch (tipo_encuentro) {
                    case 0 -> { //compara texto literal
                        if(partes[tipo_dato].equals(data)) {
                            if (tipo_dato == 0) {
                                UsuarioEncontrado = partes[tipo_dato];
                            }
                            br.close();
                            return true;
                        }
                    }
                    case 1 -> { //compara ignorando mayúsculas/minúsculas
                        if (partes[tipo_dato].toUpperCase().contains(data.toUpperCase())) {
                            UsuarioEncontrado = partes[tipo_dato];
                            //Si encuentra algo, guarda en UsuarioEncontrado, cierra el archivo y devuelve true.
                            br.close();
                            return true;
                        }
                    }
                }
            }
            br.close();
            return false;
        } catch (IOException error) {
            System.err.println("Hubo un error al intentar crear el archivo de usuarios (se está registrando el error en la auditoría)");
            ge1.EscribirAuditoria(error, "Creación y/o lectura del archivo");
            return false;
        }//Si no encuentra coincidencias, devuelve false.Si ocurre un error, lo muestra y lo guarda en la auditoría.
    }

    public static int EncontrarID() {//Método para contar cuántos errores hay registrados en auditoria.log.
        try {
            if(!ARCHIVOS[1].exists()) {
                ARCHIVOS[1].createNewFile();
            }

            FileReader fr = new FileReader(ARCHIVOS[1]);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                contador++;
            }
            return contador;
        } catch (IOException error) {
            System.err.println("Hubo un error al intentar crear el archivo de usuarios (se está registrando el error en la auditoría)");
            ge1.EscribirAuditoria(error, "Creación y/o lectura del archivo");
            return -1;
        }
        //Si auditoria.log no existe, lo crea.
        //Lee todas las líneas y cuenta cuántas hay.
       //Devuelve el total para usarlo como ID único de error. 
       //Si hay error, lo guarda y devuelve -1.
    
    }
    
    public static void NuevoUsuario(String usuario, String contraseña, String correo) {//Método para crear y guardar un nuevo usuario)
        try {
            if(!ARCHIVOS[0].exists()) {
                ARCHIVOS[0].createNewFile();
            }
            FileWriter fw = new FileWriter(ARCHIVOS[0], true);
            BufferedWriter bw = new BufferedWriter(fw);

            Usuario nuevoUsuario = new Usuario(usuario, contraseña, correo);

            bw.write(nuevoUsuario.toString());
            bw.newLine();

            bw.close();
        } catch (IOException error) {
            System.err.println("Hubo un error en la creación y/o escritura del archivo (se está registrando el error en la auditoría)");
            ge1.EscribirAuditoria(error, "Creación y/o escritura del archivo");
        } finally {
            System.out.println("Volviendo al menú principal...");
        }
        //Si usuarios.txt no existe, lo crea
        //Abre el archivo en modo append para no borrar lo anterior
        //Crea un nuevo objeto Usuario con los datos recibidos.
        //Escribe la información como texto en una línea nueva.
        //Cierra el archivo.
        //Si hay error, lo manda al archivo de auditoría.
        //Siempre muestra el mensaje de retorno al menú.
    }
}
