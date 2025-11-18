package demo_proyectofinal_fx.demoapp.model;

import java.time.LocalDate;

public class MembresiaPremium extends Membresia{
    private String descripcion = "Membresía Premium: Acceso ilimitado, clases grupales, " +
            "áreas premium y descuentos en servicios adicionales.";

    public MembresiaPremium() {
    }

    public MembresiaPremium(String tipo, double costo, LocalDate fechaInicio, LocalDate fechaFinal, boolean estado, PeriodoMembresia periodoMembresia, String descripcion) {
        super(tipo, costo, fechaInicio, fechaFinal, estado, periodoMembresia);
        this.descripcion = "Membresía Premium: Acceso ilimitado, clases grupales, " +
                "áreas premium y descuentos en servicios adicionales.";
    }

    public MembresiaPremium(double costo, LocalDate fechaInicio, LocalDate fechaFinal){
        super("Premium",costo, fechaInicio, fechaFinal);
    }

    public String getTipoMembresia(){
        return "Premium";
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
