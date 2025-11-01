package co.edu.uniquindio.Pre_Parcial.punto2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Tarea {
    private int numTarea;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private double duraciontarea;
    private String descripcion;

    private Empleado empleadoAsociado;
    private Finca ownedBYFinca;

    public Tarea(){}
    public Tarea(int numTarea, LocalTime horaInicio, LocalTime horaFinal, double duraciontarea, String descripcion) {
        this.numTarea = numTarea;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.duraciontarea = duraciontarea;
        this.descripcion = descripcion;
    }

    public int getNumTarea() {
        return numTarea;
    }

    public void setNumTarea(int numTarea) {
        this.numTarea = numTarea;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public double getDuraciontarea() {
        return duraciontarea;
    }

    public void setDuraciontarea(double duraciontarea) {
        this.duraciontarea = duraciontarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empleado getEmpleadoAsociado() {
        return empleadoAsociado;
    }

    public void setEmpleadoAsociado(Empleado empleadoAsociado) {
        this.empleadoAsociado = empleadoAsociado;
    }

    @Override
    public String toString() {
        return "\n" +
                "ID: " + numTarea + "\n" +
                "Hora de Inicio: " + horaInicio + "\n" +
                "Hora de Cierre: " + horaFinal + "\n" +
                "Duracion: " + duraciontarea + "\n" +
                "Descripcion: " + descripcion + '\n';
    }
}
