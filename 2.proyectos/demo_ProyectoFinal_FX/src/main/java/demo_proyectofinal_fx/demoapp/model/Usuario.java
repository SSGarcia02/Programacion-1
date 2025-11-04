package demo_proyectofinal_fx.demoapp.model;

import java.util.ArrayList;

public class Usuario extends Persona{
    private Membresia memebresia;
    private Estudiante estudiante;
    private TrabajadorUQ trabajadorUQ;
    private Externo externo;
    private ArrayList<Clase> listaClases = new ArrayList<>();

    public Usuario(){}

    public Membresia getMemebresia() {
        return memebresia;
    }

    public void setMemebresia(Membresia memebresia) {
        this.memebresia = memebresia;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public TrabajadorUQ getTrabajadorUQ() {
        return trabajadorUQ;
    }

    public void setTrabajadorUQ(TrabajadorUQ trabajadorUQ) {
        this.trabajadorUQ = trabajadorUQ;
    }

    public Externo getExterno() {
        return externo;
    }

    public void setExterno(Externo externo) {
        this.externo = externo;
    }

    public ArrayList<Clase> getListaClases() {
        return listaClases;
    }

    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }
}
