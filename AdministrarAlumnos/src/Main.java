import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Alumno[] lista = new Alumno[25];
        Scanner leer = new Scanner(System.in);
        int opc = 0;
        int cuantosHay = 0; //es el contador

        do {
            System.out.println("MENU");
            System.out.println("1) Alta Alumno");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Actualizar promedio");
            System.out.println("4) Baja logica");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opcion: ");
            opc = leer.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("ID: "); int idIngresado = leer.nextInt();
                    System.out.print("Nombre: "); String nomIngresado = leer.next();
                    System.out.print("Promedio: "); double promIngresado = leer.nextDouble();


                    boolean estaRepetido = false;
                    for (int i = 0; i < cuantosHay; i++) {
                        if (lista[i].id == idIngresado) estaRepetido = true;
                    }

                    if (idIngresado > 0 && promIngresado >= 0 && promIngresado <= 10 && estaRepetido == false) {
                        lista[cuantosHay] = new Alumno(idIngresado, nomIngresado, promIngresado);
                        cuantosHay++;
                        System.out.println("Alta guardada.");
                    } else {
                        System.out.println("Datos mal puestos o ID repetido.");
                    }
                    break;

                case 2:
                    System.out.print("ID a buscar: "); int idBuscar = leer.nextInt();
                    for (int i = 0; i < cuantosHay; i++) {
                        if (lista[i].id == idBuscar && lista[i].activo == true) {
                            System.out.println("Lo encontre: " + lista[i].nombre + " tiene " + lista[i].promedio);
                        }
                    }
                    break;

                case 3:
                    System.out.print("ID para cambiar promedio: "); int idAct = leer.nextInt();
                    for (int i = 0; i < cuantosHay; i++) {
                        if (lista[i].id == idAct && lista[i].activo == true) {
                            System.out.print("Nuevo promedio: ");
                            lista[i].promedio = leer.nextDouble();
                        }
                    }
                    break;

                case 4:
                    System.out.print("ID para borrar: "); int idBorrar = leer.nextInt();
                    for (int i = 0; i < cuantosHay; i++) {
                        if (lista[i].id == idBorrar) {
                            lista[i].activo = false;
                            System.out.println("Alumno borrado.");
                        }
                    }
                    break;

                case 5:
                    for (int i = 0; i < cuantosHay; i++) {
                        if (lista[i].activo == true) {
                            System.out.println(lista[i].id + " " + lista[i].nombre + " " + lista[i].promedio);
                        }
                    }
                    break;

                case 6:
                    double suma = 0; int activos = 0, notaAlta = 0;
                    Alumno elMejor = null; Alumno elPeor = null;

                    for (int i = 0; i < cuantosHay; i++) {
                        if (lista[i].activo == true) {
                            suma = suma + lista[i].promedio;
                            activos = activos + 1;
                            if (lista[i].promedio >= 8.0) notaAlta = notaAlta + 1;

                            if (elMejor == null || lista[i].promedio > elMejor.promedio) elMejor = lista[i];
                            if (elPeor == null || lista[i].promedio < elPeor.promedio) elPeor = lista[i];
                        }
                    }
                    if (activos > 0) {
                        System.out.println("Promedio de todos: " + (suma / activos));
                        System.out.println("El mejor es: " + elMejor.nombre);
                        System.out.println("El peor es: " + elPeor.nombre);
                        System.out.println("Mayores a 8: " + notaAlta);
                    }
                    break;
            }
        } while (opc != 0);
    }
}