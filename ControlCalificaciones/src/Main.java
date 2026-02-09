import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService servicio = new GradeService();

        String nombre = leerTextoNoVacio(sc, "Ingrse el nombre: ");
        double p1 = leerDoubleEnRango(sc, "Ingrese la calificacion del parcial 1: (0-100)");
        double p2 = leerDoubleEnRango(sc, "Ingrese la calificacion del parcial 2: (0-100)");
        double p3 = leerDoubleEnRango(sc, "Ingrese la calificacion del parcial 3: (0-100)");
        int asistencia = leerIntEnRango(sc, "Asistencia (0-100): ");
        boolean proyecto = leerBoolean(sc, "¿Entregó proyecto? (true/false): ");

        double promedio = servicio.calcularPromedio(p1, p2, p3);
        double califFinal = servicio.calcularFinal(promedio, asistencia);
        String estado = servicio.determinarEstado(califFinal, asistencia, proyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, proyecto, califFinal, estado);

        sc.close();
    }

    public static String leerTextoNoVacio(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.next();
    }
    public static double leerDoubleEnRango(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextDouble();
    }
    public static int leerIntEnRango(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextInt();
    }
    public static boolean leerBoolean(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextBoolean();
    }
    public static void imprimirReporte(String nom, double p1, double p2, double p3,
                                       double prom, int asis, boolean proy, double f, String est) {
        System.out.println("Reporte");
        System.out.println("Nombre del alumno: " + nom);
        System.out.println("Calificacion de los parciales: " + p1 + ", " + p2 + ", " + p3);
        System.out.println("Promedio: " + prom);
        System.out.println("Asistencia: " + asis + "%");

        if (proy == true) {
            System.out.println("Proyecto: Sí");
        } else {
            System.out.println("Proyecto: No");
        }

        System.out.println("Calificacion final: " + f);
        System.out.println("Estas : " + est);
    }
}