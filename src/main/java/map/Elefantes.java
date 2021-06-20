package map;

public class Elefantes {
    private String nombre;
    private int peso;

    public Elefantes() {
    }

    public Elefantes(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", peso: " + peso;
    }
}
