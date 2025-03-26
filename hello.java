import java.util.Scanner; //Importa el escáner, esto sirve para la lectura de texto que ingrese el usuario final

public class hello() {
  public static void main(String[] args) {
    int num;
    int count = 0;
    Scanner lecture = new Scanner(System.in)
    System.out.print("Hola! Ingresa un número para contar juntos: ");
    num = lecture.nextInt();
    do {
      System.out.print("\nEse no es un número válido. Por favor, ingresa solo números enteros positivos: ");
      num = lecture.nextInt();
    } while (num < 1);
    System.out.println("\nExcelente! Vamos a contar del 0 hasta el " + num);
    do {
      System.out.println(count);
    } while (count != num);
    System.out.print("Fin...");
  }
}
