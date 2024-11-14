/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agenciaviajes;

import java.util.Scanner;
/**
 *
 * @author mateo
 */
public class AgenciaViajes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Definir las matrices unidimensionales para trayectos de avión
        String[] avionesOrigen = { "Madrid", "Barcelona", "Sevilla", "Valencia", "Bilbao" };
        String[] avionesDestino = { "Paris", "Londres", "Roma", "Berlin", "Lisboa" };
        double[] avionesPrecios = { 150, 200, 180, 220, 160 };

        // Definir la matriz bidimensional para trayectos de tren
        String[][] trenes = {
            { "Madrid", "Barcelona", "Valencia", "Malaga", "Zaragoza" }, // Origen
            { "Paris", "Lyon", "Marsella", "Toulouse", "Niza" },         // Destino
            { "60", "75", "80", "95", "70" }                             // Precio
        };

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("---- Agencia de Viajes ----");
            System.out.println("1. Ver trayectos de avión");
            System.out.println("2. Ver trayectos de tren");
            System.out.println("3. Calcular precio de billete de avión");
            System.out.println("4. Calcular precio de billete de tren");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción (1-5): ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    mostrarTrayectosAvion(avionesOrigen, avionesDestino, avionesPrecios);
                    break;
                case "2":
                    mostrarTrayectosTren(trenes);
                    break;
                case "3":
                    calcularPrecioAvion(avionesPrecios, sc);
                    break;
                case "4":
                    calcularPrecioTren(trenes[2], sc);
                    break;
                case "5":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
            System.out.println(); // Salto de línea para claridad
        }

        sc.close();
    }

    static void mostrarTrayectosAvion(String[] origenes, String[] destinos, double[] precios) {
        System.out.println("\n---- Trayectos de Avión ----");
        for (int i = 0; i < origenes.length; i++) {
            System.out.println((i + 1) + ". " + origenes[i] + " -> " + destinos[i] + ", Precio: " + precios[i] + "€");
        }
        System.out.println("Número de trayectos disponibles: " + origenes.length);
    }

    static void mostrarTrayectosTren(String[][] trenes) {
        System.out.println("\n---- Trayectos de Tren ----");
        for (int i = 0; i < trenes[0].length; i++) {
            System.out.println((i + 1) + ". " + trenes[0][i] + " -> " + trenes[1][i] + ", Precio: " + trenes[2][i] + "€");
        }
        System.out.println("Número de trayectos disponibles: " + trenes[0].length);
    }

    static void calcularPrecioAvion(double[] precios, Scanner sc) {
        System.out.print("Elige un trayecto de avión (1-5): ");
        int opcion = sc.nextInt() - 1;
        sc.nextLine(); // Limpiar buffer

        if (opcion >= 0 && opcion < precios.length) {
            double precio = precios[opcion];
            precio = aplicarDescuento(precio, sc);
            System.out.println("El precio final del billete de avión es: " + precio + "€");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    static void calcularPrecioTren(String[] precios, Scanner sc) {
        System.out.print("Elige un trayecto de tren (1-5): ");
        int opcion = sc.nextInt() - 1;
        sc.nextLine(); // Limpiar buffer

        if (opcion >= 0 && opcion < precios.length) {
            double precio = Double.parseDouble(precios[opcion]);
            precio = aplicarDescuento(precio, sc);
            System.out.println("El precio final del billete de tren es: " + precio + "€");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    static double aplicarDescuento(double precio, Scanner sc) {
        System.out.print("¿Tienes una tarjeta de puntos? (S/N): ");
        String respuesta = sc.nextLine().toUpperCase();

        if (respuesta.equals("S")) {
            System.out.print("Introduce el número de tarjeta (0 si no tienes): ");
            int tarjeta = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            if (tarjeta > 1000) {
                precio -= 10;
                System.out.println("Se ha aplicado un descuento de 10€.");
            } else {
                System.out.println("No se ha aplicado ningún descuento.");
            }
        }
        return precio;
        
    }
    
}
