package demo_proyectofinal_fx.demoapp.controller;

import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import demo_proyectofinal_fx.demoapp.model.Clase;
import demo_proyectofinal_fx.demoapp.model.Entrenador;
import demo_proyectofinal_fx.demoapp.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AsignarClaseController {
    ModelFactory modelFactory;

    public AsignarClaseController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public static boolean asignarClaseAUsuario(String identificacion, String clase,
                                               String horario, String entrenador) {
        return ModelFactory.asignarClaseAUsuario(identificacion, clase, horario, entrenador);
    }

    public static List<Entrenador> obtenerEntrenadoresDisponibles() {
        return ModelFactory.obtenerEntrenadoresDisponibles();
    }

    public static ArrayList<Entrenador> getListaEntrenadores() {
        return ModelFactory.getListaEntrenadores();
    }

    public List<Usuario> obtenerUsuarios() {
        return modelFactory.obtenerUsuarios();
    }


    public boolean borrarClaseDeUsuario(String usuarioSeleccionado) {
        return modelFactory.borrarClaseDeUsuario(usuarioSeleccionado);
    }
}
