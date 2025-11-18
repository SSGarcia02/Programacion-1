package demo_proyectofinal_fx.demoapp.exceptions;

public class EntrenadorException extends GimnasioException {
    public EntrenadorException(String mensaje) {
        super(mensaje);
    }

    public EntrenadorException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
