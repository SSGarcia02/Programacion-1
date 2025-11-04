package demo_proyectofinal_fx.demoapp.model;

import java.time.LocalDate;

public abstract class Membresia {
    private String tipo;
    private  double costo;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private boolean estado;
    private PeriodoMembresia periodoMembresia;

    public Membresia(){}
    public Membresia(String tipo, double costo, LocalDate fechaInicio,
                     LocalDate fechaFinal, boolean estado, PeriodoMembresia periodoMembresia) {
        this.tipo = tipo;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
        this.periodoMembresia = periodoMembresia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public PeriodoMembresia getPeriodoMembresia() {
        return periodoMembresia;
    }

    public void setPeriodoMembresia(PeriodoMembresia periodoMembresia) {
        this.periodoMembresia = periodoMembresia;
    }
}
