package Principal;

import Calculos.Convertidor;

import java.io.IOException;
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        int opcion;


        do {
            System.out.println("*********************************");
            System.out.println("CONVERSOR DE MONEDAS");
            System.out.println("1: Dolar ==> Peso Argentino");
            System.out.println("2: Peso Argentino ==> Dolar");
            System.out.println("3: Dolar ==> Real brasileño");
            System.out.println("4: Real brasileño ==> Dolar");
            System.out.println("5: Dolar ==> Peso colombiano");
            System.out.println("6: Peso colombiano ==> Dolar");
            System.out.println("7: Salir");
            System.out.print("Selecciona una opción: ");

            opcion = lectura.nextInt();

            if (opcion == 7) {
                System.out.println("Programa finalizado.");
                break;
            }

            System.out.print("Ingresa el monto: ");
            double monto = lectura.nextDouble();

            switch (opcion) {
                case 1 -> mostrarResultado("USD", "ARS", monto);
                case 2 -> mostrarResultado("ARS", "USD", monto);
                case 3 -> mostrarResultado("USD", "BRL", monto);
                case 4 -> mostrarResultado("BRL", "USD", monto);
                case 5 -> mostrarResultado("USD", "COP", monto);
                case 6 -> mostrarResultado("COP", "USD", monto);
                default -> System.out.println("Opción no válida");
            }

        } while (true);

        lectura.close();
    }

    private static void mostrarResultado(String base, String destino, double monto) {
        double resultado = Convertidor.convertir(base, destino, monto);
        System.out.printf("Resultado: %.2f %s%n", resultado, destino);
    }
}