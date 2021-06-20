package matrizletras;

import java.util.Arrays;
import java.util.Random;

public class MatrizLetras {
    private final char[][] matriz = new char[10][10];
    Random rd = new Random();
    // String para introducir todas las letras del abecedario en mayuscula
    String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Constructor sin parametros que introduce letras aleatorias dentro de la matriz
    public MatrizLetras() {
    }

    public void llenarAleatoriamente(){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz [i][j] = abecedario.charAt(rd.nextInt(abecedario.length()));
            }
        }
    }

    // Método para imprimir por pantalla la matriz
    public void imprimir() {
        for (char[] chars : matriz) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.printf(" %c ", chars[j]);
            }
            System.out.println();
        }
    }

    // Metodo para ordenar las filas de la matriz de forma alfabetica usando Arrays.sort
    public void ordenar() {
        for (char[] chars : matriz) {
            Arrays.sort(chars);
        }
    }

    // Método para contar el número de veces que se repite un carácter que pasamos como parametro en la matriz
    public int contarCaracter(char x) {
        int contador = 0;
        for (char[] chars : matriz) {
            for (int j = 0; j < matriz.length; j++) {
                // Método asList convierte un Array en un ArrayList
                if (x == chars[j]) {
                    contador++;
                }
            }
        }
        return contador;
    }

    @Override
    public String toString() {
        return "MatrizLetras{" +
                "matriz=" + Arrays.toString(matriz) +
                ", rd=" + rd +
                ", abecedario='" + abecedario + '\'' +
                '}';
    }
}
