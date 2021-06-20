package herencia;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //Creamos una lista para guardar a todos los profesores
        ArrayList <Profesor> lista = new ArrayList<>();
        // Creamos un objeto ListaProfesores para utilizar el método importeTotal
        ListaProfesores listaProfesores = new ListaProfesores();
        // Creamos la lista listaTitulares para guardar en ella los profesores que sean titulares
        // Para luego ordenarlos por fecha
        ArrayList <ProfesorTitular> listaTitulares = new ArrayList<>();


        // Creamos los profesores
        // Añadimos TODOS los profesores a lista
        // Añadimos los titulares a listaTitulares
        ProfesorTitular profesorTitular1 = new ProfesorTitular(LocalDate.of(2019, Month.JANUARY,
                10), 1, "Antonio", "Perez Bonito", "02490685S");
        lista.add(profesorTitular1);
        listaTitulares.add(profesorTitular1);

        ProfesorTitular profesorTitular2 = new ProfesorTitular(LocalDate.of(2015, Month.SEPTEMBER,
                16), 2, "Roberto", "Salmeron Cerdan", "13713075S");
        lista.add(profesorTitular2);
        listaTitulares.add(profesorTitular2);

        ProfesorTitular profesorTitular3 = new ProfesorTitular(LocalDate.of(2017, Month.SEPTEMBER,
                13), 3, "Yasmin", "Duque Zaragoza", "36891237L");
        lista.add(profesorTitular3);
        listaTitulares.add(profesorTitular3);

        ProfesorTitular profesorTitular4 = new ProfesorTitular(LocalDate.of(2020, Month.OCTOBER,
                21), 4, "Rubén", "del Rio Salgado", "39057545A");
        lista.add(profesorTitular4);
        listaTitulares.add(profesorTitular4);

        ProfesorTitular profesorTitular5 = new ProfesorTitular(LocalDate.of(2019, Month.MARCH,
                18), 5, "Raul", "González Blanco", "37131816H");
        lista.add(profesorTitular5);
        listaTitulares.add(profesorTitular5);

        ProfesorInterino profesorInterino1 = new ProfesorInterino(LocalDate.of(2020, Month.APRIL,1),
                LocalDate.of(2020, Month.JUNE, 23),
                6, "Jose Antonio", "Macho", "96718871F");
        lista.add(profesorInterino1);

        ProfesorInterino profesorInterino2 = new ProfesorInterino(LocalDate.of(2021, Month.JANUARY,23),
                LocalDate.of(2021, Month.FEBRUARY, 19),
                7, "Alejandro", "Moreno", "85758268P");
        lista.add(profesorInterino2);

        ProfesorInterino profesorInterino3 = new ProfesorInterino(LocalDate.of(2019, Month.NOVEMBER,7),
                LocalDate.of(2019, Month.DECEMBER, 21),
                8, "Ismael", "Melgar", "49134850L");
        lista.add(profesorInterino3);

        ProfesorInterino profesorInterino4 = new ProfesorInterino(LocalDate.of(2018, Month.OCTOBER,18),
                LocalDate.of(2018, Month.DECEMBER, 1),
                9, "Cristina", "Jimenez", "11150983P");
        lista.add(profesorInterino4);

        ProfesorInterino profesorInterino5 = new ProfesorInterino(LocalDate.of(2021, Month.MAY,1),
                LocalDate.of(2021, Month.JUNE, 21),
                10, "Fernando", "Torres", "61912564Z");
        lista.add(profesorInterino5);

        // Mostramos el listado de todos los profesores
        System.out.println("Lista de Profesores");
        for (Profesor listaAux : lista){
            System.out.println(listaAux);
        }

        // Utilizamos Collection sort para ordenar los profesores por su DNI
        // Utilizamos una expresión lambda
        // Esto hace que x sea un profesor e y sea otro y los compara, y realiza esto con todos para ordenarlos por
        // el atributo que se le indica, en este caso NIF que se obtine con getNif()
        Collections.sort(lista, (x, y) -> x.getNIF().compareToIgnoreCase(y.getNIF()));
        System.out.println("----------------------------------------");
        System.out.println("Lista de Profesores Ordenada por NIF");
        for (Profesor listaAux : lista){
            System.out.println(listaAux);
        }

        System.out.println("----------------------------------------");
        System.out.println("Importe total de las nóminas");
        // Introducimos en el objeto listaProfesores de la clase ListaProfesores el listado de todos los profesores
        // para realizar el método importeTotal
        // como parámetro le pasamos un método leerSueldoBase que pedirá por teclado un sueldo Base que se aplica a todos
        // los profesores
        listaProfesores.setLista(lista);
        System.out.println("Importe total " + listaProfesores.importeTotal(leerSueldoBase()) + " euros");

        System.out.println("----------------------------------------");
        System.out.println("Profesores Titulares");
        // Realizamos un bucle for para listar todos los profesores Titulares
        for (Profesor profesor : lista) {
            // Utilizamos instanceof para determinar que el profesor que pasa en el bucle sea Titular
            // De esta forma filtramos en la lista para obtener los profesores que queremos
            if (profesor instanceof ProfesorTitular) {
                // Obtenemos el nombre del profesor con get(i).getNombre()
                // Luego utilizamos el método diasTrabajados para calcular los días
                System.out.println("Profesor: " + profesor.getNombre() + ", numero de días trabajados: " + listaProfesores.diasTrabajados((ProfesorTitular) profesor));
            }
        }
        System.out.println("----------------------------------------");
        // Ordenamos la lista de profesores titulares (listaTitulares) por fecha que empezaron a trabajar
        Collections.sort(listaTitulares);
        System.out.println("Lista Profesores Titulares Ordenados por Fecha que empezaron a trabajar");
        for (ProfesorTitular listaTitulare : listaTitulares) {
            System.out.println(listaTitulare);
        }
    }
    // Método para introducir por teclado el sueldo base de un profesor
    // Controlando que sea un número y que no sea menor de 0
    private static double leerSueldoBase() {
        boolean exit = false;
        Scanner teclado = new Scanner(System.in);
        double entero = 0;
        do {
            System.out.println("Introduce el sueldo base de un maestro" );
            String texto = teclado.next();
            try {
                entero = Double.parseDouble(texto);
                exit = true;
            } catch (NumberFormatException e) {
                System.out.println("Tiene que ser un número");
            }
            if (entero <= 0) {
                exit = false;
            }
        } while (!exit);
        return entero;
    }
}
