package demo_proyectofinal_fx.demoapp.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Gimnasio {

    private String nombre;
    private ArrayList<Persona> listaPersonas = new ArrayList<>();
    private ArrayList<Plan> listaPlan = new ArrayList<>();
    private ArrayList<Reserva> listaReserva = new ArrayList<>();
    private ArrayList<Membresia> listamembresia = new ArrayList<>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Clase> liistaClases = new ArrayList<>();
    private ArrayList<Entrenador> listaEntrenadores;

    public Gimnasio(){}

    public Gimnasio(String nombre) {
        this.nombre = nombre;
        this.listaEntrenadores = new ArrayList<>();
    }


    public ArrayList<Usuario> mostrarUsuarios(){
        return listaUsuarios;
    }

    //Usuario Controller-----------------------------
    public Usuario crearUsuario(Usuario usuario){
        Usuario usuarioEncontrado = obtenerUsuario(usuario.getIdentificacion());
        if(usuarioEncontrado == null){
            Usuario usuarioNuevo = new Usuario();
            usuarioNuevo.setNombre(usuario.getNombre());
            usuarioNuevo.setApellido(usuario.getApellido());
            usuarioNuevo.setEdad(usuario.getEdad());
            usuarioNuevo.setTelefono(usuario.getTelefono());
            usuarioNuevo.setIdentificacion(usuario.getIdentificacion());
            usuarioNuevo.setTipo(usuario.getTipo());

            getListaUsuarios().add(usuario);

            return usuario;
        }else{
            return null;
        }
    }
    public boolean borrarusuario(String identificacion){
        Usuario usuarioBorrar = obtenerUsuario(identificacion);
        if(usuarioBorrar != null){
            getListaUsuarios().remove(usuarioBorrar);

            return true;
        }
        return false;
    }
    public boolean actualizarUsuario(Usuario usuarioActualizado, String IdentificaacionOriginal){
        Usuario usuarioEditar = obtenerUsuario(IdentificaacionOriginal);

        if (usuarioEditar != null) {
            if (!Objects.equals(usuarioActualizado.getIdentificacion(), IdentificaacionOriginal)){
                Usuario usuarioNuevoID = obtenerUsuario(usuarioActualizado.getIdentificacion());
                if(usuarioNuevoID != null){

                    return false;
                }
            }
            usuarioEditar.setNombre(usuarioActualizado.getNombre());
            usuarioEditar.setApellido(usuarioActualizado.getApellido());
            usuarioEditar.setIdentificacion(usuarioActualizado.getIdentificacion());
            usuarioEditar.setEdad(usuarioActualizado.getEdad());
            usuarioEditar.setTelefono(usuarioActualizado.getTelefono());
            usuarioEditar.setTipo(usuarioActualizado.getTipo());

            return true;
        }
        return false;
    }

    public Usuario obtenerUsuario(String identificacion){
        Usuario usuarioEncontrado = null;
        for(Usuario persona : getListaUsuarios()){
            if(persona.getIdentificacion().equals(identificacion) && persona instanceof Usuario){
                usuarioEncontrado = persona;
                break;
            }
        }
        return usuarioEncontrado;
    }

    //Asignar Membresia Controller-----------------------------
    public boolean asignarMembresia(Membresia membresia, String identificacion){
        try {
            // Validar que la membresía no sea null
            if (membresia == null) {
                System.err.println("Error: La membresía no puede ser null");
                return false;
            }

            Usuario usuarioAsignar = obtenerUsuario(identificacion);

            // Validar que el usuario existe
            if (usuarioAsignar == null) {
                System.err.println("Error: Usuario no encontrado con identificación: " + identificacion);
                return false;
            }

            // Validar que el usuario NO tenga membresía asignada
            if (usuarioAsignar.getMembresia() != null) {
                System.err.println("Error: El usuario ya tiene una membresía asignada");
                return false;
            }
            membresia.setEstado(true);

            // Asignar la membresía al usuario
            usuarioAsignar.setMembresia(membresia);
            System.out.println("Membresía asignada exitosamente a: " + usuarioAsignar.getNombre());

            return true;

        } catch (Exception e) {
            System.err.println("Error al asignar membresía: " + e.getMessage());
            return false;
        }
    }
    public boolean borrarMembresia(String identificacion) {
        try {
            Usuario usuario = obtenerUsuario(identificacion);
            if (usuario != null) {
                usuario.setMembresia(null);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error al borrar membresía: " + e.getMessage());
            return false;
        }
    }

    public boolean editarMembresia(Membresia membresiaEditada, String identificacion) {
        try {
            // Validar que la membresía no sea null
            if (membresiaEditada == null) {
                System.err.println("Error: La membresía editada no puede ser null");
                return false;
            }

            Usuario usuario = obtenerUsuario(identificacion);

            // Validar que el usuario existe
            if (usuario == null) {
                System.err.println("Error: Usuario no encontrado con identificación: " + identificacion);
                return false;
            }

            // Validar que el usuario TIENE una membresía para editar
            if (usuario.getMembresia() == null) {
                System.err.println("Error: El usuario no tiene una membresía asignada para editar");
                return false;
            }

            // Actualizar la membresía del usuario
            usuario.setMembresia(membresiaEditada);

            System.out.println("Membresía editada exitosamente para: " + usuario.getNombre() +
                    " - Nuevo tipo: " + membresiaEditada.getTipoMembresia() +
                    " - Nuevo período: " + membresiaEditada.getPeriodoMembresia());

            return true;

        } catch (Exception e) {
            System.err.println("Error al editar membresía: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public Membresia calcularCostomembresia(String tipoMembresia,
                                            PeriodoMembresia tipoPlan,
                                            Usuario usuario){
        if(tipoPlan == null && usuario == null){
            return null;
        }

        LocalDate fechaFinal = null;
        LocalDate fechaInicio = LocalDate.now();

        double costo = 0.0;

        switch (tipoPlan){
            case MENSUAL:
                fechaFinal = fechaInicio.plusMonths(1);
                break;
            case TRIMESTRAL:
                fechaFinal = fechaInicio.plusMonths(3);
                break;
            case ANUAL:
                fechaFinal = fechaInicio.plusYears(1);
                break;
        }
        switch (tipoMembresia.toUpperCase()) {
            case "BÁSICA":
            case "BASICA":
                switch (tipoPlan) {
                    case MENSUAL -> costo = 50000;
                    case TRIMESTRAL -> costo = 130000;
                    case ANUAL -> costo = 550000;
                }
                break;
            case "PREMIUM":
                switch (tipoPlan) {
                    case MENSUAL -> costo = 70000;
                    case TRIMESTRAL -> costo = 180000;
                    case ANUAL -> costo = 800000;
                }
                break;
            case "VIP":
                switch (tipoPlan) {
                    case MENSUAL -> costo = 100000;
                    case TRIMESTRAL -> costo = 270000;
                    case ANUAL -> costo = 1100000;
                }
                break;
            default:
                throw new IllegalArgumentException("Tipo de membresía no reconocido: " + tipoMembresia);
        }

        if (usuario instanceof Estudiante) {
            costo = costo * 0.90;
        }

        switch (tipoMembresia.toUpperCase()) {
            case "BÁSICA":
            case "BASICA":
                return new MembresiaBasica(costo, fechaInicio, fechaFinal);
            case "PREMIUM":
                return new MembresiaPremium(costo, fechaInicio, fechaFinal);
            case "VIP":
                return new MembresiaVIP(costo, fechaInicio, fechaFinal);
            default:
                throw new IllegalArgumentException("Tipo de membresía no reconocido: " + tipoMembresia);
        }
    }

    //Asignar Clase Controller---------------------------

    public boolean asignarClaseAUsuario(String identificacionUsuario, String tipoClaseStr,
                                        String horarioStr, String nombreEntrenador) {
        try {
            // Validaciones básicas
            if (identificacionUsuario == null || tipoClaseStr == null ||
                    horarioStr == null || nombreEntrenador == null) {
                return false;
            }

            // Obtener usuario
            Usuario usuario = obtenerUsuario(identificacionUsuario);
            if (usuario == null) {
                return false;
            }

            // Validar membresía activa
            if (usuario.getMembresia() == null || !usuario.getMembresia().isEstado()) {
                return false;
            }

            // Convertir parámetros
            TipoClases tipoClase = TipoClases.valueOf(tipoClaseStr.toUpperCase());
            LocalTime horaInicio = parsearHorario(horarioStr);
            Entrenador entrenador = obtenerEntrenadorPorNombre(nombreEntrenador);

            if (entrenador == null) {
                return false;
            }

            // Obtener o crear la clase
            Clase clase = obtenerOcrearClase(tipoClase, horaInicio, entrenador);

            // Validar cupo disponible
            if (obtenerCantidadUsuariosEnClase(clase) >= clase.getCupoMaximo()) {
                return false;
            }

            // Asignar clase al usuario
            usuario.setClase(clase);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean borrarClaseDeUsuario(String identificacionUsuario) {
        try {
            // Validar parámetro
            if (identificacionUsuario == null || identificacionUsuario.trim().isEmpty()) {
                System.err.println("Error: La identificación del usuario no puede estar vacía");
                return false;
            }

            // Obtener usuario
            Usuario usuario = obtenerUsuario(identificacionUsuario);
            if (usuario == null) {
                System.err.println("Error: Usuario no encontrado con identificación: " + identificacionUsuario);
                return false;
            }

            // Validar que el usuario tenga una clase asignada
            if (usuario.getClase() == null) {
                System.err.println("Error: El usuario no tiene una clase asignada");
                return false;
            }

            // Obtener información de la clase antes de borrar (para logging)
            Clase claseAEliminar = usuario.getClase();
            String nombreClase = claseAEliminar.getNombre();

            // Eliminar la clase del usuario
            usuario.setClase(null);

            System.out.println("Clase eliminada exitosamente: " + nombreClase +
                    " del usuario: " + usuario.getNombre());

            return true;

        } catch (Exception e) {
            System.err.println("Error al borrar clase: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public Clase obtenerOcrearClase(TipoClases tipoClase, LocalTime horaInicio, Entrenador entrenador) {
        // Buscar clase existente
        Clase claseExistente = obtenerClaseExistente(tipoClase, horaInicio, entrenador);

        if (claseExistente != null) {
            return claseExistente;
        }

        // Crear nueva clase
        String nombreClase = tipoClase.name() + " - " + horaInicio.format(DateTimeFormatter.ofPattern("HH:mm"));
        Clase nuevaClase = new Clase(nombreClase, tipoClase,
                horaInicio, 20, entrenador);
        getLiistaClases().add(nuevaClase);
        return nuevaClase;
    }

    private Clase obtenerClaseExistente(TipoClases tipoClase, LocalTime horaInicio, Entrenador entrenador) {
        for (Clase clase : getLiistaClases()) {
            if (clase.getTipoClase() == tipoClase &&
                    clase.getHoraInicio().equals(horaInicio) &&
                    clase.getEntrenadorAsignado().equals(entrenador)) {
                return clase;
            }
        }
        return null;
    }

    public int obtenerCantidadUsuariosEnClase(Clase clase) {
        int count = 0;
        for (Usuario usuario : getListaUsuarios()) {
            if (usuario.getClase() != null && usuario.getClase().equals(clase)) {
                count++;
            }
        }
        return count;
    }

    private LocalTime parsearHorario(String horarioStr) {
        String[] partes = horarioStr.split(" - ");
        return LocalTime.parse(partes[0], DateTimeFormatter.ofPattern("H:mm"));
    }

    public Entrenador obtenerEntrenadorPorNombre(String nombre) {
        for (Entrenador entrenador : getListaEntrenadores()) {
            if (entrenador.getNombre().equals(nombre)) {
                return entrenador;
            }
        }
        return null;
    }

    public ArrayList<Entrenador> obtenerEntrenadoresDisponibles() {
        return getListaEntrenadores();
    }

    public Clase obtenerClase(String nombreClase) {
        for (Clase clase : getLiistaClases()) {
            if (clase.getNombre().equals(nombreClase)) {
                return clase;
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public ArrayList<Plan> getListaPlan() {
        return listaPlan;
    }

    public void setListaPlan(ArrayList<Plan> listaPlan) {
        this.listaPlan = listaPlan;
    }

    public ArrayList<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(ArrayList<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public ArrayList<Membresia> getListamembresia() {
        return listamembresia;
    }

    public void setListamembresia(ArrayList<Membresia> listamembresia) {
        this.listamembresia = listamembresia;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Clase> getLiistaClases() {
        return liistaClases;
    }

    public void setLiistaClases(ArrayList<Clase> liistaClases) {
        this.liistaClases = liistaClases;
    }

    public ArrayList<Entrenador> getListaEntrenadores() {
        if (listaEntrenadores == null) {
            listaEntrenadores = new ArrayList<>(); // Inicializar si es null
        }
        return listaEntrenadores;
    }

    public void setListaEntrenadores(ArrayList<Entrenador> listaEntrenadores) {
        this.listaEntrenadores = listaEntrenadores;
    }

}
