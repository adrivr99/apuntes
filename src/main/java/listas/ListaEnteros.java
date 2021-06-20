package listas;

import java.util.ArrayList;
import java.util.Collections;

public class ListaEnteros {

    // Creamos la Lista
    private ArrayList<Integer> lista;

    // Constructor sin parametros.
    public ListaEnteros() {
        lista = new ArrayList<>();
    }

    // getter
    public ArrayList<Integer> getLista() {
        return lista;
    }

    // setter
    public void setLista(ArrayList<Integer> lista) {
        this.lista = lista;
    }

    // Método para insertar un elemento en el ArrayList entre 10 y 100
    public boolean insertarElemento(Integer i) {
        if (i >= 10 && i <= 100) {
            lista.add(i);
            return true;
        } else {
            return false;
        }
    }

    // Método para insertar un elemento en la posición pos del ArrayList entre 10 y 100
    public boolean insertarElemento(Integer i, int pos) {
        if (i >= 10 && i <= 100) {
            lista.add(pos, i);
            return true;
        } else {
            return false;
        }
    }

    // Método para cambiar un elemento del ArrayList por otro
    public boolean cambiarElemento(Integer i, int pos) {
        lista.set(pos, i);
        if (lista.get(pos) == i) {
            return true;
        } else {
            return true;
        }
    }

    // Método para obtener un elemento de la posición pos del ArrayList
    public Integer obtenerElemento(int pos) {
        return lista.get(pos);
    }

    // Método para buscar dentro del ArrayList y devuelve la posición en la que se encuentra
    public int buscarElemento(Integer i) {
        return lista.indexOf(i);
    }

    // Método para mostrar por pantalla la lista
    public void mostrar() {
        System.out.println("Lista: " + lista);
    }

    // Método para mostrar la suma de los números pares de la lista
    public void mostrarSumaPares() {
        int suma = 0;
        for (Integer integer : lista) {
            if (integer % 2 == 0) {
                suma += integer;
            }
        }
        System.out.println("Suma números pares: " + suma);

    }

    // Método para mostrar la suma de los números impares de la lista
    public void mostrarSumaImpares() {
        int suma = 0;
        for (Integer integer : lista) {
            if (integer % 2 != 0) {
                suma += integer;
            }
        }
        System.out.println("Suma números impares: " + suma);
    }

    // Método para obtener el número mayor de la lista
    public int getMayor() {
        return Collections.max(lista);
    }

    // Método para obtener el número menor de la lista
    public int getMenor() {
        return Collections.min(lista);
    }

    // Método para borrar un elemento de la lista de posicion pos
    public boolean borrarElemento(int pos) {
        try {
            if ("".equals(lista.get(pos))) {
                return false;
            } else {
                lista.remove(pos);
            }
            return true;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public String toString() {
        return "ListaEnteros{" + "lista=" + lista + '}';
    }

}
