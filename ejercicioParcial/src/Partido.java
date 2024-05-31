import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Partido {

    private String equipoLocal;
    private String equipoVisiitante;
    private LocalDate fecha;
    private int golesLocal;
    private int golesVisitante;

    public Partido(String equipoLocal, String equipoVisiitante, LocalDate fecha, int golesLocal, int golesVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisiitante = equipoVisiitante;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public Map<String, Integer> mostrarResultado(){
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put(equipoLocal, golesLocal);
        mapa.put(equipoVisiitante, golesVisitante);
        return mapa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", " + equipoLocal + " ("+ golesLocal +") - " + equipoVisiitante + " ("+ golesVisitante +")";
    }
}
