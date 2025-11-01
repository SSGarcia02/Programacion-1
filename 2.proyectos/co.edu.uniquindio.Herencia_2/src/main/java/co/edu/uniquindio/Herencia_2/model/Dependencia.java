package co.edu.uniquindio.Herencia_2.model;

import javax.print.Doc;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dependencia {
    private ArrayList<Docente> listaDocentes = new ArrayList();

    public boolean crearDocente(Docente docente){
        Docente docenteEncontrado = obternerDocente(docente.getCedula());
        if(docenteEncontrado == null){
            Docente docenteNuevo = new Docente();
            docenteNuevo.setNombre(docente.getNombre());
            docenteNuevo.setCedula(docente.getCedula());

            getListaDocentes().add(docenteNuevo);

            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Docente> listarDocente(){
        return listaDocentes;
    }

    public boolean editarDocente(Docente docente, int nuevaCedula) {
        Docente docenteEncontrado = obternerDocente(docente.getCedula());
        if(docenteEncontrado != null) {
            // Verificar que la nueva cédula no exista (si es diferente)
            if(docente.getCedula() != nuevaCedula) {
                Docente docenteConNuevaCedula = obternerDocente(nuevaCedula);
                if(docenteConNuevaCedula != null) {
                    return false; // La nueva cédula ya existe
                }
            }
            docenteEncontrado.setNombre(docente.getNombre());
            docenteEncontrado.setCedula(nuevaCedula);
            return true;
        } else {
            return false;
        }
    }
    public boolean borrarDocente(int cedula){
        Docente docenteBorrar = obternerDocente(cedula);
        if(docenteBorrar != null){
            getListaDocentes().remove(docenteBorrar);
            return true;
        }else{
            return false;
        }
    }
    public Docente obternerDocente(int cedula){
        Docente docenteEncontrado = null;
        for(Docente docente : getListaDocentes()){
            if(docente.getCedula() == cedula){
                docenteEncontrado = docente;
                break;
            }
        }
        return docenteEncontrado;
    }


    public double calcularSalarioDocente(int cantidadPuntos){
        int valorPunto = 12120;
        double salarioTotal = cantidadPuntos*valorPunto;

        return salarioTotal;
    }
    public double calcularSalarioDocente(Categoria categoria){
        double salarioTotal = categoria.getSalario();

        return salarioTotal;
    }
    public ArrayList<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(ArrayList<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }


}
