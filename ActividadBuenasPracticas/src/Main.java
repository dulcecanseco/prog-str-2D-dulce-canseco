import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroLimite = pedirEntero(scanner);

        int sumaTotal = sumarHastaN(numeroLimite);

        System.out.println("El resultado de la suma de 1 hasta " + numeroLimite + " es: " + sumaTotal);

        scanner.close();
    }

    public static int pedirEntero(Scanner scanner) {
        System.out.print("Ingresa un número (entero): ");
        return scanner.nextInt();
    }

    public static int sumarHastaN(int limite) {
        int suma = 0;
        for (int i = 1; i <= limite; i++) {
            suma += i;
        }
        return suma;
    }
}