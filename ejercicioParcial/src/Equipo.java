import java.util.HashMap;
import java.util.Map;

public class Equipo{
    private String nombre;
    private int cantidadFans;
    private Map<Torneo, Estadistica> estadisticas;

    public Equipo(String nombre, int cantidadFans) {
        this.nombre = nombre;
        this.cantidadFans = cantidadFans;
        estadisticas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEstadistica(Torneo torneo) {
        Estadistica nuevo = new Estadistica(torneo, this);
        estadisticas.put(torneo, nuevo);
    }

    public void agregarResultados(Torneo torneo, Map<String, Integer> resultados){
        estadisticas.get(torneo).agregarResultados(resultados);
    }

    public Estadistica mostrarEstadistica(Torneo torneo) {
        return estadisticas.get(torneo);
    }
}