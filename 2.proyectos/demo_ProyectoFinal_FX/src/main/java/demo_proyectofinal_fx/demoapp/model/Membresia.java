package demo_proyectofinal_fx.demoapp.model;

import java.time.LocalDate;

public abstract class Membresia {
    private String tipoMembresia;
    private  double costo;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private boolean estado;
    private PeriodoMembresia periodoMembresia;

    public Membresia(){}
    public Membresia(String tipoMembresia, double costo, LocalDate fechaInicio,
                     LocalDate fechaFinal, boolean estado, PeriodoMembresia periodoMembresia) {
        this.tipoMembresia = tipoMembresia;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
        this.periodoMembresia = periodoMembresia;
    }
    public Membresia(String tipoMembresia, double costo, LocalDate fechaInicio,
                     LocalDate fechaFinal){
        this.tipoMembresia = tipoMembresia;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
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
        LocalDate hoy = LocalDate.now();
        return estado &&
                !hoy.isBefore(fechaInicio) &&
                !hoy.isAfter(fechaFinal);
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
