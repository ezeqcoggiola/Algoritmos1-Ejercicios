public class Receta {

    enum Estado {
        CARGADA,
        PROCESADA
    }

    private static int idRecetas;
    private Profesional profesional;
    private Paciente paciente;
    private Estudio[] estudios;
    private int idReceta;
    private Estado estado;

    public Receta(Profesional profesional, Paciente paciente, Estudio[] estudios) {
        this.profesional = profesional;
        this.paciente = paciente;
        this.estudios = estudios;
        idRecetas++;
        idReceta = idRecetas;
        estado = Estado.CARGADA;
    }

    public Estado getEstado() {
        return estado;
    }

    public boolean procesada() {
        if (estado.equals(Estado.PROCESADA)){
            return true;
        }else{
            return false;
        }
    }

    public void procesarEstudios() {
        estado = Estado.PROCESADA;
        for (Estudio estudio : estudios) {
            estudio.realizarEstudio();
            paciente.estudioRealizado();
            System.out.println("Notificando a paciente " + paciente + " sobre " + estudio); 
            System.out.println("Notificando a profesional " + profesional + " sobre " + estudio); 
        }
    }

    @Override
    public String toString() {
        String salida = "Receta " + idReceta + ": \n";
        salida += "- Profesional: " + profesional;
        salida += "\n- Paciente: " + paciente;
        salida += "\n- Estado: " + estado;
        salida += "\n- Estudios: ";
        for (Estudio estudio : estudios) {
            salida += "\n - " + estudio;
        }
        return salida;
    }
}
