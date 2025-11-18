package demo_proyectofinal_fx.demoapp.exceptions;

public class UsuarioException extends GimnasioException {
    public UsuarioException(String mensaje) {
        super(mensaje);
    }

    public UsuarioException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
