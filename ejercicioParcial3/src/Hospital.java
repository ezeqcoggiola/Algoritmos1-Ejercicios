import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nombre;
    private List<Profesional> profesionales;
    private List<Paciente> pacientes;
    private List<Receta> recetas;

    public Hospital(String nombre) {
        this.nombre = nombre;
        profesionales = new ArrayList<>();
        pacientes = new ArrayList<>();
        recetas = new ArrayList<>();
    }

    public Profesional registrarProfesional(String nombre, int matricula) {
        Profesional nuevo = new Profesional(nombre, matricula);
        if (profesionales.contains(nuevo)) {
            System.out.println("El profesional " + nombre + " ya está registrado.");
            return profesionales.get(profesionales.indexOf(nuevo));
        }else{
            profesionales.add(nuevo);
            return nuevo;
        }
    }
    
    public Paciente registrarPaciente(String nombre, int dni) {
        Paciente nuevo = new Paciente(nombre, dni);
        if (pacientes.contains(nuevo)) {
            System.out.println("El paciente " + nombre + " ya está registrado.");
            return pacientes.get(pacientes.indexOf(nuevo));
        }else{
            pacientes.add(nuevo);
            return nuevo;
        }
    }

    public Receta cargarReceta(Profesional profesional, Paciente paciente, Estudio[] estudios) {
        Receta nuevo = new Receta(profesional, paciente, estudios);
        recetas.add(nuevo);
        return nuevo;
    }

    public void procesar(Receta receta) {
        if (!(receta.procesada())) {
            receta.procesarEstudios();
        }
    }

    public void mostrarRecetas() {
        String salida = "Recetas de " + nombre + ": \n";
        for (Receta receta : recetas) {
            salida += receta + "\n";
        }
        System.out.println(salida);
    }

    public void mostrarRecetasProcesadas() {
        String salida = "Recetas procesadas de " + nombre + ": \n";
        for (Receta receta : recetas) {
            if(receta.procesada()){
            salida += receta + "\n";
            }
        }
        System.out.println(salida);
    }

    public void mostrarPacientesConEstudios(int i) {
        String salida = "Pacientes con al menos 3 estudios realizados en Pura Salud: \n";
        for (Paciente paciente : pacientes) {
            if (paciente.alMenos(i)){
                salida += paciente + "\n";
            }
        }
        System.out.println(salida);
    }
}
