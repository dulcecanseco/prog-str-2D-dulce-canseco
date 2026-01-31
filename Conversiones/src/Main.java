import java.util.Scanner;

public class Main {

    static int contadorCelsiusAFahrenheit = 0;
    static int contadorFahrenheitACelsius = 0;
    static int contadorKilometrosAMillas = 0;
    static int contadorMillasAKilometros = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("1) Celsius a Fahrenheit");
            System.out.println("2) Fahrenheit a Celsius");
            System.out.println("3) Kilómetros a Millas");
            System.out.println("4) Millas a Kilómetros");
            System.out.println("5) Salir");

            opcion = pedirNumeroEntero(sc, "Elige una opción (1-5): ");

            switch (opcion) {
                case 1:
                    double gradosCelsius = pedirNumeroDecimal(sc, "Ingresa los grados Celsius: ");
                    double resultadoFahrenheit = (gradosCelsius * 9 / 5) + 32;
                    System.out.println("Resultado: " + gradosCelsius + "°C son " + resultadoFahrenheit + "°F");
                    contadorCelsiusAFahrenheit++;
                    break;

                case 2:
                    double gradosFahrenheit = pedirNumeroDecimal(sc, "Ingresa los grados Fahrenheit: ");
                    double resultadoCelsius = (gradosFahrenheit - 32) * 5 / 9;
                    System.out.println("Resultado: " + gradosFahrenheit + "°F son " + resultadoCelsius + "°C");
                    contadorFahrenheitACelsius++;
                    break;

                case 3:
                    double distanciaKilometros = pedirNumeroDecimal(sc, "Ingresa la distancia en Km: ");
                    double resultadoMillas = distanciaKilometros * 0.621371;
                    System.out.println("Resultado: " + distanciaKilometros + " Km son " + resultadoMillas + " Millas");
                    contadorKilometrosAMillas++;
                    break;

                case 4:
                    double distanciaMillas = pedirNumeroDecimal(sc, "Ingresa las Millas: ");
                    double resultadoKilometros = distanciaMillas / 0.621371;
                    System.out.println("Resultado: " + distanciaMillas + " Millas son " + resultadoKilometros + " Km");
                    contadorMillasAKilometros++;
                    break;

                case 5:
                    int sumaTotal = contadorCelsiusAFahrenheit + contadorFahrenheitACelsius +
                            contadorKilometrosAMillas + contadorMillasAKilometros;

                    System.out.println("Conversiones de C a F: " + contadorCelsiusAFahrenheit);
                    System.out.println("Conversiones de F a C: " + contadorFahrenheitACelsius);
                    System.out.println("Conversiones de Km a Mi: " + contadorKilometrosAMillas);
                    System.out.println("Conversiones de Mi a Km: " + contadorMillasAKilometros);
                    System.out.println("TOTAL DE CONVERSIONES: " + sumaTotal);
                    break;
                default:
                    System.out.println("(!) Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 5);
    }

    public static int pedirNumeroEntero(Scanner sc, String mensaje) {
        int numero = 0;
        boolean datoValido = false;
        while (!datoValido) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(sc.nextLine());
                datoValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número entero.");
            }
        }
        return numero;
    }

    public static double pedirNumeroDecimal(Scanner sc, String mensaje) {
        double numero = 0;
        boolean datoValido = false;
        while (!datoValido) {
            try {
                System.out.print(mensaje);
                numero = Double.parseDouble(sc.nextLine());
                datoValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un valor numérico. ");
            }
        }
        return numero;
    }
}