import java.util.Map;

public class Estadistica implements Comparable<Estadistica> {
    private Torneo torneo;
    private Equipo equipo;
    private Integer puntos;
    private Integer golesAFavor;
    private Integer golesEnContra;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private Integer diferenciaDeGol;

    public Estadistica(Torneo torneo, Equipo equipo) {
        this.torneo = torneo;
        this.equipo = equipo;
        puntos = 0;
        golesAFavor = 0;
        golesEnContra = 0;
        partidosGanados = 0;
        partidosEmpatados = 0;
        partidosPerdidos = 0;  
        diferenciaDeGol = 0;
    }

    public void agregarResultados(Map<String, Integer> resultados){
        int golesLocal = 0;
        int golesVisitante= 0;
        partidosJugados ++;
        for (Map.Entry<String, Integer> entry : resultados.entrySet()) {
            if (entry.getKey().equals(equipo.getNombre())) {
                golesLocal = entry.getValue();
                golesAFavor += golesLocal;
            }else{
                golesVisitante = entry.getValue();
                golesEnContra += golesVisitante;
            }
        }
        if (golesLocal > golesVisitante) {
            puntos += 3;
            partidosGanados ++;
        }
        if (golesLocal < golesVisitante) {
            partidosPerdidos ++;
        }
        if (golesLocal == golesVisitante) {
            puntos += 1;
            partidosEmpatados ++;
        }
        diferenciaDeGol = golesAFavor - golesEnContra;
    }

    @Override
    public String toString() {
        String salida = equipo.getNombre() + " | " + partidosJugados + "  | " + puntos + "  | " + partidosGanados + "  | " + partidosEmpatados + "  | " + partidosPerdidos + "  | " + golesAFavor + "  | " + golesEnContra + "  | " + diferenciaDeGol + "  | ";
        return salida;
    }

    @Override
    public int compareTo(Estadistica otro) {
        if (this.puntos == otro.puntos){
            return otro.diferenciaDeGol.compareTo(this.diferenciaDeGol);
        }
        return otro.puntos.compareTo(this.puntos);
    }
}

