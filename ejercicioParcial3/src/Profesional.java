import java.util.Objects;

public class Profesional {
    private String nombre;
    private int matricula;
    private Especialidad especialidad;

    public Profesional(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public Profesional(String nombre, int matricula, Especialidad especialidad) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.especialidad = especialidad;
    }
    
    @Override
    public boolean equals(Object otro) {
        if (this == otro) {
            return true;
        }

        if (otro == null || this.getClass() != otro.getClass()) {
            return false;
        }

        Profesional otro2 = (Profesional) otro; 
        return this.matricula == otro2.matricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return nombre + " [" + matricula + "]";
    }
}
