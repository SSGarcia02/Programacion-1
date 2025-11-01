package co.edu.uniquindio.Pre_Parcial.punto2;

import java.util.ArrayList;

public class Finca {

    private ArrayList<Tarea> listaTareas = new ArrayList<>();

    private ArrayList<Administrador> listaAdmis = new ArrayList<>();
    private ArrayList<Jornalero> listaJornaleros = new ArrayList<>();
    private ArrayList<Recolector> listaRecolectores = new ArrayList<>();


    public boolean asignarTareaAdmin(Administrador administrador, Tarea tarea, int cedulaExistente){
        Administrador adminEncontrado = obtenerAdmin(administrador.getCedula());
        if(adminEncontrado != null){
            if(administrador.getCedula() != cedulaExistente){
                Administrador adminExistente = obtenerAdmin(cedulaExistente);
                if(adminExistente != null){
                    return false;
                }
            }
            adminEncontrado.setTareaAsociacion(tarea);
            return true;
        }else{
            return false;
        }
    }
    public boolean asignarJornalero(Jornalero jornalero, Tarea tarea, int cedulaExistente){
        Jornalero jornaleroEncontrado = obtenerJornalero(jornalero.getCedula());
        if(jornaleroEncontrado != null){
            if(jornalero.getCedula() != cedulaExistente){
                Administrador adminExistente = obtenerAdmin(cedulaExistente);
                if(adminExistente != null){
                    return false;
                }
            }
            jornaleroEncontrado.setTareaAsociacion(tarea);
            return true;
        }else{
            return false;
        }
    }
    public boolean asignarRecolector(Recolector recolector, Tarea tarea, int cedulaExistente){
        Recolector recolectorEncontrado = obtenerRecolector(recolector.getCedula());
        if(recolectorEncontrado != null){
            if(recolector.getCedula() != cedulaExistente){
                Administrador adminExistente = obtenerAdmin(cedulaExistente);
                if(adminExistente != null){
                    return false;
                }
            }
            recolectorEncontrado.setTareaAsociacion(tarea);
            return true;
        }else{
            return false;
        }
    }

    //CRUD Admin
    public ArrayList<Administrador> listarAdmin(){
        return listaAdmis;
    }
    public boolean crearAdmin(Administrador administrador){
        Administrador adminEncontrado = obtenerAdmin(administrador.getCedula());
        if(adminEncontrado == null){
            Administrador adminNuevo = new Administrador();
            adminNuevo.setNombre(administrador.getNombre());
            adminNuevo.setApellido(administrador.getApellido());
            adminNuevo.setCedula(administrador.getCedula());
            adminNuevo.setEdad(administrador.getEdad());
            adminNuevo.setSalario(administrador.getSalario());
            adminNuevo.setNumeroHorasTrabajo(administrador.getNumeroHorasTrabajo());
            getListaAdmis().add(adminNuevo);

            return true;
        }else{
            return false;
        }

    }
    public boolean editarAdmin(Administrador administrador, int nuevaCedula){
        Administrador adminEncontrado = obtenerAdmin(administrador.getCedula());
        if(adminEncontrado != null){
            if(administrador.getCedula() != nuevaCedula){
                Administrador adminConNuevaCedula = obtenerAdmin(nuevaCedula);
                if(adminConNuevaCedula != null){
                    return false;
                }
            }
            adminEncontrado.setNombre(administrador.getNombre());
            adminEncontrado.setApellido(administrador.getApellido());
            adminEncontrado.setCedula(nuevaCedula);
            adminEncontrado.setEdad(administrador.getEdad());
            adminEncontrado.setSalario(administrador.getSalario());
            adminEncontrado.setNumeroHorasTrabajo(administrador.getNumeroHorasTrabajo());

            return true;
        }else{
            return false;
        }
    }
    public boolean borrarAdmin(int cedula){
        Administrador adminBorrar = obtenerAdmin(cedula);
        if(adminBorrar != null){
            getListaAdmis().remove(adminBorrar);
            return true;
        }else{
            return false;
        }
    }
    //CRUD Jornalero
    public ArrayList<Jornalero> listarJornaleros(){
        return listaJornaleros;
    }
    public boolean crearJornalero(Jornalero jornalero){
        Jornalero jornaleroEncontrado = obtenerJornalero(jornalero.getCedula());
        if(jornaleroEncontrado != null){
            Jornalero nuevoJornalero = new Jornalero();
            nuevoJornalero.setNombre(jornalero.getNombre());
            nuevoJornalero.setApellido(jornalero.getApellido());
            nuevoJornalero.setCedula(jornalero.getCedula());
            nuevoJornalero.setEdad(jornalero.getEdad());
            nuevoJornalero.setSalario(jornalero.getSalario());
            nuevoJornalero.setNumeroHorasTrabajo(jornalero.getNumeroHorasTrabajo());

            getListaJornaleros().add(nuevoJornalero);

            return true;
        }else{
            return false;
        }
    }
    public boolean editarJornalero(Jornalero jornalero, int nuevaCedula){
        Jornalero jornaleroEncontrado = obtenerJornalero(jornalero.getCedula());
        if(jornaleroEncontrado != null){
            if(jornalero.getCedula() != nuevaCedula){
                Jornalero jornaleroConNuevaCedula = obtenerJornalero(nuevaCedula);
                if(jornaleroConNuevaCedula != null){
                    return false;
                }
            }
            jornaleroEncontrado.setNombre(jornalero.getNombre());
            jornaleroEncontrado.setApellido(jornalero.getApellido());
            jornaleroEncontrado.setCedula(nuevaCedula);
            jornaleroEncontrado.setEdad(jornalero.getEdad());
            jornaleroEncontrado.setSalario(jornalero.getSalario());
            jornaleroEncontrado.setNumeroHorasTrabajo(jornalero.getNumeroHorasTrabajo());

            return true;
        }else{
            return false;
        }
    }
    public boolean borrarJornalero(int cedula){
        Jornalero jornaleroBorrar = obtenerJornalero(cedula);
        if(jornaleroBorrar != null){
            getListaJornaleros().remove(jornaleroBorrar);
            return true;
        }else{
            return false;
        }
    }

    //CRUD Recolector
    public ArrayList<Recolector> listarRecolectores(){
        return listaRecolectores;
    }
    public boolean crearRecolector(Recolector recolector){
        Recolector recolectorEncontrado = obtenerRecolector(recolector.getCedula());
        if(recolectorEncontrado == null){
            Recolector nuevoRecolector = new Recolector();
            nuevoRecolector.setNombre(recolector.getNombre());
            nuevoRecolector.setApellido(recolector.getApellido());
            nuevoRecolector.setCedula(recolector.getCedula());
            nuevoRecolector.setEdad(recolector.getEdad());
            nuevoRecolector.setSalario(recolector.getSalario());
            nuevoRecolector.setNumeroHorasTrabajo(recolector.getNumeroHorasTrabajo());

            getListaRecolectores().add(nuevoRecolector);
            return true;
        }else{
            return false;
        }
    }
    public boolean editarRecolector(Recolector recolector, int nuevaCedula){
        Recolector recolectorEditar = obtenerRecolector(recolector.getCedula());
        if(recolectorEditar != null){
            if(recolector.getCedula() != nuevaCedula){
                Recolector recolectorConNuevaCedula = obtenerRecolector(nuevaCedula);
                if(recolectorConNuevaCedula != null){
                    return false;
                }
            }
            recolectorEditar.setNombre(recolector.getNombre());
            recolectorEditar.setApellido(recolector.getApellido());
            recolectorEditar.setCedula(nuevaCedula);
            recolectorEditar.setEdad(recolector.getEdad());
            recolectorEditar.setSalario(recolector.getSalario());
            recolectorEditar.setNumeroHorasTrabajo(recolector.getNumeroHorasTrabajo());
             return true;
        }else{
            return false;
        }
    }
    public boolean borrarRecolector(int cedula){
        Recolector recolectorBorrar = obtenerRecolector(cedula);
        if(recolectorBorrar != null){
            getListaRecolectores().remove(recolectorBorrar);
            return true;
        }else{
            return false;
        }
    }

    //CRUD Tareas
    public ArrayList<Tarea> listarTareas(){
        return listaTareas;
    }
    public boolean crearTarea(Tarea tarea){
        Tarea tareaEncontrado = obtenerTarea(tarea.getNumTarea());
        if(tareaEncontrado == null){
            Tarea nuevatarea = new Tarea();
            nuevatarea.setNumTarea(tarea.getNumTarea());
            nuevatarea.setHoraInicio(tarea.getHoraInicio());
            nuevatarea.setHoraFinal(tarea.getHoraFinal());
            nuevatarea.setDuraciontarea(tarea.getDuraciontarea());
            nuevatarea.setDescripcion(tarea.getDescripcion());

            getListaTareas().add(nuevatarea);
            return true;
        }else{
            return false;
        }
    }
    public boolean editarTarea(Tarea tarea, int NewTareaNum){
        Tarea tareaEditar = obtenerTarea(tarea.getNumTarea());
        if(tareaEditar != null){
            if(tarea.getNumTarea() != NewTareaNum){
                Tarea tareaConNuevoNumTarea = obtenerTarea(NewTareaNum);
                if(tareaConNuevoNumTarea != null){
                    return false;
                }
            }
            tareaEditar.setNumTarea(tarea.getNumTarea());
            tareaEditar.setHoraInicio(tarea.getHoraInicio());
            tareaEditar.setHoraFinal(tarea.getHoraFinal());
            tareaEditar.setDuraciontarea(tarea.getDuraciontarea());
            tareaEditar.setDescripcion(tarea.getDescripcion());
            return true;
        }else{
            return false;
        }
    }
    public boolean borrarTarea(int numTarea){
        Tarea tareaBorrar = obtenerTarea(numTarea);
        if(tareaBorrar != null){
            getListaTareas().remove(tareaBorrar);
            return true;
        }else{
            return false;
        }
    }

    //Obtener los diferentes empleados y Tarea
    public Administrador obtenerAdmin(int cedula){
        Administrador adminEncontrado = null;
        for(Administrador administrador : getListaAdmis()){
            if(administrador.getCedula() == cedula){
                adminEncontrado = administrador;
                break;
            }
        }
        return adminEncontrado;
    }
    public Jornalero obtenerJornalero(int cedula){
        Jornalero jornaleroEncontrado = null;
        for(Jornalero jornalero : getListaJornaleros()){
            if(jornalero.getCedula() == cedula){
                jornaleroEncontrado = jornalero;
                break;
            }
        }
        return jornaleroEncontrado;
    }
    public Recolector obtenerRecolector(int cedula){
        Recolector recolectorEncontrado = null;
        for(Recolector recolector : getListaRecolectores()){
            if(recolector.getCedula() == cedula){
                recolectorEncontrado = recolector;
                break;
            }
        }
        return recolectorEncontrado;
    }
    public Tarea obtenerTarea(int numTarea){
        Tarea tareaEncontrada = null;
        for(Tarea tarea : getListaTareas()){
            if(tareaEncontrada.getNumTarea() == numTarea){
                tareaEncontrada = tarea;
                break;
            }
        }
        return tareaEncontrada;
    }

    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }

    public ArrayList<Administrador> getListaAdmis() {
        return listaAdmis;
    }

    public ArrayList<Jornalero> getListaJornaleros() {
        return listaJornaleros;
    }

    public ArrayList<Recolector> getListaRecolectores() {
        return listaRecolectores;
    }
}
