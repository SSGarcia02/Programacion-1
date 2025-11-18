package demo_proyectofinal_fx.demoapp.model;

import java.time.LocalDate;

public class MembresiaVIP extends Membresia{
    private String descripcion = "Membresía VIP: Acceso 24/7, entrenador personal, " +
            "áreas de Spa y todos los beneficios premium.";

    public MembresiaVIP() {
    }
    public MembresiaVIP(String tipo, double costo, LocalDate fechaInicio, LocalDate fechaFinal, boolean estado, PeriodoMembresia periodoMembresia, String descripcion) {
        super(tipo, costo, fechaInicio, fechaFinal, estado, periodoMembresia);
        this.descripcion = "Membresía VIP: Acceso 24/7, entrenador personal, " +
                "áreas de Spa y todos los beneficios premium.";
    }

    public MembresiaVIP(double costo, LocalDate fechaInicio, LocalDate fechaFinal){
        super("VIP", costo, fechaInicio, fechaFinal);
    }

    public String getTipoMembresia(){
        return "VIP";
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MembresiaVIP{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
