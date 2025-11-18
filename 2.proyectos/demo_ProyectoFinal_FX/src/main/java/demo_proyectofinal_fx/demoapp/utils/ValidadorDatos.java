package demo_proyectofinal_fx.demoapp.utils;

import demo_proyectofinal_fx.demoapp.exceptions.UsuarioException;
import demo_proyectofinal_fx.demoapp.exceptions.MembresiaException;
import demo_proyectofinal_fx.demoapp.exceptions.ClaseException;
import demo_proyectofinal_fx.demoapp.exceptions.EntrenadorException;

public class ValidadorDatos {

    private ValidadorDatos() {
    }

    public static void validarUsuario(String nombre, String apellido, String identificacion,
                                      int edad, String telefono) throws UsuarioException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new UsuarioException("El nombre del usuario es obligatorio");
        }

        if (apellido == null || apellido.trim().isEmpty()) {
            throw new UsuarioException("El apellido del usuario es obligatorio");
        }

        if (identificacion == null || identificacion.trim().isEmpty()) {
            throw new UsuarioException("La identificación del usuario es obligatoria");
        }

        if (edad <= 0 || edad > 120) {
            throw new UsuarioException("La edad debe ser un valor válido entre 1 y 120 años");
        }

        if (telefono == null || telefono.trim().isEmpty()) {
            throw new UsuarioException("El teléfono del usuario es obligatorio");
        }

        if (!telefono.matches("\\d{10}")) {
            throw new UsuarioException("El teléfono debe contener exactamente 10 dígitos");
        }
    }

    public static void validarMembresia(String tipoMembresia, String periodo) throws MembresiaException {
        if (tipoMembresia == null || tipoMembresia.trim().isEmpty()) {
            throw new MembresiaException("El tipo de membresía es obligatorio");
        }

        if (!tipoMembresia.matches("(?i)BÁSICA|BASICA|PREMIUM|VIP")) {
            throw new MembresiaException("Tipo de membresía no válido. Debe ser: Básica, Premium o VIP");
        }

        if (periodo == null || periodo.trim().isEmpty()) {
            throw new MembresiaException("El período de la membresía es obligatorio");
        }

        if (!periodo.matches("(?i)MENSUAL|TRIMESTRAL|ANUAL")) {
            throw new MembresiaException("Período no válido. Debe ser: Mensual, Trimestral o Anual");
        }
    }

    public static void validarClase(String nombreClase, String horario, String entrenador) throws ClaseException {
        if (nombreClase == null || nombreClase.trim().isEmpty()) {
            throw new ClaseException("El nombre de la clase es obligatorio");
        }

        if (horario == null || horario.trim().isEmpty()) {
            throw new ClaseException("El horario de la clase es obligatorio");
        }

        if (entrenador == null || entrenador.trim().isEmpty()) {
            throw new ClaseException("El entrenador de la clase es obligatorio");
        }
    }

    public static void validarEntrenador(String nombre, String apellido, String identificacion,
                                         int edad, String telefono) throws EntrenadorException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new EntrenadorException("El nombre del entrenador es obligatorio");
        }

        if (apellido == null || apellido.trim().isEmpty()) {
            throw new EntrenadorException("El apellido del entrenador es obligatorio");
        }

        if (identificacion == null || identificacion.trim().isEmpty()) {
            throw new EntrenadorException("La identificación del entrenador es obligatoria");
        }

        if (edad < 18 || edad > 70) {
            throw new EntrenadorException("La edad del entrenador debe estar entre 18 y 70 años");
        }

        if (telefono == null || telefono.trim().isEmpty()) {
            throw new EntrenadorException("El teléfono del entrenador es obligatorio");
        }
    }

    public static void validarIdentificacionUnica(String identificacion, boolean existeUsuario) throws UsuarioException {
        if (existeUsuario) {
            throw new UsuarioException("Ya existe un usuario con la identificación: " + identificacion);
        }
    }

    public static void validarCupoDisponible(int usuariosInscritos, int cupoMaximo) throws ClaseException {
        if (usuariosInscritos >= cupoMaximo) {
            throw new ClaseException("La clase ha alcanzado su cupo máximo de " + cupoMaximo + " usuarios");
        }
    }

    public static void validarMembresiaActiva(boolean tieneMembresiaActiva) throws MembresiaException {
        if (!tieneMembresiaActiva) {
            throw new MembresiaException("El usuario no tiene una membresía activa para asignar clases");
        }
    }
}
