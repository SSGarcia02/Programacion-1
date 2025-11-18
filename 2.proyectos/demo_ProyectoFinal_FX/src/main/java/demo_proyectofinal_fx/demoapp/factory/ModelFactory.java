package demo_proyectofinal_fx.demoapp.factory;

import demo_proyectofinal_fx.demoapp.exceptions.MembresiaException;
import demo_proyectofinal_fx.demoapp.exceptions.UsuarioException;
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

    private ModelFactory() {
        gimnasio = DataUtil.inicializarDatos();
        listaUsuariosObservable = FXCollections.observableArrayList(gimnasio.getListaUsuarios());
    }

    public static ModelFactory getInstancia() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    public ObservableList<Usuario> obtenerUsuariosObservable() {
        listaUsuariosObservable.setAll(gimnasio.getListaUsuarios());
        return listaUsuariosObservable;
    }

    public List<Entrenador> obtenerEntrenadores() {
        return gimnasio.getListaEntrenadores();
    }


    // Usuario Controller ---------------------------
    public List<Usuario> obtenerUsuarios() {
        return gimnasio.getListaUsuarios();
    }

    public Usuario crearcrearUsuario(Usuario usuario) throws UsuarioException {
        try {
            return gimnasio.crearUsuario(usuario);
        } catch (Exception e) {
            throw new UsuarioException("Error al crear usuario: " + e.getMessage(), e);
        }
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

    public boolean asignarMembresia(Membresia membresia, String identificacion) throws MembresiaException {
        try {
            return gimnasio.asignarMembresia(membresia, identificacion);
        } catch (Exception e) {
            throw new MembresiaException("Error al asignar membresía: " + e.getMessage(), e);
        }
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

    public boolean eliminarEntrenadorFX(String id) {

        Administrador admin = gimnasio.getAdministrador();

        if (admin == null) {
            System.out.println("❌ No existe administrador en el gimnasio.");
            return false;
        }

        return admin.eliminarEntrenador(id);
    }

    public boolean asignarEntrenador(String idEntrenador, String nombreClase) {

        Administrador admin = gimnasio.getAdministrador();

        if (admin == null) {
            System.out.println("❌ No existe administrador en el gimnasio.");
            return false;
        }

        return admin.asignarEntrenador(idEntrenador, nombreClase);
    }

    public Entrenador registrarEntrenador(String nombre, String apellido, String id, int edad, String telefono) {
        return gimnasio.registrarEntrenador(nombre, apellido, id, edad, telefono);
    }

    public boolean actualizarEntrenador(String idActual,
                                        String nombre,
                                        String apellido,
                                        String nuevoId,
                                        int edad,
                                        String telefono) {
        Entrenador e = gimnasio.obtenerEntrenador(idActual);
        if (e != null) {
            gimnasio.actualizarEntrenador(e, nombre, apellido, nuevoId, edad, telefono);
            return true;
        }
        return false;
    }

    public Entrenador obtenerEntrenador(String id) {
        return gimnasio.obtenerEntrenador(id);
    }

    public UsuarioSistema autenticarUsuario(String usuario, String password) {
        if (gimnasio == null || gimnasio.getListaUsuariosSistema() == null) {
            System.out.println("❌ Gimnasio o lista de usuarios del sistema es null");
            return null;
        }

        for (UsuarioSistema user : gimnasio.getListaUsuariosSistema()) {
            System.out.println("Comparando: " + user.getNombre() + " con " + usuario);
            if (user.getNombre().equals(usuario) && user.getPassword().equals(password)) {
                System.out.println("✅ Usuario autenticado: " + user.getClass().getSimpleName());
                return user;
            }
        }
        System.out.println("❌ Usuario no encontrado o credenciales incorrectas");
        return null;
    }

    public Administrador getAdministrador() {
        return gimnasio.getAdministrador();
    }

    public String generarReporte(String tipoReporte) {
        return gimnasio.generarReporte(tipoReporte);
    }

    public String generarReporteAsistencia() {
        return gimnasio.generarReporteAsistencia();
    }

    public String generarReporteIngresos() {
        return gimnasio.generarReporteIngresos();
    }

    public String generarReporteClasesPopulares() {
        return gimnasio.generarReporteClasesPopulares();
    }

    public String generarReporteUsuariosPorTipo() {
        return gimnasio.generarReporteUsuariosPorTipo();
    }
}
