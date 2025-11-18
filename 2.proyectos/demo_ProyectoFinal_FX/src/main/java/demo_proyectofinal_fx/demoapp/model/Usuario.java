package demo_proyectofinal_fx.demoapp.model;

import java.util.ArrayList;

public class Usuario extends Persona{
    private Membresia membresia;
    private Clase clase;
    private String tipo;
    private ArrayList<Clase> listaClases = new ArrayList<>();

    public Usuario(){}

    public Usuario(String nombre, String apellido, String identificacion, int edad,
                   String telefono, Membresia membresia, String tipo, ArrayList<Clase> listaClases) {
        super(nombre, apellido, identificacion, edad, telefono);
        this.membresia = membresia;
        this.tipo = tipo;
        this.listaClases = listaClases;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }


    public ArrayList<Clase> getListaClases() {
        return listaClases;
    }

    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    public boolean tieneMembresiaActiva() {
        return membresia != null && membresia.isEstado();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
