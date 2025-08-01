/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Vista;
import POO_1.Controlador.GestorImpresionArchivo;
import POO_1.Controlador.GestorReporteCarrasco;
import POO_1.Controlador.GestorReporteHuamacto;
import POO_1.Controlador.GestorReporteNieto;
import POO_1.Controlador.GestorReporteTtito;
import POO_1.Controlador.GestorReporteWong;
import POO_1.Controlador.GestorErrores;
import POO_1.Controlador.Login;
import POO_1.Controlador.Archivo;
import java.util.Scanner;

public class Matricula {
    public static void main(String[] args) {
        GestorErrores ge1 = new GestorErrores();
        boolean validacion;
        
        try {
            // Prueba del registro e inicio de sesión de usuario
            Scanner lector = new Scanner(System.in);
            String menu = """
                          BIENVENIDO AL PROGRAMA
                          1. Iniciar sesion
                          2. Registrarse""";
            int opcion = -1;
            String resultado = "";
            
            while (true) {
                do {
                    try {
                        // Imprimir el menú
                        System.out.println(menu);
                        opcion = lector.nextInt();
                        validacion = true;
                    } catch (Exception error) {
                        System.err.println("Has ingresado un valor erroneo, vuelve a intentar");
                        ge1.EscribirAuditoriaMain(error, "Mal ingreso de datos por parte del usuario");
                        lector.nextLine();
                        validacion = false;
                    }
                } while (!validacion);

                switch (opcion) {
                    case 1 -> {
                        if ((resultado = Login.Login()).equals("F")) {
                            return;
                        }
                    }
                    case 2 -> {
                        Login.Registrar();
                        System.out.println("Registro completado exitosamente.");
                        System.out.println("Ahora iniciemos sesion con tu nueva cuenta");
                        if((resultado = Login.Login()).equals("F")) {
                            return;
                        }
                    }
                    default -> {
                        System.err.println("Has ingresado un valor incorrecto. Intentalo de nuevo");
                    }
                }
                if(resultado.equals("T")) {
                    break;
                }
            }
            System.out.println("Inicio de sesion exitoso. Bienvenido, " + Archivo.getUsuarioEncontrado() + "!");
            menuReporteyArchivo();
            
        } catch (Exception error) {
            System.err.println("ERROR FATAL. Intente ejecutando nuevamente");
            ge1.EscribirAuditoriaMain(error, "Ejecución del aplicativo");
        }
    }
    
    public static void menuReporteyArchivo(){
        String resultado = null;
        boolean validacion;
        GestorErrores ge1 = new GestorErrores();
        Scanner lector = new Scanner(System.in);
        String menu_reporte = """
                     |==============================================================|    
                     |-------------------------MENU REPORTE-------------------------|                                                 
                     |==============================================================|
                     |1. Reporte 1 (Facultad, Especialidad, Tipo de matricula)      |
                     |2. Reporte 2 (Anio de nacimiento y genero)                    |
                     |3. Reporte 3 (Anio y periodo de ingreso)                      |
                     |4. Reporte 4 (Domicilio)                                      |
                     |5. Reporte 5 (Modalidad de ingreso)                           |
                     |6. Salir                                                      |
                     |==============================================================|                                                             
                         """;
        String menu_archivo = """
                            |==============================================================|    
                            |-------------------------MENU ARCHIVO-------------------------|                                                 
                            |==============================================================|
                            |Deseas generar un archivo de este reporte?                    |
                            |1. Si, imprima un archivo                                     |
                            |2. No, de regreso al menu principal                           |
                            |==============================================================|
                            """;
        System.out.println("Seleccione una opción: ");
        int opcion = -1;
        do {
            do {
                try {
                    // Imprimir el menú
                    System.out.println(menu_reporte);
                    opcion = lector.nextInt();
                    validacion = true;
                } catch (Exception error) {
                    System.err.println("Has ingresado un valor erroneo, vuelve a intentar");
                    ge1.EscribirAuditoriaMain(error, "Mal ingreso de datos por parte del usuario");
                    lector.nextLine();
                    validacion = false;
                }
            } while (!validacion);
            
            lector.nextLine();
            
            switch(opcion){
                case 1 -> {
                    // Reporte de Carrasco
                    // Consiste en la búsqueda por facultad, especialidad y tipo de matrícula
                    String facultad, especialidad, tipoMatricula;
                    System.out.println("Ingrese la Facultad: ");
                    facultad = lector.nextLine();
                    System.out.println("Ingrese la Especialidad: ");
                    especialidad = lector.nextLine();
                    System.out.println("Ingrese el Tipo de Matricula: ");
                    tipoMatricula = lector.nextLine();
                    
                    resultado = GestorReporteCarrasco.generarReporte1(facultad, especialidad, tipoMatricula);
                    System.out.println(resultado);
                }
                case 2 -> { 
                    int anio_nacimiento_inicio, anio_nacimiento_final, sexo = -1;
                    String menu = """
                                  1. Masculino
                                  2. Femenino""";
                    do {
                        System.out.println("Ingrese el anio donde desea iniciar el reporte (1970 - 2010): ");
                        anio_nacimiento_inicio = lector.nextInt();
                    } while(anio_nacimiento_inicio < 1970 || anio_nacimiento_inicio > 2010);
                    
                    do {
                        System.out.println("Ingrese el anio donde desea finalizar el reporte: ");
                        anio_nacimiento_final = lector.nextInt();
                    } while (anio_nacimiento_final < 1970 || anio_nacimiento_final > 2010 || anio_nacimiento_final < anio_nacimiento_inicio);
                    
                    do {
                        do {
                            try {
                                // Imprimir el menú
                                System.out.println(menu);
                                System.out.println("Ingrese el genero a filtrar: ");
                                sexo = lector.nextInt();
                                validacion = true;
                            } catch (Exception error) {
                                System.err.println("Has ingresado un valor erroneo, vuelve a intentar");
                                ge1.EscribirAuditoriaMain(error, "Mal ingreso de datos por parte del usuario");
                                lector.nextLine();
                                validacion = false;
                            }
                        } while (!validacion);
                    } while (sexo < 1 || sexo > 2);
                    
                    resultado = GestorReporteHuamacto.GenerarReporte2(anio_nacimiento_inicio, anio_nacimiento_final, sexo);
                    System.out.println(resultado);
                }
                case 3 -> { 
                    // Reporte de Nieto
                    // Consiste en la búsqueda por año y periodo de ingreso
                    int año_inicio, año_fin, periodo_inicio, periodo_fin;
                    
                    do {
                        System.out.println("Ingrese el anio donde desea iniciar el reporte (2016 - 2024): ");
                        año_inicio = lector.nextInt();
                    } while(año_inicio < 2016 || año_inicio > 2024);
                    
                    do {
                    System.out.println("Ingrese el periodo de inicio (1 o 2): ");
                    periodo_inicio = lector.nextInt();
                    } while (periodo_inicio < 1 || periodo_inicio > 2 || (año_inicio == 2024 && periodo_inicio == 2));
                    
                    do {
                        System.out.println("Ingrese el anio donde desea finalizar el reporte (" + año_inicio + " - 2024): ");
                        año_fin = lector.nextInt();
                    } while(año_fin < año_inicio || año_fin < 2016 || año_fin > 2024);
                    
                    do {
                        System.out.println("Ingrese el periodo final (1 o 2): ");
                        periodo_fin = lector.nextInt();
                    } while (periodo_fin < 1 || periodo_fin > 2 || (año_fin == 2024 && periodo_fin == 2));

                    resultado = GestorReporteNieto.GenerarReporte3(año_inicio, año_fin, periodo_inicio, periodo_fin);
                    System.out.println(resultado);
                }
                case 4 -> {
                    String distrito;
                    do {
                        // Pedimos al usuario que ingrese el distrito de domicilio
                        System.out.println("Ingrese el distrito de domicilio:");
                        distrito = lector.nextLine();
                    } while (distrito.isEmpty());
                    
                    resultado = GestorReporteTtito.GenerarReporte4(distrito); 
                    System.out.println(resultado);
                }
                case 5 -> { 
                    int modalidad = -1;
                    String menu = """
                                  1. Ordinario
                                  2. Ingreso directo
                                  3. Ingreso directo CEPRE
                                  4. Dos primeros alumnos
                                  5. Concurso nacional escolar
                                  6. Ingreso escolar nacional
                                  7. Ingreso directo CEPRE-UNI
                                  8. Traslado externo
                                  9. Titulados o graduados en la UNI
                                  10. Victimas de terrorismo""";

                    do {
                        System.out.println("===============================================");
                        System.out.println(" FILTRO DE ALUMNOS POR MODALIDAD ");
                        System.out.println("===============================================\n");

                        System.out.println("Ejemplos válidos de Modalidad de Formación:");
                        do {
                            try {
                                // Imprimir el menú
                                System.out.println(menu);
                                System.out.print("Ingrese la Modalidad de Formación exacta: ");
                                modalidad = lector.nextInt();
                                validacion = true;
                            } catch (Exception error) {
                                System.err.println("Has ingresado un valor erroneo, vuelve a intentar");
                                ge1.EscribirAuditoriaMain(error, "Mal ingreso de datos por parte del usuario");
                                lector.nextLine();
                                validacion = false;
                            }
                        } while (!validacion);
                    } while (modalidad < 1 || modalidad > 10);
                    System.out.println("\nGenerando reporte, por favor espere...\n");

                    // Llamada al método de reporte
                    resultado = GestorReporteWong.GenerarReporte5(modalidad);

                    // Mostrar el resultado en consola
                    System.out.println(resultado);
                }
                case 6 -> {
                    // Sale del programa
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    return;
                }
                default -> { 
                    System.err.println("Opción no válida. Intente nuevamente...");
                    break;
                }
            }
            if (resultado != null) {
                do {
                    do {
                        try {
                            // Imprimir el menú
                            System.out.println(menu_archivo);
                            opcion = lector.nextInt();
                            validacion = true;
                        } catch (Exception error) {
                            System.err.println("Has ingresado un valor erroneo, vuelve a intentar");
                            ge1.EscribirAuditoriaMain(error, "Mal ingreso de datos por parte del usuario");
                            lector.nextLine();
                            validacion = false;
                        }
                    } while (!validacion);
                } while(opcion < 1 || opcion > 2);
                
                switch (opcion) {
                    case 1 -> {
                        GestorImpresionArchivo.mostrarYguardarReporteAlumno(resultado);
                    }
                    case 2 -> {
                        System.out.println("Volviendo al menú principal...");
                    }
                }
            }
        } while (true);
    }
}
