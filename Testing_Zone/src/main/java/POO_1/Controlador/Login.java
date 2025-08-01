/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Controlador;
import java.util.Scanner;

public class Login {
    // Valida usuario, contraseña o correo según lo que no sea null
    public static boolean ValidacionRegistro(String usuario, String contraseña, String correo) {
        if (usuario != null) {
            // Usuario: debe tener entre 6 y 20 caracteres (sin espacios al inicio o fin),
            // y no debe estar registrado previamente en el archivo
            if (usuario.trim().isBlank() || usuario.trim().length() < 6 || usuario.trim().length() > 20 || Archivo.EncontrarData(usuario.trim(), 0, 0) == true) {
                return false;
            }
        } else if (contraseña != null) {
            // Contraseña: no debe estar vacía ni registrada,
            // debe tener entre 8 y 25 caracteres, e incluir al menos un número, una letra y un carácter especial
            if (contraseña.trim().isBlank() || Archivo.EncontrarData(contraseña.trim(), 1, 0) == true || !contraseña.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,25}$")) {
                return false;
            }
             // Correo: no debe estar vacío ni registrado,
            // y debe tener un formato válido con dominio permitido (gmail.com, utp.edu.pe, outlook.es)
        } else if (correo != null) {
            if (correo.trim().isBlank() || Archivo.EncontrarData(correo.trim(), 2, 0) == true || !correo.matches("^[a-zA-Z0-9._%+-]+@(gmail\\.com|utp\\.edu\\.pe|outlook\\.es)$")) {
                return false;
            }
        }
        return true;
    }
    // Método que guía al usuario para registrarse paso a paso, validando sus datos
    public static void Registrar() {
        Scanner lector = new Scanner(System.in);
        String usuario, contraseña, correo;
        // Ingreso y validación del nombre de usuario
        do {
            System.out.println("""
                    Pasos para la creación del nombre de usuario ---->
                    1. Debe tener entre 6 y 20 caracteres.
                    2. De contener espacios al inicio o al final, serán eliminados.
                    --------->""");
            System.out.println("Ingrese su nombre de usuario: ");
            usuario = lector.nextLine();
            if (ValidacionRegistro(usuario, null, null) == false) {
                System.err.println("El nombre de usuario no cumple con los requisitos. Por favor, inténtelo de nuevo.");
            }
        } while (ValidacionRegistro(usuario, null, null) == false);
        // Ingreso y validación de la contraseña
        do {
            System.out.println("""
                    Pasos para la creación de tu contraseña ---->
                    1. Debe tener mínimo 8 caracteres y máximo 25.
                    2. De contener espacios al inicio o al final, serán eliminados.
                    3. Debe contener al menos un número, una letra mayúscula y un carácter especial.
                    4. No debe contener espacios.
                    --------->""");
            System.out.println("Ingrese su contraseña: ");
            contraseña = lector.nextLine();
            if (ValidacionRegistro(null, contraseña, null) == false) {
                System.err.println("La contraseña no cumple con los requisitos. Por favor, inténtelo de nuevo.");
            }
        } while (ValidacionRegistro(null, contraseña, null) == false);
        // Ingreso y validación del correo electrónico
        do {
            System.out.println("""
                    Pasos para la creación de tu correo electrónico ---->
                    1. Debe contener un '@' y un dominio válido (gmail.com, utp.edu.pe, outlook.es).
                    2. De contener espacios al inicio o al final, serán eliminados.
                    --------->""");
            System.out.println("Ingrese su dirección de correo electrónico: ");
            correo = lector.nextLine();
            if (ValidacionRegistro(null, null, correo) == false) {
                System.err.println("El correo electrónico no cumple con los requisitos. Por favor, inténtelo de nuevo.");
            }
        } while (ValidacionRegistro(null, null, correo) == false);
        // Si todo es válido, se registra al nuevo usuario
        Archivo.NuevoUsuario(usuario.trim(), contraseña.trim(), correo.trim());
    }
    
    // Método que permite iniciar sesión (login) validando usuario y contraseña
    public static String Login() {
        Scanner lector = new Scanner(System.in);
        String usuario, contraseña;
        int intentos = 0;
        boolean exit1 = false;
        
        // Bucle para validar el nombre de usuario
        while (!exit1) {
            System.out.println("Para regresar al menú, ingrese ESC...");
            System.out.println("Ingrese a continuacion el nombre de usuario: ");
            usuario = lector.nextLine();
            // Opción para salir del login
            if (usuario.toUpperCase().equals("ESC")) {
                return "E";
            }
            
            int opcion;
            // Si no se encuentra el usuario exacto
            if (Archivo.EncontrarData(usuario.trim(), 0, 0) == false) {
                // Si hay una coincidencia parcial o similar
                if (usuario.trim().length() >= 5 && Archivo.EncontrarData(usuario.trim(), 0, 1) == true) {
                    do {
                        // Se pregunta si desea usar el usuario encontrado
                        System.out.println("Hemos encontrado un usuario similar, deseas acceder a esta cuenta: " + Archivo.getUsuarioEncontrado() + "?");
                        System.out.println("""
                                           1. Si, deseo acceder a la cuenta
                                           2. No, deseo volver a ingresar mi usuario""");
                        opcion = lector.nextInt();
                        lector.nextLine();
                    } while (opcion < 1 || opcion > 2);

                    switch (opcion) {
                        case 1 -> {
                            exit1 = true;
                        }
                        case 2 -> {
                            System.out.println("Volviendo al ingreso de usuario:");
                        }
                    }
                } else {
                    // Usuario no válido o muy corto
                    exit1 = false;
                }
            } else if (Archivo.EncontrarData(usuario.trim(), 0, 0) == true) {
                // Si el usuario es exacto, sí existe
                exit1 = true;
            }
        }
        // Bucle para validar la contraseña, permite máximo 5 intentos
        while (true) {
            System.out.println("Para regresar al menú, ingrese ESC...");
            System.out.println("Ingrese a continuacion la contraseña: ");
            contraseña = lector.nextLine();
            
            // Opción para salir
            if(contraseña.toUpperCase().equals("ESC")) {
                return "E";
            }
            // Si la contraseña no es válida
            if (Archivo.EncontrarData(contraseña.trim(), 1, 0) == false) {
                intentos++;
                if (intentos == 5) {
                    // Si falla 5 veces, se bloquea el acceso
                    System.err.println("Has utilizado todos tus intentos restantes. El programa se bloqueara");
                    return "F";
                    
                } else {
                    System.err.println("Has ingresado una contraseña incorrecta. Intentos restantes: " + (5 - intentos));
                }
            } else {
                // Contraseña válida, se rompe el bucle
                break;
            }
        }
        // Si todo fue correcto, se retorna éxito
        return "T";
    }
}