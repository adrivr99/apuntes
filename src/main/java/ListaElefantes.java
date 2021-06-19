import java.util.List;

public class ListaElefantes {

    private int peso;
    private List<Elefantes> elefantes;

    public ListaElefantes() {
    }

    public ListaElefantes(int peso, List<Elefantes> elefantes) {
        this.peso = peso;
        this.elefantes = elefantes;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public List<Elefantes> getElefantes() {
        return elefantes;
    }

    public void setElefantes(List<Elefantes> elefantes) {
        this.elefantes = elefantes;
    }

    @Override
    public String toString() {
        return "Peso tela de araña: " + peso + ", Lista de elefantes: " + elefantes;
    }
}
