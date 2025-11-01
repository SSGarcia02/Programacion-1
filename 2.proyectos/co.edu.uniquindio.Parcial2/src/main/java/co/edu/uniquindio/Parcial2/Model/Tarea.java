package co.edu.uniquindio.Parcial2.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Tarea {
    private int numTarea;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private long duraciontarea;
    private String descripcion;
    private Empleado empleadoAsociado;
    private Prioridad prioridad;
    private Finca ownedBYFinca;

    public Tarea(){}
    public Tarea(int numTarea, LocalDate fechaInicio, LocalDate fechaFinal,
                 long duraciontarea, String descripcion, Empleado empleadoAsociado) {
        this.numTarea = numTarea;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.duraciontarea = duraciontarea;
        this.descripcion = descripcion;
        this.empleadoAsociado = empleadoAsociado;
    }

    public int getNumTarea() {
        return numTarea;
    }

    public void setNumTarea(int numTarea) {
        this.numTarea = numTarea;
    }

    public LocalDate getHoraInicio() {
        return fechaInicio;
    }

    public void setHoraInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getHoraFinal() {
        return fechaFinal;
    }

    public void setHoraFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public long getDuraciontarea() {
        return duraciontarea;
    }

    public void setDuraciontarea(long duraciontarea) {
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
}
