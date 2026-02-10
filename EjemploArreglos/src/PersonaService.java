public class PersonaService {
    private Persona[] personas = new Persona[20];
    private int contador = 0;

    public static boolean idEsValido(int id) { return id > 0; }
    public static boolean nombreEsValido(String n) { return n != null && !n.trim().isEmpty(); }

    public String registrarPersona(int id, String nombre) {
        if (contador >= 20) return "Error: Sin espacio.";
        for (int i = 0; i < contador; i++) {
            if (personas[i].getId() == id) return "Error: ID repetido.";
        }
        personas[contador++] = new Persona(id, nombre);
        return "Alta exitosa.";
    }

    public Persona buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (personas[i].getId() == id) return personas[i];
        }
        return null;
    }

    public void listarActivas() {
        boolean hay = false;
        for (int i = 0; i < contador; i++) {
            if (personas[i].isSctive()) {
                System.out.println(personas[i]);
                hay = true;
            }
        }
        if (!hay) System.out.println("No hay activas.");
    }
}