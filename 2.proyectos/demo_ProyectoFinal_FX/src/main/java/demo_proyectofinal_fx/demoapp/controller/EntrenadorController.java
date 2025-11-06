package demo_proyectofinal_fx.demoapp.controller;


import demo_proyectofinal_fx.demoapp.model.Entrenador;

import java.util.List;

public class EntrenadorController {
    public List<Entrenador> obtenerEntrenadores() {
        return modelFactory.obtenerEntrenadores();
    }
}
