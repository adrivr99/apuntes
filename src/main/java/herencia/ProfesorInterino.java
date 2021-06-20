package herencia;

import java.time.LocalDate;

public class ProfesorInterino extends Profesor implements Comparable <ProfesorInterino>{
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public ProfesorInterino(LocalDate fechaInicio, LocalDate fechaFin, int idProfesor, String nombre, String apellidos, String NIF) {
        super(idProfesor, nombre, apellidos, NIF);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return super.toString() + ", ProfesorInterino: " + "fechaInicio: " + fechaInicio +", fechaFin: " + fechaFin;
    }

    @Override
    // Método para calcular la nómina de los profesores Interinos
    // En el caso de los Interinos su nómina es su sueldoBase + el 30% de su sueldoBase
    public double importeNomina(double sueldoBase) {
        return sueldoBase = sueldoBase + sueldoBase*0.15;
    }

    @Override
    // Método compareTo para comparar los profesores Interinos por la fecha en que iniciaron su trabajo como interino
    public int compareTo(ProfesorInterino p) {
        return this.fechaInicio.compareTo(p.fechaInicio);
    }
}
