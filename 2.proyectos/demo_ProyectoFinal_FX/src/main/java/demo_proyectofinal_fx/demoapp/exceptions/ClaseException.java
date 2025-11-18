package demo_proyectofinal_fx.demoapp.exceptions;

public class ClaseException extends GimnasioException {
    public ClaseException(String mensaje) {
        super(mensaje);
    }

    public ClaseException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}