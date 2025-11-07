package demo_proyectofinal_fx.demoapp.controller;


import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import demo_proyectofinal_fx.demoapp.model.Entrenador;

import java.util.List;

public class EntrenadorController {
    ModelFactory modelFactory;
    public EntrenadorController() {
        modelFactory = ModelFactory.getInstancia(); // <-- AQUÍ
    }

    public List<Entrenador> obtenerEntrenadores() {
        return modelFactory.obtenerEntrenadores();
    }
    public boolean asignarEntrenadorAClase(String idEntrenador, String nombreClase) {
        return modelFactory.asignarEntrenadorAClase(idEntrenador, nombreClase);
    }
}
