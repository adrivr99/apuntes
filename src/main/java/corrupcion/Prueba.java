package corrupcion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static corrupcion.Corrupto.sumarArray;
import static corrupcion.Hacienda.generarTxt;
import static corrupcion.Hacienda.leerTxt;

public class Prueba {
    public static void main(String[] args) throws IOException {
        ArrayList<Corrupto> listaCorruptos = leerTxt("corruptos2021.txt");

        Collections.sort(listaCorruptos);
        listaCorruptos.forEach(System.out::println);

        System.out.println("----------------------------------");
        for (Corrupto listaCorrupto : listaCorruptos) {
            System.out.println(listaCorrupto.getNombre() + " , total de millones: " + sumarArray(listaCorrupto.getMillones()));
        }

        // MAP
        System.out.println("----------------------------------");
        System.out.println("MAP");
        Map<String, Integer> corruptosMap = new HashMap<>();
        for (Corrupto corrupto : listaCorruptos){
            corruptosMap.put(corrupto.getNombre(), sumarArray(corrupto.getMillones()));
        }

        System.out.println(corruptosMap);

        corruptosMap.containsKey("WILLY");

        generarTxt(listaCorruptos);

        System.out.println(buscarCorrupto(corruptosMap));

        // Escribir JSON de corruptos
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapeador.writeValue(new File("./Corruptos.json"), listaCorruptos);

    }

    private static int buscarCorrupto(Map<String, Integer> corruptosMap) {
        Scanner teclado = new Scanner(System.in);
        boolean corruptoTrue = false;
        String corrupto;
        do{
            System.out.println("Introduce el nombre de un corrupto:");
            corrupto = teclado.next();
            if(corruptosMap.containsKey(corrupto)){
                System.out.println(corrupto);
                corruptoTrue = true;
            }

        }while(!corruptoTrue);

        return corruptosMap.get(corrupto);
    }
}
