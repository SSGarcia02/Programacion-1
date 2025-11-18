package demo_proyectofinal_fx.demoapp.factory;

import demo_proyectofinal_fx.demoapp.model.*;
import demo_proyectofinal_fx.demoapp.utils.DataUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ModelFactory {
    private static ModelFactory modelFactory;
    private static Gimnasio gimnasio;
    private final ObservableList<Usuario> listaUsuariosObservable;

    public static ModelFactory getInstancia(){
        if(modelFactory == null){
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        gimnasio = DataUtil.inicializarDatos();
        listaUsuariosObservable = FXCollections.observableArrayList(gimnasio.getListaUsuarios());
    }

    public ObservableList<Usuario> obtenerUsuariosObservable() {
        listaUsuariosObservable.setAll(gimnasio.getListaUsuarios());
        return listaUsuariosObservable;
    }


    // Usuario Controller ---------------------------
    public List<Usuario> obtenerUsuarios() {
        return gimnasio.getListaUsuarios();
    }

    public Usuario crearcrearUsuario(Usuario usuario) {
        return gimnasio.crearUsuario(usuario);
    }

    public boolean borrarusuario(String Identificacion) {
        return gimnasio.borrarusuario(String.valueOf(Identificacion));
    }

    public boolean actualizarUsuario(Usuario usuarioEditar, String nuevaIdentificacion) {
        return gimnasio.actualizarUsuario(usuarioEditar, nuevaIdentificacion);
    }

    //Membresia Controller ----------------------------------
    public Membresia calcularCostoMembresia(String tipoMembresia,
                                            PeriodoMembresia periodoSeleccionado,
                                            Usuario usuarioSeleccionado) {
        return gimnasio.calcularCostomembresia(tipoMembresia, periodoSeleccionado, usuarioSeleccionado);
    }

    public boolean asignarMembresia(Membresia membresia, String identificacion) {
        return gimnasio.asignarMembresia(membresia, identificacion);
    }

    public boolean borrarMembresia(String identificacion) {
        return gimnasio.borrarMembresia(identificacion);
    }

    public boolean editarMembresia(Membresia membresiaEditada, String identificacion) {
        return gimnasio.editarMembresia(membresiaEditada, identificacion);
    }
    //Clase Controller ----------------------------------
    public static boolean asignarClaseAUsuario(String identificacion, String clase,
                                               String horario, String entrenador) {
        return gimnasio.asignarClaseAUsuario(identificacion, clase, horario, entrenador);
    }
    public static List<Entrenador> obtenerEntrenadoresDisponibles() {
        return gimnasio.obtenerEntrenadoresDisponibles();
    }
    public static ArrayList<Entrenador> getListaEntrenadores() {
        return gimnasio.getListaEntrenadores();
    }

    public boolean borrarClaseDeUsuario(String usuarioSeleccionado) {
        return gimnasio.borrarClaseDeUsuario(usuarioSeleccionado);
    }

    public boolean editarClaseDeUsuario(String usuarioSeleccionado, String clase,
                                        String horario, String entrenador) {
        return gimnasio.editarClaseDeUsuario(usuarioSeleccionado, clase, horario, entrenador);
    }


    public int obtenerCantidadUsuariosEnClase(Clase clase) {
        return gimnasio.obtenerCantidadUsuariosEnClase(clase);
    }
}
