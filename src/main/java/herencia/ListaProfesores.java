package herencia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ListaProfesores {
    private ArrayList <Profesor> lista = new ArrayList<>();

    // Método para imprimir la lista de profesores
    public void imprimir() {
        for (Profesor listaProfesores : lista) {
            System.out.println(listaProfesores);
        }
    }
    // Método para calcular los días que ha trabajado un profesor titular
    public long diasTrabajados(ProfesorTitular p){
        LocalDate fechaActual = LocalDate.now();
        // ChronoUnit: la diferencia entre dos fechas
        // En este caso la FechaPosesionTrabajo del profesor y la fecha actual
        // Con ello obtenemos el total de días que lleva trabajando
        return ChronoUnit.DAYS.between(p.getFechaPosesionTrabajo(), fechaActual);
    }
    // Método para calcular el importe total de las nóminas de los profesores
    public double importeTotal(double sueldoBase) {
        // Creamos una variable Double total para obtener el total de la suma de las nóminas
        double total = 0;
        // Variable interino para guardar la suma de las nóminas de interinos
        double interino = 0;
        // Variable titular para guardar la suma de las nóminas de interinos
        double titular = 0;
        for (Profesor profesor : lista) {
            // Utilizamos instanceof para determinar si el profesor que pasa en el bucle sea Interino o Titular
            // En este caso si es Titular calcula el importe de la nómina de los Titulares
            // En caso de no serlo calcula el importe de la nómina de los Interinos
            if (profesor instanceof ProfesorTitular){
                // Creamos variable auxiliar para obtener la nómina del profesor y luego ir sumandola a titular
                // Para ello llamamos al metodo de la clase profesor (importeNomina) y le pasamos como parametro el sueldoBase
                double auxTitular = profesor.importeNomina(sueldoBase);
                titular = titular + auxTitular;
            }else {
                // Creamos variable auxiliar para obtener la nómina del profesor y luego ir sumandola a interino
                // Para ello llamamos al metodo de la clase profesor (importeNomina) y le pasamos como parametro el sueldoBase
                double auxInterino = profesor.importeNomina(sueldoBase);
                interino = interino + auxInterino;
            }
            // Sumamos las nóminas a un total que luego devolverá el método
            total = titular + interino;
        }
        return total;
    }

    public ArrayList<Profesor> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Profesor> lista) {
        this.lista = lista;
    }
}
