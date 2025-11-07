package demo_proyectofinal_fx.demoapp.model;

import java.util.ArrayList;
import java.util.Objects;

public class Gimnasio {
    private String nombre;
    private ArrayList<Persona> listaPersonas = new ArrayList<>();
    private ArrayList<Plan> listaPlan = new ArrayList<>();
    private ArrayList<Reserva> listaReserva = new ArrayList<>();
    private ArrayList<Membresia> listamembresia = new ArrayList<>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private  ArrayList<Clase> liistaClases = new ArrayList<>();
    private ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();
    private Administrador administrador;

    public Gimnasio(){}

    public Gimnasio(String nombre) {
        this.nombre = nombre;
    }


    public ArrayList<Usuario> mostrarUsuarios(){
        return listaUsuarios;
    }

    public Usuario crearUsuario(Usuario usuario){
        Usuario usuarioEncontrado = obtenerUsuario(usuario.getIdentificacion());
        if(usuarioEncontrado == null){
            Usuario usuarioNuevo = new Usuario();
            usuarioNuevo.setNombre(usuario.getNombre());
            usuarioNuevo.setApellido(usuario.getApellido());
            usuarioNuevo.setEdad(usuario.getEdad());
            usuarioNuevo.setTelefono(usuario.getTelefono());
            usuarioNuevo.setIdentificacion(usuario.getIdentificacion());

            getListaUsuarios().add(usuario);

            return usuario;
        }else{
            return null;
        }
    }
    public boolean borrarusuario(String identificacion){
        Usuario usuarioBorrar = obtenerUsuario(identificacion);
        if(usuarioBorrar != null){
            getListaUsuarios().remove(usuarioBorrar);
            return true;
        }
        return false;
    }
    public boolean actualizarUsuario(Usuario usuario, String nuevaIdentificaacion){
        Usuario usuarioEditar = obtenerUsuario(nuevaIdentificaacion);

        if (usuarioEditar != null) {
            if (!Objects.equals(usuario.getIdentificacion(), nuevaIdentificaacion)){
                Usuario usuarioNuevoID = obtenerUsuario(nuevaIdentificaacion);
                if(usuarioNuevoID != null){
                    return false;
                }
            }

            usuarioEditar.setNombre(usuario.getNombre());
            usuarioEditar.setApellido(usuario.getApellido());
            usuarioEditar.setIdentificacion(usuario.getIdentificacion());
            usuarioEditar.setEdad(usuario.getEdad());
            usuarioEditar.setTelefono(usuario.getTelefono());

            return true;
        }

        return false;
    }

    public Usuario obtenerUsuario(String identificacion){
        Usuario usuarioEncontrado = null;
        for(Usuario persona : getListaUsuarios()){
            if(persona.getIdentificacion().equals(identificacion) && persona instanceof Usuario){
                usuarioEncontrado = persona;
                break;
            }
        }
        return usuarioEncontrado;
    }

    public Clase obtenerClase(String nombreClase){
        Clase clase = null;
        for(int i=0;i<getLiistaClases().size();i++){
            if(getLiistaClases().get(i).getNombre().equals(nombreClase)){
                clase = getLiistaClases().get(i);
            }
        }
        return clase;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public ArrayList<Plan> getListaPlan() {
        return listaPlan;
    }

    public void setListaPlan(ArrayList<Plan> listaPlan) {
        this.listaPlan = listaPlan;
    }

    public ArrayList<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(ArrayList<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public ArrayList<Membresia> getListamembresia() {
        return listamembresia;
    }

    public void setListamembresia(ArrayList<Membresia> listamembresia) {
        this.listamembresia = listamembresia;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Clase> getLiistaClases() {
        return liistaClases;
    }

    public void setLiistaClases(ArrayList<Clase> liistaClases) {
        this.liistaClases = liistaClases;
    }

    public ArrayList<Entrenador> getListaEntrenadores() {
        return listaEntrenadores;
    }

    public void setListaEntrenadores(ArrayList<Entrenador> listaEntrenadores) {
        this.listaEntrenadores = listaEntrenadores;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public boolean eliminarEntrenador(String idEntrenador) {
        for (Persona persona : listaPersonas) {
            if (persona instanceof Administrador admin) {
                return admin.eliminarEntrenador(idEntrenador);
            }
        }

        System.out.println("❌ No existe administrador en el gimnasio.");
        return false;
    }
    public Entrenador registrarEntrenador(String nombre, String apellido, String id, int edad, String telefono) {
        return administrador.registrarEntrenador(nombre, apellido, id, edad, telefono);
    }
    public Entrenador obtenerEntrenador(String id) {
        for (Entrenador e : listaEntrenadores) {
            if (e.getIdentificacion().equals(id)) {
                return e;
            }
        }
        return null;
    }
    public void actualizarEntrenador(Entrenador entrenador,
                                     String nombre,
                                     String apellido,
                                     String id,
                                     int edad,
                                     String telefono) {

        entrenador.setNombre(nombre);
        entrenador.setApellido(apellido);
        entrenador.setIdentificacion(id);
        entrenador.setEdad(edad);
        entrenador.setTelefono(telefono);
    }

}
