import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonaService service = new PersonaService();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(" MENÚ ");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por Id");
            System.out.println("3) Baja logica por id" );
            System.out.println("4) Listar activas" );
            System.out.println("5) Actualizar nombre por id" );
            System.out.println("0) Salir");
            System.out.print("Seleccione una opcion: ");

            while (!sc.hasNextInt()) {
                System.out.println("Error: Ingrese un numero válido.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: "); String nombre = sc.nextLine();

                    if (PersonaService.idEsValido(id) && PersonaService.nombreEsValido(nombre)) {
                        System.out.println(service.registrarPersona(id, nombre));
                    } else {
                        System.out.println("Error: Datos inválidos.");
                    }
                    break;

                case 2:
                    System.out.print("ID a buscar: ");
                    int idB = sc.nextInt(); sc.nextLine();
                    Persona p = service.buscarPorId(idB);
                    if (p != null && p.isSctive()) System.out.println("Encontrado: " + p.getName());
                    else System.out.println("No encontrada o inactiva.");
                    break;

                case 3:
                    System.out.print("ID para baja: ");
                    int idD = sc.nextInt(); sc.nextLine();
                    Persona pb = service.buscarPorId(idD);
                    if (pb != null) {
                        pb.setSctive(false);
                        System.out.println("Baja realizada.");
                    } else System.out.println("Persona no encontrada.");
                    break;

                case 4:
                    service.listarActivas();
                    break;

                case 5:
                    System.out.print("ID a actualizar: ");
                    int idA = sc.nextInt(); sc.nextLine();
                    Persona pa = service.buscarPorId(idA);
                    if (pa != null && pa.isSctive()) {
                        System.out.print("Nuevo nombre: ");
                        String nuevo = sc.nextLine();
                        if (PersonaService.nombreEsValido(nuevo)) {
                            pa.setName(nuevo);
                            System.out.println("Actualizado correctamente.");
                        }
                    } else System.out.println("No disponible.");
                    break;

                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}