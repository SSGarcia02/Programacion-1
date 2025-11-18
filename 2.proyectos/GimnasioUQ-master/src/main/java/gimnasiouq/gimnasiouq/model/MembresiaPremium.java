package gimnasiouq.gimnasiouq.model;

import java.time.LocalDate;

public class MembresiaPremium extends Membresia {
    private String descripcion;


    public MembresiaPremium(double costo, LocalDate inicio, LocalDate fin) {
        super("Premium", costo, inicio, fin, true);
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public boolean accesoGeneral() { 
        return true; 
    }
    
    public boolean clasesGrupales() { 
        return true; 
    }

    public String obtenerBeneficios() {
        return "• Acceso general al gimnasio\n• Clases grupales ilimitadas";
    }
}
