package cursos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import static cursos.Ficheros.*;

public class Test {
    public static void main(String[] args) throws IOException {
        // Leemos el archivo CSV y lo añadimos a una lista
        ArrayList<Cursos> curso = Ficheros.CSVCursos("RegActForCep.csv");

        // Imprimimos por pantalla la lista creada
        System.out.println("Lista");
        curso.forEach(System.out::println);
        System.out.println("----------------------------");

        // Ordenamos la lista por fecha de Inicio
        // En caso de ser la misma fecha ordena por el Título
        Collections.sort(curso);
        //Mostramos lista ordenada
        System.out.println("Lista Ordenada");
        curso.forEach(System.out::println);
        System.out.println("----------------------------");

        // Bucle for para crear objetos Cursos filtrando por los que la fecha de finalización sea antes o durante marzo de 2020
        for (Cursos cursoAux : curso) {
            if (cursoAux.getFechaFin().isBefore(LocalDate.of(2020, 3, 31))) {
                generarTxt(cursoAux);
            }
        }

        // Mostramos por pantalla el txt generado
        System.out.println("archivo txt");
        System.out.println(leerTxt().toString());
        System.out.println("----------------------------");

        // Creamos un archivo JSON a partir de txt
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapeador.writeValue(new File("./CursosAcabados.json"), leerTxt());

        // Mostramos por pantalla el archivo JSON
        System.out.println("archivo JSON");
        System.out.println(leerJSON().toString());
        System.out.println("----------------------------");
    }

}
