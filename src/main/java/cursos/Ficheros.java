package cursos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ficheros {
    public static ArrayList<Cursos> CSVCursos(String idFichero) {
        // Variables para guardar los datos que se van leyendo
        String[] tokens;

        String linea;
        ArrayList<Cursos> listaCursos = new ArrayList<>();

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                Cursos cursos = new Cursos();
                cursos.setCentro(tokens[0]);
                cursos.setCodigo(tokens[1]);
                cursos.setTitulo(tokens[2]);
                cursos.setModalidad(tokens[3]);
                cursos.setEstado(tokens[4]);
                cursos.setFechaInicio(LocalDate.parse(tokens[5], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                cursos.setFechaFin(LocalDate.parse(tokens[6], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                cursos.setDirigidoA(tokens[7]);
                listaCursos.add(cursos);
            }//, DateTimeFormatter.ofPattern("dd/MM/yyyy"
            return listaCursos;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Método para general un archivo txt pasando por parametro un objeto Curso
    public static void generarTxt(Cursos curso) {
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter("CursosAcabados.txt", true))) {

            //flujo.write sirve para escribir en el fichero
            flujo.write(curso.getTitulo() + "\t" + curso.getFechaFin());
            //flujo.newLine sirve para pasar a la siguiente linea
            flujo.newLine();
            //flujo.flush sirve para liberar el buffer
            flujo.flush();

        } catch (IOException e) {
            System.out.println("No se ha podido introducir");

        }
    }

    public static ArrayList<Cursos> leerJSON() throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        //Llenamos la lista con el fichero JSON.
        // Utilizamos TypeReference para saber de que tipo son los objetos que se van a leer
        ArrayList<Cursos> lista = mapeador.readValue(new File("CursosAcabados.json"), new TypeReference<>() {
        });
        return lista;
    }

    public static ArrayList<Cursos> leerTxt() {
        ArrayList<Cursos> lista = new ArrayList<>();
        String linea;
        String[] tokens;
        try (Scanner datosFichero = new Scanner(new FileReader("CursosAcabados.txt"))) {

            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine(); //Se lee la línea
                tokens = linea.split("\t");
                Cursos objetoCursos = new Cursos();
                objetoCursos.setTitulo(tokens[0]);
                objetoCursos.setFechaFin(LocalDate.parse(tokens[1].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                lista.add(objetoCursos);
            }
            return lista;
        } catch (FileNotFoundException e) {
            return lista;
        }
    }

}
