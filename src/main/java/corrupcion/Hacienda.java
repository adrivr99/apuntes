package corrupcion;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hacienda {
    public static ArrayList<Corrupto> leerTxt(String setRuta) {
        ArrayList<Corrupto> lista = new ArrayList<>();
        String ruta = setRuta;
        String linea;
        String[] tokens;

        try (Scanner datosFichero = new Scanner(new FileReader(ruta))) {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine(); //Se lee la línea
                tokens = linea.split(",");
                int [] numeros = new int[10];
                Corrupto objetoCorrupto = new Corrupto(tokens[0],tokens[1],numeros);
                objetoCorrupto.setApellidos(tokens[0].trim());
                objetoCorrupto.setNombre(tokens[1].trim());
                linea = datosFichero.nextLine();
                tokens = linea.split(",");
                for (int i = 0; i < numeros.length; i++) {
                    try{
                        numeros[i] = Integer.parseInt(tokens[i]);
                    }catch (NumberFormatException nfe){
                        Arrays.toString(numeros);
                    }
                }
                for (int i = 0; i < 1; i++) {
                    numeros[i] = Integer.parseInt(tokens[2]);
                }
                lista.add(objetoCorrupto);
            }
            return lista;
        } catch (FileNotFoundException e) {
            return lista;
        }
    }

    // Método para generar un txt pasando como parámetro una lista
    public static void generarTxt(ArrayList<Corrupto> corruptos) {
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter("corruptos.txt", true))) {

            //flujo.write sirve para escribir en el fichero
            flujo.write(String.valueOf(corruptos));
            //flujo.newLine sirve para pasar a la siguiente linea
            flujo.newLine();
            //flujo.flush sirve para liberar el buffer
            flujo.flush();

        } catch (IOException e) {
            System.out.println("No se ha podido introducir");

        }
    }

}
