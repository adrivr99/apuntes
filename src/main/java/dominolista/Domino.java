package dominolista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Domino {

    private final ArrayList<FichaDomino> lista = new ArrayList<>();

    public Domino() {

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (!checkExists(i, j)) {
                    lista.add(new FichaDomino(i, j));
                }
            }
        }
    }

    // Método que guarda la ficha f en el dominó, si existe no la guarda.
    public void meterFicha(FichaDomino f) {
        if (!checkExists(f)) {
            lista.add(f);
        }
    }

    // Método que elimina una ficha aleatoria
    public FichaDomino sacarFicha() {
        Random rd = new Random();
        if (lista.size() == 0) {
            return null;

        }
        int aux = rd.nextInt(lista.size());
        if (aux != 0) {
            aux--;
        }
        FichaDomino fichaActual = lista.get(aux);
        lista.remove(aux);

        return fichaActual;
    }

    // Método para mezclar las fichas de la lista
    public void mezclarFichas() {
        Collections.shuffle(lista);
    }

    // Método para repartir n número de fichas y meterlas en un ArrayList
    public FichaDomino [] repartir(int n) {
        if (lista.size() >= n ) {
            FichaDomino[] mano = new FichaDomino[n];
            for (int i = 0; i < n; i++) {
                mano[i] = sacarFicha();
            }
            return mano;
        }
        return null;
    }

    // Método para mostrar el lista de las fichas y un sout último que muestra las fichas que quedan
    public void mostrar() {
        for (FichaDomino ficha : lista) {
            System.out.println(ficha);
        }
        System.out.println("\nQuedan " + lista.size() + " fichas");
    }

    // Método para comprobar si existe una ficha pasando sus valores [num1 | num2]
    public boolean checkExists(int num1, int num2) {
        boolean b = false;
        for (FichaDomino ficha : lista) {
            if (!b) {
                b = ficha.getInferior() == num1 && ficha.getSuperior() == num2
                        || ficha.getInferior() == num2 && ficha.getSuperior() == num1;
            }
        }
        return b;
    }

    // Método para comprobar si existe una ficha pasando una ficha de FichaDomino (Sobrecarga del método anterior)
    public boolean checkExists(FichaDomino f) {
        boolean b = false;
        for (FichaDomino ficha : lista) {
            if (!b) {
                b = ficha.getInferior() == f.getInferior() && ficha.getSuperior() == f.getSuperior()
                        || ficha.getInferior() == f.getSuperior() && ficha.getSuperior() == f.getInferior();
            }
        }
        return b;
    }

    @Override
    public String toString() {
        return "Domino{" + "lista=" + lista + '}';
    }

}
