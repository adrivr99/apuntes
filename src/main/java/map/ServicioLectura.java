package map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ServicioLectura {
    String abecedarioMayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String abecedarioMinus = "abcdefghijklmnopqrstuvwxyz";
    static Random rd = new Random();

    public static ListaElefantes lecturaFicheroJSONObjeto (String ruta){

        ObjectMapper mapeador = new ObjectMapper();

        try{
            return mapeador.readValue(new File(ruta),mapeador.constructType(ListaElefantes.class));
        } catch (IOException ex){
            System.out.println("No se encuentra el archivo");
        }
        return null;
    }

    public static void generarJSONElefantes() throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        List<Elefantes> listaElefantes = new ArrayList<>();
        int numeroElefantes = rd.nextInt(1000)+10;
        for (int i = 0; i < numeroElefantes; i++) {
            Elefantes elefantes = new Elefantes();
            elefantes.setNombre(nombresAleatorios(abecedarioMinus));
            elefantes.setPeso(pesosAleatorios());
            listaElefantes.add(elefantes);
        }
        mapeador.writeValue(new File(nombreJSON() +".json"),
                listaElefantes);
    }

    // Método para general un archivo txt pasando por parametro un objeto Curso
    public static void generarTSV(Map<String, Integer> elefantesMap, String ruta) {
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta, true))) {
            for (Map.Entry<String, Integer> pair : elefantesMap.entrySet()) {
                //flujo.write sirve para escribir en el fichero
                flujo.write(pair.getKey() + "\t" + pair.getValue());
                //flujo.newLine sirve para pasar a la siguiente linea
                flujo.newLine();
            }
            //flujo.flush sirve para liberar el buffer
            flujo.flush();

        } catch (IOException e) {
            System.out.println("No se ha podido introducir");

        }
    }

    public static String nombresAleatorios(String abecedarioMinus){
        String nombre = "";
        for (int i = 0; i < 10; i++) {
            nombre = nombre + abecedarioMinus.charAt(rd.nextInt(abecedarioMinus.length()));
        }
        return nombre;
    }

    public static int pesosAleatorios(){
        int peso = rd.nextInt(120)+1;
        return peso;
    }
    public static String nombreJSON(){
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy_hhmm");
        String directorio = fechaHoraActual.format(formatter);
        return directorio;
    }
}
