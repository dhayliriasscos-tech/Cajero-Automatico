/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cajerodd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dhayl
 */

public class CajeroAutomaticoArrayList {

    public static void main(String[] args) {

        try (Scanner dd = new Scanner(System.in)) {
            int saldo = 1000000;
            int opcion;
            
            // ArrayList para guardar el historial de movimientos
            ArrayList<String> movimientos = new ArrayList<>();
            
            boolean continuar = true;
            
            while (continuar) {
                // Menú
                System.out.println("\n===== CAJERO AUTOMÁTICO =====");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Retirar efectivo");
                System.out.println("3. Ver historial de movimientos");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = dd.nextInt();
                
                switch (opcion) {
                    
                    case 1:
                        System.out.println("Saldo actual: $" + saldo);
                        movimientos.add("Consulta de saldo: $" + saldo);
                        break;
                        
                    case 2:
                        System.out.print("Ingrese el monto a retirar: ");
                        int retiro = dd.nextInt();
                        
                        if (retiro > saldo) {
                            System.out.println("Fondos insuficientes.");
                            movimientos.add("Intento de retiro fallido: $" + retiro);
                        } else {
                            saldo -= retiro;
                            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                            movimientos.add("Retiro de $" + retiro + " | Saldo restante: $" + saldo);
                        }
                        break;
                        
                    case 3:
                        System.out.println("\n=== HISTORIAL DE MOVIMIENTOS ===");
                        if (movimientos.isEmpty()) {
                            System.out.println("No hay movimientos registrados.");
                        } else {
                            for (String m : movimientos) {
                                System.out.println("- " + m);
                            }
                        }
                        break;
                        
                    case 4:
                        System.out.println("Gracias por usar el cajero. ¡Hasta luego!");
                        continuar = false;
                        break;
                        
                    default:
                        System.out.println("Opcion no válida. Intente de nuevo.");
                        break;
                }
            }
        }
    }
}