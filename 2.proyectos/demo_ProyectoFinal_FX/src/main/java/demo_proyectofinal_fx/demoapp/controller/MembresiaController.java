package demo_proyectofinal_fx.demoapp.controller;

import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import demo_proyectofinal_fx.demoapp.model.Membresia;
import demo_proyectofinal_fx.demoapp.model.PeriodoMembresia;
import demo_proyectofinal_fx.demoapp.model.Usuario;

import java.util.List;

public class MembresiaController {
    ModelFactory modelFactory;

    public MembresiaController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public Membresia calcularCostoMembresia(String tipoMembresia,
                                                   PeriodoMembresia periodoSeleccionado,
                                                   Usuario usuarioSeleccionado) {
        return modelFactory.calcularCostoMembresia(tipoMembresia, periodoSeleccionado, usuarioSeleccionado);
    }

    public List<Usuario> obtenerUsuarios() {
        return modelFactory.obtenerUsuarios();
    }

    public boolean asignarMembresia(Membresia membresia, String identificacion) {
        return modelFactory.asignarMembresia(membresia, identificacion);
    }

    public boolean borrarMembresia(String identificacion) {
        return modelFactory.borrarMembresia(identificacion);
    }

    public boolean editarMembresia(Membresia membresiaEditada, String identificacion) {
        return modelFactory.editarMembresia(membresiaEditada, identificacion);
    }
}
