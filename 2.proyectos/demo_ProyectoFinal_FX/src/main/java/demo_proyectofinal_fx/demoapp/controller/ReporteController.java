package demo_proyectofinal_fx.demoapp.controller;

import demo_proyectofinal_fx.demoapp.factory.ModelFactory;

public class ReporteController {

    private ModelFactory modelFactory;

    public ReporteController() {
        this.modelFactory = ModelFactory.getInstancia();
    }

    public String generarReporte(String tipoReporte) {
        return modelFactory.generarReporte(tipoReporte);
    }
}
