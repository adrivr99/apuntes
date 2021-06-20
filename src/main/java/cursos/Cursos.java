package cursos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class Cursos implements Comparable <Cursos>{
    private String centro;
    private String codigo;
    private String titulo;
    private String modalidad;
    private String estado;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaInicio;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaFin;
    private String dirigidoA;

    public Cursos() {
    }

    public Cursos(String centro, String codigo, String titulo, String modalidad, String estado, LocalDate fechaInicio, LocalDate fechaFin, String dirigidoA) {
        this.centro = centro;
        this.codigo = codigo;
        this.titulo = titulo;
        this.modalidad = modalidad;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.dirigidoA = dirigidoA;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getDirigidoA() {
        return dirigidoA;
    }

    public void setDirigidoA(String dirigidoA) {
        this.dirigidoA = dirigidoA;
    }

    @Override
    public String toString() {
        return "Cursos{" +
                "centro='" + centro + '\'' +
                ", codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", dirigidoA='" + dirigidoA + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cursos curso) {
        if (this.fechaInicio == curso.fechaInicio) {
            return this.titulo.compareTo(curso.titulo);
        } else {
            return this.fechaInicio.compareTo(curso.fechaInicio);
        }
    }
}

