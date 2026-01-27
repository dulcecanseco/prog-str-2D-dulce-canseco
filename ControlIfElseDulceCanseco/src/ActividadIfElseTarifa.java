import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa tu edad:  ");
        int edad = scanner.nextInt();

        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida");
            return;
        }

        System.out.print("¿Eres estudiante? si o no: ");
        String respuesta = scanner.next();

        boolean esEstudiante = false;

        if (respuesta.equalsIgnoreCase("si")) {
            esEstudiante = true;
        } else {
            esEstudiante = false;
        }

        int tarifa = 0;

        if (edad < 12) {
            tarifa = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (esEstudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else {

            if (esEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }


        System.out.println("Edad ingresada: " + edad);

        if (esEstudiante) {
            System.out.println("Es estudiante: Sí");
        } else {
            System.out.println("Es estudiante: No");
        }

        System.out.println("Tarifa: $" + tarifa);
    }
}