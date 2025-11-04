package demo_proyectofinal_fx.demoapp.controller;

import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import demo_proyectofinal_fx.demoapp.model.Usuario;
import javafx.scene.control.TextField;

import java.util.List;


public class UsuarioController {
    ModelFactory modelFactory;

    public UsuarioController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public List<Usuario> obtenerUsuarios() {
        return modelFactory.obtenerUsuarios();
    }

    public Usuario crearUsuario(Usuario usuario) {
        return modelFactory.crearcrearUsuario(usuario);
    }

    public boolean borrarusuario(String Identificacion) {
        return modelFactory.borrarusuario(Identificacion);
    }

    public boolean actualizarUsuario(Usuario usuarioEditar, String nuevaIdentificacion) {
        return modelFactory.actualizarUsuario(usuarioEditar, nuevaIdentificacion);
    }
}
