public class EstudioRX extends Estudio {
    private String zona;

    public EstudioRX(String zona) {
        this.zona = zona;
        nombre = "RX";
        descripcion = "Estudio de imagen RX de " + zona;
    }
}
