import java.time.LocalDate;

public class Donacion implements Comparable<Donacion>{
    private static int idDonaciones = 0;
    private Donante donante;
    private LocalDate fecha;
    private float monto;
    private Estado estado;
    private int id;

    enum Estado{
        PENDIENTE,
        RECHAZADA,
        COBRADA
    }
    
    public Donacion(Donante dt1, LocalDate of, float i) {
        this.donante = dt1;
        this.fecha = of;
        this.monto = i;
        this.estado = Estado.PENDIENTE;
        idDonaciones ++;
        this.id = idDonaciones;
    }

    public void setCobrada() {
        this.estado = Estado.COBRADA;
    }

    public void setRechazada() {
        this.estado = Estado.RECHAZADA;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public float getMonto() {
        return monto;
    }

    @Override
    public int compareTo(Donacion otro) {
        return this.fecha.compareTo(otro.fecha);
    }

    @Override
    public String toString(){
        return "Donación " + id + "\n - Donante: " + donante + "\n - Fecha: " + fecha + "\n - Estado: " + estado + "\n - Monto: " + monto;
    }
}
