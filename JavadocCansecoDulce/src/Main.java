import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc;

        do {
            System.out.println("Menu de opciones");
            System.out.println("1) Calcular IMC");
            System.out.println("2) Calcular area de un rectangulo");
            System.out.println("3) Convertir °Celsius a °Fahrenheit");
            System.out.println("4) Calcular area de un circulo");
            System.out.println("5) Salir");

            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    double peso = obtenerDouble(sc, "Ingresa el peso en Kilogramos ");
                    double altura = obtenerDouble(sc, "Ingresa la altura en metros ej: 1.80");
                    double imc = calcularImc(peso, altura);
                    System.out.println("Tu IMC es de: " + imc);
                    break;
                case 2:
                    double base = obtenerDouble(sc, "Ingresa la base: ");
                    double alturaRect = obtenerDouble(sc, "Ingresa la altura: ");
                    double areaRect = calcularAreaRectangulo(base, alturaRect);
                    System.out.println("El area del rectangulo es: " + areaRect);
                    break;
                case 3:
                    double celsius = obtenerDouble(sc, "Ingresa los grados: ");
                    double fahrenheit = conversion(celsius);
                    System.out.println("La conversion de °C a °F es: " + fahrenheit);
                    break;
                case 4:
                    double radio = obtenerDouble(sc, "Ingresa el radio: ");
                    double areaCirc = calcularareaC(radio);
                    System.out.println("El area del circulo es: " + areaCirc);
                    break;
                case 5:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Error");
            }
            System.out.println();

        } while (opc != 5);

        sc.close();
    }

    /**
     * Metodo para solicitar un double.
     * @param sc Scanner
     * @param mensaje lo que se va a mostrar
     * @return valor que el usuario ingresa
     */
    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /**
     * Calcula IMC.
     * @param peso Peso en kilogramos
     * @param altura Altura en metros
     * @return Indice de masa corporal
     */
    public static double calcularImc(double peso, double altura){
        return peso/(altura*altura);
    }

    /**
     * Calcula area de rectangulo.
     * @param base Base
     * @param altura Altura
     * @return Area
     */
    public static double calcularAreaRectangulo(double base, double altura){
        return base*altura;
    }

    /**
     * Convierte Celsius a Fahrenheit.
     * @param celcius Grados C
     * @return Grados F
     */
    public static double conversion(double celcius){
        return (celcius*1.8)+32;
    }

    /**
     * Calcula area de circulo
     * @param radio Radio del circulo
     * @return Area
     */
    public static double calcularareaC(double radio){
        double pi = 3.1416;
        return pi *( radio * radio);
    }
}