package co.edu.uniquindio.Parcial2.Model;

import java.util.ArrayList;

public class Finca {
    private String nombre;
    private ArrayList<Tarea> listaTareas = new ArrayList<>();
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    private ArrayList<Administrador> listaAdmis = new ArrayList<>();
    private ArrayList<Jornalero> listaJornaleros = new ArrayList<>();
    private ArrayList<Recolector> listaRecolectores = new ArrayList<>();

    public Finca(String nombre) {
        this.nombre = nombre;
    }

    public boolean asignarTareaAdmin(Administrador administrador, ArrayList tarea, String cedulaExistente){
        Administrador adminEncontrado = obtenerAdmin(administrador.getCedula());
        if(adminEncontrado != null){
            if(administrador.getCedula() != cedulaExistente){
                Administrador adminExistente = obtenerAdmin(cedulaExistente);
                if(adminExistente != null){
                    return false;
                }
            }
            adminEncontrado.setListaTareaAsociadas(tarea);
            return true;
        }else{
            return false;
        }
    }
    public boolean asignarJornalero(Jornalero jornalero, ArrayList tarea, String cedulaExistente){
        Jornalero jornaleroEncontrado = obtenerJornalero(jornalero.getCedula());
        if(jornaleroEncontrado != null){
            if(jornalero.getCedula() != cedulaExistente){
                Administrador adminExistente = obtenerAdmin(cedulaExistente);
                if(adminExistente != null){
                    return false;
                }
            }
            jornaleroEncontrado.setListaTareaAsociadas(tarea);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Administrador> listarAdmin(){

        return listaAdmis;
    }
    public ArrayList<Empleado> listarEmpleados(){

        return listaEmpleados;
    }
//-----------------------------------------------------
//CRUD Tareas
public ArrayList<Tarea> listarTareas() {

    return listaTareas;
}

    public boolean crearTarea(Tarea tarea) {
        Tarea tareaEncontrado = obtenerTarea(tarea.getNumTarea());
        if (tareaEncontrado == null) {
            Tarea nuevatarea = new Tarea();
            nuevatarea.setNumTarea(tarea.getNumTarea());
            nuevatarea.setHoraInicio(tarea.getHoraInicio());
            nuevatarea.setHoraFinal(tarea.getHoraFinal());
            nuevatarea.setDuraciontarea(tarea.getDuraciontarea());
            nuevatarea.setDescripcion(tarea.getDescripcion());

            getListaTareas().add(nuevatarea);
            return true;
        } else {
            return false;
        }
    }

    public boolean editarTarea(Tarea tarea, int NewTareaNum) {
        Tarea tareaEditar = obtenerTarea(tarea.getNumTarea());
        if (tareaEditar != null) {
            if (tarea.getNumTarea() != NewTareaNum) {
                Tarea tareaConNuevoNumTarea = obtenerTarea(NewTareaNum);
                if (tareaConNuevoNumTarea != null) {
                    return false;
                }
            }
            tareaEditar.setNumTarea(tarea.getNumTarea());
            tareaEditar.setHoraInicio(tarea.getHoraInicio());
            tareaEditar.setHoraFinal(tarea.getHoraFinal());
            tareaEditar.setDuraciontarea(tarea.getDuraciontarea());
            tareaEditar.setDescripcion(tarea.getDescripcion());
            return true;
        } else {
            return false;
        }
    }

    public boolean borrarTarea(int numTarea) {
        Tarea tareaBorrar = obtenerTarea(numTarea);
        if (tareaBorrar != null) {
            getListaTareas().remove(tareaBorrar);
            return true;
        } else {
            return false;
        }
    }

    public Tarea obtenerTarea(int numTarea) {
        Tarea tareaEncontrada = null;
        for (Tarea tarea : getListaTareas()) {
            if (tareaEncontrada.getNumTarea() == numTarea) {
                tareaEncontrada = tarea;
                break;
            }
        }
        return tareaEncontrada;
    }
    public Administrador obtenerAdmin(String cedula){
        Administrador adminEncontrado = null;
        for(Administrador administrador : getListaAdmis()){
            if(administrador.getCedula().equals(cedula)){
                adminEncontrado = administrador;
                break;
            }
        }
        return adminEncontrado;
    }
    public Jornalero obtenerJornalero(String cedula){
        Jornalero jornaleroEncontrado = null;
        for(Jornalero jornalero : getListaJornaleros()){
            if(jornalero.getCedula().equals(cedula)){
                jornaleroEncontrado = jornalero;
                break;
            }
        }
        return jornaleroEncontrado;
    }
    //-----------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(ArrayList<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Administrador> getListaAdmis() {
        return listaAdmis;
    }

    public void setListaAdmis(ArrayList<Administrador> listaAdmis) {
        this.listaAdmis = listaAdmis;
    }

    public ArrayList<Jornalero> getListaJornaleros() {
        return listaJornaleros;
    }

    public void setListaJornaleros(ArrayList<Jornalero> listaJornaleros) {
        this.listaJornaleros = listaJornaleros;
    }

    public ArrayList<Recolector> getListaRecolectores() {
        return listaRecolectores;
    }

    public void setListaRecolectores(ArrayList<Recolector> listaRecolectores) {
        this.listaRecolectores = listaRecolectores;
    }
}
