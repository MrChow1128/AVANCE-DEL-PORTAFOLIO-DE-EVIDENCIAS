package cr.ac.ucenfotec.bl.entities;

public class Habitacion implements Imprimible {

    private int numero;
    private String tipo;
    private double precioPorNoche;
    private boolean disponible;

    public Habitacion(int numero, String tipo, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public void reservar() {
        disponible = false;
    }

    public void liberar() {
        disponible = true;
    }

    public String generarResumen() {
        return "Habitación #" + numero +
                " | Tipo: " + tipo +
                " | Precio: " + precioPorNoche +
                " | Disponible: " + disponible;
    }

    public String toString() {
        return generarResumen();
    }
}