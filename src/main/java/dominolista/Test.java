package dominolista;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Comprobar constructor sin parametros, que crea una lista y guarda las fichas
        Domino ficha = new Domino();
        ficha.mostrar();

        System.out.println("--------------------------------------------");

        // Devuelve ficha aleatoria del dominó y la elimina de la estructura
        System.out.println("Ficha sacada: " + ficha.sacarFicha().toString());

        System.out.println("--------------------------------------------");

        // Mostrar Lista sin la ficha eliminada
        ficha.mostrar();

        System.out.println("--------------------------------------------");

        // Meter una ficha en el dominó, si existe no la mete
        // Leemos por teclao la parte superior y la inferior de la ficha
        int num1 = leerEntero(0, 6);
        int num2 = leerEntero(0, 6);
        ficha.meterFicha(new FichaDomino(num1, num2));
        ficha.mostrar();

        System.out.println("--------------------------------------------");

        // Mezclar las fichas
        ficha.mezclarFichas();
        ficha.mostrar();

        System.out.println("--------------------------------------------");
        System.out.println("Quieres jugar? ");
        String respuesta = teclado.next();
        if (respuesta.equalsIgnoreCase("Si")) {
            // Devuelve un número de fichas que se eliminan de la lista y te la dan en mano
            System.out.println("Fichas del jugador: ");
            FichaDomino [] mano = ficha.repartir(7);
            for (FichaDomino manos: mano) {
                System.out.println(manos);
                }
            }

            System.out.println("--------------------------------------------");
        System.out.println("Fichas restantes");
        ficha.mostrar();
        }

    private static int leerEntero(int num1, int num2) {
        boolean exit = true;
        Scanner teclado = new Scanner(System.in);
        int entero = 0;
        do {
            System.out.printf("Introduce un número entre el %d y el %d\n", num1, num2);
            String texto = teclado.next();
            try {
                entero = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Tiene que ser un número");
            }
            if (entero >= num1 && entero <= num2) {
                exit = false;
            }
        } while (exit);
        return entero;
    }
}
