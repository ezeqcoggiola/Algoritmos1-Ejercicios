abstract class Estudio {
    enum Estado {
        PENDIENTE,
        REALIZADO
    }

    protected String nombre;
    protected String descripcion;
    protected Estado estado;

    public Estudio(){
    estado = Estado.PENDIENTE;
    }

    public void realizarEstudio(){
        estado = Estado.REALIZADO;
    }

    @Override
    public String toString() {
        return nombre + ": " + descripcion + " (" + estado + ")";
    }
}
