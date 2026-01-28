import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion;
        double numero1, numero2, resultado;

        System.out.println(" CALCULADORA ");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");

        System.out.print("Elija una opcion: ");
        opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el primer numero: ");
                numero1 = leer.nextDouble();
                System.out.print("Ingrese el segundo numero: ");
                numero2 = leer.nextDouble();
                resultado = numero1 + numero2;
                System.out.println("Operacion elegida: Sumar");
                System.out.println("Valores ingresados: " + numero1 + " y " + numero2);
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                System.out.print("Ingrese el primer numero: ");
                numero1 = leer.nextDouble();
                System.out.print("Ingrese el segundo numero: ");
                numero2 = leer.nextDouble();
                resultado = numero1 - numero2;
                System.out.println("Operacion elegida: Restar");
                System.out.println("Valores ingresados: " + numero1 + " y " + numero2);
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                System.out.print("Ingrese el primer numero: ");
                numero1 = leer.nextDouble();
                System.out.print("Ingrese el segundo numero: ");
                numero2 = leer.nextDouble();
                resultado = numero1 * numero2;
                System.out.println("Operacion elegida: Multiplicar");
                System.out.println("Valores ingresados: " + numero1 + " y " + numero2);
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                System.out.print("Ingrese el primer numero: ");
                numero1 = leer.nextDouble();
                System.out.print("Ingrese el segundo numero: ");
                numero2 = leer.nextDouble();
                System.out.println("Operacion elegida: Dividir");
                System.out.println("Valores ingresados: " + numero1 + " y " + numero2);

                if (numero2 == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = numero1 / numero2;
                    System.out.println("Resultado: " + resultado);
                }
                break;

            default:
                System.out.println("Opción inválida");
                break;
        }

        leer.close();
    }
}