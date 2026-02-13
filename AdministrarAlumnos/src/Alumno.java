public class Alumno {

    private int id;
    private String name;
    private double promedio;
    private boolean activo;

    public Alumno(){}

        public Alumno(int id, String name){
            this.id=id;
            this.name=name;
            this.promedio=promedio;
            this.activo=true
        }

        public int getId(){
            return id;
        }
        public void setId(int id){
            this.id = id;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
        this.name = name;
        }
        public double getPromedio(){
        return promedio;
        }
        public void setPromedio(double promedio){
        this.promedio = promedio;
        }
        public boolean activo(){
            return activo;
        }
        public void setactivo(boolean activo){
            this.activo = activo;
        }

        @Override
                public String toString(){
            return "Alumno [id= " + id + ", name = " + name + ", promedio =" + promedio +", activo = " + activo + "]";
        }


    }

