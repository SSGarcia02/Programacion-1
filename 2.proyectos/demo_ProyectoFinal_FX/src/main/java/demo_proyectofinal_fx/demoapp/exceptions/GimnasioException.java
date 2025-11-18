package demo_proyectofinal_fx.demoapp.exceptions;

public class GimnasioException extends Exception {
    public GimnasioException(String mensaje) {
        super(mensaje);
    }

    public GimnasioException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}