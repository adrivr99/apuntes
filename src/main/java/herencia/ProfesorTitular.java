package herencia;

import java.time.LocalDate;

public class ProfesorTitular extends Profesor implements Comparable <ProfesorTitular> {
    private LocalDate fechaPosesionTrabajo;

    public ProfesorTitular(LocalDate fechaPosesionTrabajo, int idProfesor, String nombre, String apellidos, String NIF) {
        super(idProfesor, nombre, apellidos, NIF);
        this.fechaPosesionTrabajo = fechaPosesionTrabajo;
    }

    public LocalDate getFechaPosesionTrabajo() {
        return fechaPosesionTrabajo;
    }

    public void setFechaPosesionTrabajo(LocalDate fechaPosesionTrabajo) {
        this.fechaPosesionTrabajo = fechaPosesionTrabajo;
    }

    @Override
    public String toString() {
        return super.toString() + ", ProfesorTitular: " + "fechaPosesionTrabajo: " + fechaPosesionTrabajo;
    }

    @Override
    // Método para calcular la nómina de los profesores Titulares
    // En el caso de los Titulares su nómina es su sueldoBase + el 15% de su sueldoBase
    public double importeNomina(double sueldoBase){
        return sueldoBase = sueldoBase + sueldoBase*0.3;
    }

    @Override
    // Método compareTo para comparar los profesores Titulares por la fecha en que empezaron a trabajar
    public int compareTo(ProfesorTitular p){
        return this.fechaPosesionTrabajo.compareTo(p.fechaPosesionTrabajo);
    }
}
