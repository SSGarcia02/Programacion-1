package demo_proyectofinal_fx.demoapp.model;

import java.time.LocalDate;

public class MembresiaPremium extends Membresia{
    private String descripcion;

    public MembresiaPremium() {
    }

    public MembresiaPremium(String tipo, double costo, LocalDate fechaInicio, LocalDate fechaFinal, boolean estado, PeriodoMembresia periodoMembresia, String descripcion) {
        super(tipo, costo, fechaInicio, fechaFinal, estado, periodoMembresia);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MembresiaPremium{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
