/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.source.code;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        long a = 0, b = 1, c;
        int total_count = 0;
        
        do {
            System.out.println("Ingrese un numero (mayor que 5 y menor que 32):");
            total_count = lector.nextInt();
        } while (total_count <= 5 || total_count >= 32);
        
        System.out.printf("Excelente! Mostrando los primeros %d numeros de la serie de Fibonacci: \n", total_count);
        for (int another_var = 0; another_var != total_count; another_var++) {
            c = a + b;
            
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            
            a = c + b;
            b = a + c;
        }
    }
}
