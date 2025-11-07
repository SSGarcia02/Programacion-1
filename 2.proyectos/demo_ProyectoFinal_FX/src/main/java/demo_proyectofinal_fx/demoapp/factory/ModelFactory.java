package demo_proyectofinal_fx.demoapp.factory;

import demo_proyectofinal_fx.demoapp.model.*;
import demo_proyectofinal_fx.demoapp.utils.DataUtil;
import javafx.scene.control.TextField;

import java.util.List;

public class ModelFactory {
    private static ModelFactory modelFactory;
    private Gimnasio gimnasio;

    public static ModelFactory getInstancia(){
        if(modelFactory == null){
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        gimnasio = DataUtil.inicializarDatos();
    }

    public List<Usuario> obtenerUsuarios() {
        return gimnasio.getListaUsuarios();
    }
    public List<Entrenador> obtenerEntrenadores() {
        return gimnasio.getListaEntrenadores();
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

    public boolean eliminarEntrenadorFX(String id) {

        Administrador admin = gimnasio.getAdministrador();

        if (admin == null) {
            System.out.println("❌ No existe administrador en el gimnasio.");
            return false;
        }

        return admin.eliminarEntrenador(id);
    }
    public boolean asignarEntrenadorAClase(String idEntrenador, String nombreClase) {

        Entrenador entrenador = Entrenador.obtenerEntrenador(gimnasio, idEntrenador);
        Clase clase = gimnasio.obtenerClase(nombreClase);

        if (entrenador != null && clase != null) {
            clase.asignarEntrenador(entrenador);
            return true;
        }

        return false;
    }

}
