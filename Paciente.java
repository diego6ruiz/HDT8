public class Paciente implements Comparable <Paciente> {
    private String nombre;
    private String sintoma;
    private String prioridad;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public  String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    
    @Override
    public  int compareTo(Paciente o) {
        return this.prioridad.compareTo(o.prioridad);
        
    }

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", sintoma=" + sintoma + ", prioridad=" + prioridad + '}';
    }
    
}

