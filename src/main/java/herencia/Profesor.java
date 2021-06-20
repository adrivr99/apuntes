package herencia;

public abstract class Profesor extends Persona{
    private int idProfesor;

    public Profesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
    // Constructor parametrizado
    public Profesor(int idProfesor, String nombre, String apellidos, String NIF) {
        super(nombre, apellidos, NIF);
        this.idProfesor = idProfesor;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Profesor, " + "idProfesor " + idProfesor;
    }
    // Método abstracto para calcular la nómina de los profesores
    public abstract double importeNomina(double sueldoBase);

}
