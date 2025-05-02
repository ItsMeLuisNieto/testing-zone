/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.source.code;
import java.util.Scanner; //Importa el escáner, esto sirve para la lectura de texto que ingrese el usuario final

public class Hello {
  public static void main(String[] args) {
    int num;
    int count = 0;
    Scanner lecture = new Scanner(System.in);
    System.out.println("Hola! Ingresa un numero para contar juntos: ");
    num = lecture.nextInt();
    while(num < 1) {
      System.out.println("Ese no es un numero valido. Por favor, ingresa solo numeros enteros positivos mayores a 1: ");
      num = lecture.nextInt();
    }
    System.out.println("Excelente! Vamos a contar del 0 hasta el " + num);
    do {
      System.out.println(count);
      count++;
    } while (count != (num + 1));
    System.out.print("Fin...");
  }
}
