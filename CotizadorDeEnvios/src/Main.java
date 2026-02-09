import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator calc = new ShippingCalculator();

        System.out.print("Ingrese el peso en Kg (0.1 - 50.0): ");
        double peso = sc.nextDouble();
        System.out.print("Ingrese la distancia en Km (1 - 2000): ");
        int distancia = sc.nextInt();
        System.out.print("¿Que tipo de servicio desea? (1: Estándar, 2: Express): ");
        int servicioNum = sc.nextInt();
        System.out.print("¿Es una zona remota? (true/false): ");
        boolean remoto = sc.nextBoolean();
        String nombreServicio;
        if (servicioNum == 1) {
            nombreServicio = "Estándar";
        } else {
            nombreServicio = "Express";
        }

        double subtotal = calc.calcularSubtotal(peso, distancia, servicioNum, remoto);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva);

        System.out.println("TICKET");
        System.out.println("Tipo de servicio: " + nombreServicio);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Distancia: " + distancia + " km");
        if (remoto == true) {
            System.out.println("Zona remota: Sí");
        } else {
            System.out.println("Zona remota: No");
        }
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("IVA (16%): $" + iva);
        System.out.println("TOTAL A PAGAR: $" + total);
        sc.close();
    }
}