package demo_proyectofinal_fx.demoapp.controller;

import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import demo_proyectofinal_fx.demoapp.model.Entrenador;

import java.util.List;

public class EntrenadorController {

    private final ModelFactory modelFactory;

    public EntrenadorController() {
        this.modelFactory = ModelFactory.getInstancia();
    }

    public List<Entrenador> obtenerEntrenadores() {
        return modelFactory.obtenerEntrenadores();
    }

    public boolean asignarEntrenador(String idEntrenador, String nombreClase) {
        return modelFactory.asignarEntrenador(idEntrenador, nombreClase);
    }

    public boolean eliminarEntrenador(String idEntrenador) {
        return modelFactory.eliminarEntrenadorFX(idEntrenador);
    }

    public Entrenador registrarEntrenador(String nombre, String apellido, String id, int edad, String telefono) {
        return modelFactory.registrarEntrenador(nombre, apellido, id, edad, telefono);
    }

    public boolean actualizarEntrenador(String idActual,
                                        String nombre,
                                        String apellido,
                                        String nuevoId,
                                        int edad,
                                        String telefono) {
        return modelFactory.actualizarEntrenador(idActual, nombre, apellido, nuevoId, edad, telefono);
    }


    public Entrenador obtenerEntrenador(String id) {
        return modelFactory.obtenerEntrenador(id);
    }
}