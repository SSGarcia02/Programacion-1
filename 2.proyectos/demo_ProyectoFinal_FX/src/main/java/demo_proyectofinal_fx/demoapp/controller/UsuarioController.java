package demo_proyectofinal_fx.demoapp.controller;

import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import demo_proyectofinal_fx.demoapp.model.Usuario;
import demo_proyectofinal_fx.demoapp.utils.ManejadorExcepciones;
import demo_proyectofinal_fx.demoapp.utils.ValidadorDatos;
import demo_proyectofinal_fx.demoapp.exceptions.UsuarioException;

import java.util.List;

public class UsuarioController {
    ModelFactory modelFactory;

    public UsuarioController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public List<Usuario> obtenerUsuarios() {
        try {
            return modelFactory.obtenerUsuarios();
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "obtener lista de usuarios");
            return List.of(); // Retorna lista vacía en caso de error
        }
    }

    public Usuario crearUsuario(Usuario usuario) {
        try {
            ValidadorDatos.validarUsuario(
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getIdentificacion(),
                    usuario.getEdad(),
                    usuario.getTelefono()
            );
            boolean existeUsuario = modelFactory.obtenerUsuarios().stream()
                    .anyMatch(u -> u.getIdentificacion().equals(usuario.getIdentificacion()));
            ValidadorDatos.validarIdentificacionUnica(usuario.getIdentificacion(), existeUsuario);

            return modelFactory.crearcrearUsuario(usuario);

        } catch (UsuarioException e) {
            ManejadorExcepciones.manejarExcepcion(e, "crear usuario");
            return null;
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "crear usuario");
            return null;
        }
    }

    public boolean borrarusuario(String identificacion) {
        try {
            if (identificacion == null || identificacion.trim().isEmpty()) {
                throw new UsuarioException("La identificación no puede estar vacía");
            }

            return modelFactory.borrarusuario(identificacion);

        } catch (UsuarioException e) {
            ManejadorExcepciones.manejarExcepcion(e, "borrar usuario");
            return false;
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "borrar usuario");
            return false;
        }
    }

    public boolean actualizarUsuario(Usuario usuarioEditar, String nuevaIdentificacion) {
        try {
            ValidadorDatos.validarUsuario(
                    usuarioEditar.getNombre(),
                    usuarioEditar.getApellido(),
                    usuarioEditar.getIdentificacion(),
                    usuarioEditar.getEdad(),
                    usuarioEditar.getTelefono()
            );

            return modelFactory.actualizarUsuario(usuarioEditar, nuevaIdentificacion);

        } catch (UsuarioException e) {
            ManejadorExcepciones.manejarExcepcion(e, "actualizar usuario");
            return false;
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "actualizar usuario");
            return false;
        }
    }
}