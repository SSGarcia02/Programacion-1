package demo_proyectofinal_fx.demoapp.exceptions;

public class MembresiaException extends GimnasioException {
    public MembresiaException(String mensaje) {
        super(mensaje);
    }

    public MembresiaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}