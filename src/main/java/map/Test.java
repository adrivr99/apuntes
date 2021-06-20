package map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static map.ServicioLectura.*;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("Ejercicio 1");
        ListaElefantes elefantesCaso1 = lecturaFicheroJSONObjeto("caso1.json");
        ListaElefantes elefantesCaso2 = lecturaFicheroJSONObjeto("caso2.json");
        ListaElefantes elefantesCaso3 = lecturaFicheroJSONObjeto("caso3.json");

        System.out.println("Caso1");
        System.out.println(elefantesCaso1);
        System.out.println("------------------------------------------------");
        System.out.println("Caso2");
        System.out.println(elefantesCaso2);
        System.out.println("------------------------------------------------");
        System.out.println("Caso3");
        System.out.println(elefantesCaso3);
        System.out.println("------------------------------------------------");

        System.out.println("Ejercicio 2A");
        System.out.println("Caso1");
        List <Elefantes> listaCeroCien1= listaCeroCien(elefantesCaso1.getElefantes());
        listaCeroCien1.forEach(System.out::println);
        System.out.println("------------------------------------------------");
        System.out.println("Caso2");
        List <Elefantes> listaCeroCien2= listaCeroCien(elefantesCaso2.getElefantes());
        listaCeroCien2.forEach(System.out::println);
        System.out.println("------------------------------------------------");
        System.out.println("Caso3");
        List <Elefantes> listaCeroCien3= listaCeroCien(elefantesCaso3.getElefantes());
        listaCeroCien3.forEach(System.out::println);
        System.out.println("------------------------------------------------");

        System.out.println("Ejercicio 2B");
        System.out.println("Caso1");
        ArrayList <Elefantes> mayor30Caso1= pesoMayor30(elefantesCaso1.getElefantes());
        mayor30Caso1.forEach(System.out::println);
        System.out.println("------------------------------------------------");
        System.out.println("Caso2");
        ArrayList <Elefantes> mayor30Caso2= pesoMayor30(elefantesCaso2.getElefantes());
        mayor30Caso2.forEach(System.out::println);
        System.out.println("------------------------------------------------");
        System.out.println("Caso3");
        ArrayList <Elefantes> mayor30Caso3= pesoMayor30(elefantesCaso3.getElefantes());
        mayor30Caso3.forEach(System.out::println);
        System.out.println("------------------------------------------------");

        System.out.println("Ejercicio 3");
        System.out.println("Caso1");
        List <Elefantes> subirTela1 = subirTela(elefantesCaso1.getElefantes(), elefantesCaso1);
        subirTela1.forEach(System.out::println);
        System.out.println("------------------------------------------------");
        System.out.println("Caso2");
        List <Elefantes> subirTela2 = subirTela(elefantesCaso2.getElefantes(), elefantesCaso2);
        subirTela2.forEach(System.out::println);
        System.out.println("------------------------------------------------");
        System.out.println("Caso3");
        List <Elefantes> subirTela3 = subirTela(elefantesCaso3.getElefantes(), elefantesCaso3);
        subirTela3.forEach(System.out::println);
        System.out.println("------------------------------------------------");

        System.out.println("Ejercicio 4");
        System.out.println("Caso1");
        Map<String, Integer> elefantesMap1 = mapElefantes(elefantesCaso1.getElefantes());
        System.out.println(elefantesMap1);
        System.out.println("------------------------------------------------");
        System.out.println("Caso2");
        Map<String, Integer> elefantesMap2 = mapElefantes(elefantesCaso2.getElefantes());
        System.out.println(elefantesMap2);
        System.out.println("------------------------------------------------");
        System.out.println("Caso3");
        Map<String, Integer> elefantesMap3 = mapElefantes(elefantesCaso3.getElefantes());
        System.out.println(elefantesMap3);
        System.out.println("------------------------------------------------");

        System.out.println("Ejercicio 5");
        // CASO 1
        Map<String, Integer> elefantesTSV1 = mapElefantes(subirTela1);
        generarTSV(elefantesTSV1, "elefantesCaso1.tsv");
       // CASO 2
        Map<String, Integer> elefantesTSV2 = mapElefantes(subirTela2);
        generarTSV(elefantesTSV2, "elefantesCaso2.tsv");
        // CASO 3
        Map<String, Integer> elefantesTSV3 = mapElefantes(subirTela3);
        generarTSV(elefantesTSV3, "elefantesCaso3.tsv");
        System.out.println("------------------------------------------------");

        System.out.println("Ejercicio 6");
        generarJSONElefantes();
    }

    public static List <Elefantes> listaCeroCien (List <Elefantes> listaElefantes){
        List<Elefantes> listaAux = new ArrayList<>();
        for (Elefantes listaElefante : listaElefantes) {
            if (listaElefante.getPeso() >= 0 && listaElefante.getPeso() < 109) {
                listaAux.add(listaElefante);
            }
        }
        return listaAux;
    }

    public static ArrayList <Elefantes> pesoMayor30 (List <Elefantes> listaElefantes){
        ArrayList<Elefantes> listaAux = new ArrayList<>();
        for (Elefantes listaElefante : listaElefantes) {
            if (listaElefante.getPeso() > 30) {
                listaAux.add(listaElefante);
            }
        }
        return listaAux;
    }

    public static List <Elefantes> subirTela (List <Elefantes> listaElefantes, ListaElefantes elefantes){
        List <Elefantes> listaAux = new ArrayList<>();
        listaElefantes = listaCeroCien(listaElefantes);
        int contador = elefantes.getPeso();
        for (Elefantes listaElefante : listaElefantes) {
            if (listaElefante.getPeso() < contador) {
                listaAux.add(listaElefante);
                contador = listaElefante.getPeso() + contador;
            }
        }
        return listaAux;
    }

    public static Map<String, Integer> mapElefantes(List <Elefantes> listaElefantes){
        Map<String, Integer> elefantesMap = new HashMap<>();
        for (Elefantes listaElefante : listaElefantes) {
            elefantesMap.put(listaElefante.getNombre(),
                    listaElefante.getPeso());
        }
        return elefantesMap;
    }
}
