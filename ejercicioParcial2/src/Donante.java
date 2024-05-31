import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Donante {
    private static int idDonantes = 0;
    private String nombre;
    private String apellido;
    private int id;
    private static Set<Donante> donantes = new HashSet<>();

    public Donante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        if (!donantes.contains(this)){
            idDonantes ++;
        }
        this.id = idDonantes;
        donantes.add(this);
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) {
            return true;
        }

        if (otro == null || this.getClass() != otro.getClass()) {
            return false;
        }

        Donante otro2 = (Donante) otro; 
        return this.nombre == otro2.nombre && this.apellido == otro2.apellido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }

    @Override
    public String toString() {
        return "(" + id + ") " + apellido + ", " + nombre; 
    }
}
