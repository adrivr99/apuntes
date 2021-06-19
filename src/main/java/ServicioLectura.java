import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ServicioLectura {

    public static ListaElefantes lecturaFicheroJSONObjeto (String ruta){

        ObjectMapper mapeador = new ObjectMapper();

        try{
            return mapeador.readValue(new File(ruta),mapeador.constructType(ListaElefantes.class));
        } catch (IOException ex){
            System.out.println("No se encuentra el archivo");
        }
        return null;
    }


}
