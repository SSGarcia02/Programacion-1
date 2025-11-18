package demo_proyectofinal_fx.demoapp.controller;

import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import demo_proyectofinal_fx.demoapp.model.Membresia;
import demo_proyectofinal_fx.demoapp.model.PeriodoMembresia;
import demo_proyectofinal_fx.demoapp.model.Usuario;
import demo_proyectofinal_fx.demoapp.utils.ManejadorExcepciones;
import demo_proyectofinal_fx.demoapp.utils.ValidadorDatos;
import demo_proyectofinal_fx.demoapp.exceptions.MembresiaException;

import java.util.List;

public class MembresiaController {
    ModelFactory modelFactory;

    public MembresiaController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public Membresia calcularCostoMembresia(String tipoMembresia,
                                            PeriodoMembresia periodoSeleccionado,
                                            Usuario usuarioSeleccionado) {
        try {
            return modelFactory.calcularCostoMembresia(tipoMembresia, periodoSeleccionado, usuarioSeleccionado);
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "calcular costo de membresía");
            return null;
        }
    }

    public List<Usuario> obtenerUsuarios() {
        try {
            return modelFactory.obtenerUsuarios();
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "obtener lista de usuarios");
            return List.of();
        }
    }

    public boolean asignarMembresia(Membresia membresia, String identificacion) {
        try {
            if (membresia == null) {
                throw new MembresiaException("La membresía no puede ser nula");
            }

            if (identificacion == null || identificacion.trim().isEmpty()) {
                throw new MembresiaException("La identificación del usuario es obligatoria");
            }

            return modelFactory.asignarMembresia(membresia, identificacion);

        } catch (MembresiaException e) {
            ManejadorExcepciones.manejarExcepcion(e, "asignar membresía");
            return false;
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "asignar membresía");
            return false;
        }
    }

    public boolean borrarMembresia(String identificacion) {
        try {
            if (identificacion == null || identificacion.trim().isEmpty()) {
                throw new MembresiaException("La identificación del usuario es obligatoria");
            }

            return modelFactory.borrarMembresia(identificacion);

        } catch (MembresiaException e) {
            ManejadorExcepciones.manejarExcepcion(e, "borrar membresía");
            return false;
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "borrar membresía");
            return false;
        }
    }

    public boolean editarMembresia(Membresia membresiaEditada, String identificacion) {
        try {
            if (membresiaEditada == null) {
                throw new MembresiaException("La membresía editada no puede ser nula");
            }

            if (identificacion == null || identificacion.trim().isEmpty()) {
                throw new MembresiaException("La identificación del usuario es obligatoria");
            }

            return modelFactory.editarMembresia(membresiaEditada, identificacion);

        } catch (MembresiaException e) {
            ManejadorExcepciones.manejarExcepcion(e, "editar membresía");
            return false;
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "editar membresía");
            return false;
        }
    }
}
