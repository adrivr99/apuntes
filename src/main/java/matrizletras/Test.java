package matrizletras;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Creamos la matriz y la imprimimos para mostrar su contenido
        MatrizLetras matriz = new MatrizLetras();
        matriz.llenarAleatoriamente();
        matriz.imprimir();
        System.out.println("-----------------------------");
        // Ordenamos las filas de la matriz e imprimimos el resultado
        matriz.ordenar();
        matriz.imprimir();
        System.out.println("-----------------------------");
        // Creamos una variable char que será la que utilicemos en el método contarCaracter de la clase MatrizLetras
        char caracter = leerLetra();
        System.out.println("Numero de veces que se repite la letra " + caracter + " = " + matriz.contarCaracter(caracter) + " veces");
    }

    // Método para leer una letra por teclado
    private static char leerLetra() {
        Scanner teclado = new Scanner(System.in);
        char letra = ' ';
        String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean entrada;
        // Creamos un do while para que el caracter que se introduzca por teclado sea siempre una letra Mayuscula
        do {
            System.out.println("Introduce una letra del abecedario de A a la Z");
            String texto = teclado.next();
            // Controlamos que el texto introducido sea una letra mayuscula
            // para ello hemos creado un String con todas las letras del abecedario y debe contener la letra que está en la variable texto
            if (abecedario.contains(texto)) {
                letra = texto.charAt(0);
                entrada = true;
            } else {
                System.out.println("Debes introducir una letra MAYUSCULA");
                entrada = false;
            }

        } while (!entrada);
        // Devuelve la letra
        return letra;
    }
}
