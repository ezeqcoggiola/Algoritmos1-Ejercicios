import java.util.Objects;

public class Paciente {
    private String nombre;
    private int dni;
    private int cantidadEstudios;

    public Paciente(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
        cantidadEstudios = 0;
    }

    public void estudioRealizado() {
        cantidadEstudios++;
    }

    public boolean alMenos(int i) {
        if (cantidadEstudios >= i){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) {
            return true;
        }

        if (otro == null || this.getClass() != otro.getClass()) {
            return false;
        }

        Paciente otro2 = (Paciente) otro; 
        return this.dni == otro2.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return nombre + " [" + dni + "]";
    }
}
