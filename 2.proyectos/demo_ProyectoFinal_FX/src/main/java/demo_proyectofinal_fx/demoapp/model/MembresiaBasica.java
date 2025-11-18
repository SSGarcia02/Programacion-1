package demo_proyectofinal_fx.demoapp.model;

import java.time.LocalDate;

public class MembresiaBasica extends Membresia{
    private String descripcion = "Membresía Básica: Acceso a instalaciones en horario regular, " +
            "uso de equipos básicos y áreas comunes.";

    public MembresiaBasica() {
    }

    public MembresiaBasica(String tipo, double costo, LocalDate fechaInicio, LocalDate fechaFinal, boolean estado, PeriodoMembresia periodoMembresia, String descripcion) {
        super(tipo, costo, fechaInicio, fechaFinal, estado, periodoMembresia);
        this.descripcion = "Membresía Básica: Acceso a instalaciones en horario regular, " +
                "uso de equipos básicos y áreas comunes.";
    }
    public MembresiaBasica(double costo, LocalDate fechaInicio, LocalDate fechaFinal){
        super("Basica", costo, fechaInicio, fechaFinal);
    }
    @Override
    public String getTipoMembresia(){
        return "Basica";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MembresiaBasica{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
