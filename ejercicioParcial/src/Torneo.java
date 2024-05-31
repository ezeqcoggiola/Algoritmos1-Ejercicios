import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Torneo {
    private List<Equipo> equipos;
    private List<Partido> partidos;
    private List<Estadistica> estadisticas;    

    public Torneo(){
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
        this.estadisticas = new ArrayList<>();
    }

    public void cargarEquipo(String nombre, int cantidadFans) {
        Equipo nuevo = new Equipo(nombre, cantidadFans);
        equipos.add(nuevo);
        nuevo.agregarEstadistica(this);
        estadisticas.add(nuevo.mostrarEstadistica(this));
    }

    public void cargarPartido(String equipoLocal, String equipoVisitante, LocalDate fecha, int golesLocal, int golesVisitante) {
        Partido nuevo = new Partido(equipoLocal, equipoVisitante, fecha, golesLocal, golesVisitante);
        partidos.add(nuevo);
        for (Equipo equipo : equipos) {
            if (equipo.getNombre() == equipoLocal){
                equipo.agregarResultados(this ,nuevo.mostrarResultado());
            }else if ((equipo.getNombre() == equipoVisitante)){
                equipo.agregarResultados(this ,nuevo.mostrarResultado());
            }
        }
    }

    public void mostrarPartidosFecha(LocalDate fecha) {
        for (Partido partido : partidos) {
            String salida = "";
            if (partido.getFecha().equals(fecha)) {
                salida += partido + "\n";
            }
        System.out.println(salida);
        }
    }

    public void mostrarTabla() {
        String salida = "Equipo | Ju | Pu | Ga | Em | Pe | GF | GC | DG \n";
        Collections.sort(estadisticas);
        for (Estadistica estadistica : estadisticas) {
            salida += estadistica + "\n";
        }
        System.out.println(salida);
    }
}
