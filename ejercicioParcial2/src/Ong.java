import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ong {
    private String nombre;
    private Set<Donante> donantes;
    private List<Donacion> donaciones;

    public Ong(String nombre){
        this.nombre = nombre;
        donantes = new HashSet<>();
        donaciones = new ArrayList<>();
    }

    public Donante registrarDonante(String nombre, String apellido){
        Donante nuevo = new Donante(nombre, apellido);
        if (donantes.contains(nuevo)){
            System.out.println("Donante ya existente.");
            for (Donante donante : donantes) {
                if (donante.equals(nuevo)){
                    return donante;
                }
            }
        }
        donantes.add(nuevo);
        return nuevo;
    }

    public Donacion cargarDonacion(Donante dt1, LocalDate of, int i) {
        Donacion nuevo = new Donacion(dt1, of, i);
        donaciones.add(nuevo);
        return nuevo;
    }

    public void mostrarDonantes() {
        String salida = "Listado de donantes de " + nombre + "\n";
        for (Donante donante : donantes) {
            salida += donante + "\n";
        }
        System.out.println(salida);
    }

    public void mostrarDonaciones() {
        String salida = "Listado de donaciones de " + nombre + "\n";
        Collections.sort(donaciones);
        for (Donacion donacion : donaciones) {
            salida += donacion + "\n";
        }
        System.out.println(salida);
    }

    public void mostrarResultadoFecha(LocalDate fechaLimite) {
        String salida = "Estado de Resultado de " + nombre + " al " + fechaLimite;
        int cobradas = 0;
        int rechazadas = 0;
        int pendientes = 0;
        float montoTotal = 0;
        float montoMaximo = 0;
        float montoMinimo = 0;
        float montoMedio = 0;

        for (Donacion donacion : donaciones) {
            if (donacion.getFecha().isBefore(fechaLimite) || donacion.getFecha().isEqual(fechaLimite)){
                String estado = donacion.getEstado().toString();
                switch (estado) {
                    case "COBRADA":
                        cobradas ++;
                        if (donacion.getFecha().isBefore(fechaLimite) || donacion.getFecha().isEqual(fechaLimite)){
                            float monto = donacion.getMonto();
                            montoTotal += monto;
                            if (monto > montoMaximo){
                                montoMaximo = monto;
                            } 
                            if (monto < montoMinimo || montoMinimo == 0){
                                montoMinimo = monto;
                            } 
                        }
                        break;
                    case "RECHAZADA":
                        rechazadas++;
                        break;
                    case "PENDIENTE":
                        pendientes++;
                        break;
                }
            }    
        }
        montoMedio = montoTotal/cobradas;
        salida += "\n - Cobradas: " + cobradas + "\n - Rechazadas: " + rechazadas + "\n - Pendientes: " + pendientes + "\n - Monto Total: " + montoTotal + "\n - Monto máximo: " + montoMaximo + "\n - Monto mínimo: " + montoMinimo + "\n - Monto medio: " + montoMedio;
        System.out.println(salida);
    }
}
