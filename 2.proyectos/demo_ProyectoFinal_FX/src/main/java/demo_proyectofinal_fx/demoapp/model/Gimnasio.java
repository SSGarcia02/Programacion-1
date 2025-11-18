package demo_proyectofinal_fx.demoapp.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Gimnasio {

    private String nombre;
    private ArrayList<Persona> listaPersonas = new ArrayList<>();
    private ArrayList<Plan> listaPlan = new ArrayList<>();
    private ArrayList<Reserva> listaReserva = new ArrayList<>();
    private ArrayList<Membresia> listamembresia = new ArrayList<>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Clase> listaClases = new ArrayList<>();
    private ArrayList<Entrenador> listaEntrenadores;
    private Administrador administrador;
    private ArrayList<UsuarioSistema> listaUsuariosSistema = new ArrayList<>();

    public ArrayList<UsuarioSistema> getListaUsuariosSistema() {
        return listaUsuariosSistema;
    }

    public void setListaUsuariosSistema(ArrayList<UsuarioSistema> listaUsuariosSistema) {
        this.listaUsuariosSistema = listaUsuariosSistema;
    }

    public Gimnasio(){}

    public Gimnasio(String nombre) {
        this.nombre = nombre;
        this.listaEntrenadores = new ArrayList<>();
    }


    public ArrayList<Usuario> mostrarUsuarios(){
        return listaUsuarios;
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
        getListaClases().add(nuevaClase);
        return nuevaClase;
    }

    private Clase obtenerClaseExistente(TipoClases tipoClase, LocalTime horaInicio, Entrenador entrenador) {
        for (Clase clase : getListaClases()) {
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

    public boolean editarClaseDeUsuario(String identificacion, String tipoClase, String horario, String entrenador) {
        try {
            Usuario usuario = obtenerUsuario(identificacion);
            if (usuario == null || usuario.getMembresia() == null || !usuario.getMembresia().isEstado()) {
                return false;
            }

            if (usuario.getClase() == null) return false;

            TipoClases nuevoTipo = TipoClases.valueOf(tipoClase.toUpperCase());
            LocalTime nuevaHora = parsearHorario(horario);
            Entrenador nuevoEntrenador = obtenerEntrenadorPorNombre(entrenador);

            if (nuevoEntrenador == null) return false;

            Clase nuevaClase = obtenerOcrearClase(nuevoTipo, nuevaHora, nuevoEntrenador);

            if (obtenerCantidadUsuariosEnClase(nuevaClase) >= nuevaClase.getCupoMaximo()) {
                return false;
            }

            usuario.setClase(nuevaClase);
            return true;

        } catch (Exception e) {
            return false;
        }
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

    public ArrayList<Clase> getListaClases() {
        return listaClases;
    }

    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
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

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public boolean eliminarEntrenador(String idEntrenador) {
        for (Persona persona : listaPersonas) {
            if (persona instanceof Administrador admin) {
                return admin.eliminarEntrenador(idEntrenador);
            }
        }

        System.out.println("❌ No existe administrador en el gimnasio.");
        return false;
    }
    public Entrenador registrarEntrenador(String nombre, String apellido, String id, int edad, String telefono) {
        return administrador.registrarEntrenador(nombre, apellido, id, edad, telefono);
    }
    public Entrenador obtenerEntrenador(String id) {
        for (Entrenador e : listaEntrenadores) {
            if (e.getIdentificacion().equals(id)) {
                return e;
            }
        }
        return null;
    }
    public void actualizarEntrenador(Entrenador entrenador,
                                     String nombre,
                                     String apellido,
                                     String nuevoId,
                                     int edad,
                                     String telefono) {
        entrenador.setNombre(nombre);
        entrenador.setApellido(apellido);
        entrenador.setIdentificacion(nuevoId);
        entrenador.setEdad(edad);
        entrenador.setTelefono(telefono);
    }
    public UsuarioSistema autenticarUsuario(String usuario, String password) {
        for (UsuarioSistema user : listaUsuariosSistema) {
            if (user.getNombre().equals(usuario) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    public Usuario crearUsuario(Usuario usuario){
        Usuario usuarioEncontrado = obtenerUsuario(usuario.getIdentificacion());
        if(usuarioEncontrado == null){
            Usuario usuarioNuevo = new Usuario();
            usuarioNuevo.setNombre(usuario.getNombre());
            usuarioNuevo.setApellido(usuario.getApellido());
            usuarioNuevo.setEdad(usuario.getEdad());
            usuarioNuevo.setTelefono(usuario.getTelefono());
            usuarioNuevo.setIdentificacion(usuario.getIdentificacion());

            getListaUsuarios().add(usuario);

            return usuario;
        }else{
            return null;
        }
    }

    public Clase obtenerClase(String nombreClase){
        Clase clase = null;
        for(int i=0;i<getListaClases().size();i++){
            if(getListaClases().get(i).getNombre().equals(nombreClase)){
                clase = getListaClases().get(i);
            }
        }
        return clase;
    }

    public String generarReporte(String tipoReporte) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== REPORTE: ").append(tipoReporte).append(" ===\n");
        reporte.append("Generado el: ").append(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))).append("\n\n");

        switch (tipoReporte) {
            case "Reporte de Clases Populares":
                reporte.append(generarReporteClasesPopulares());
                break;
            case "Reporte de Ingresos por Membresía":
                reporte.append(generarReporteIngresos());
                break;
            case "Reporte de Asistencia":
                reporte.append(generarReporteAsistencia());
                break;
            case "Reporte de Usuarios por Tipo":
                reporte.append(generarReporteUsuariosPorTipo());
                break;
            case "Reporte de Usuarios Activos":
                reporte.append(generarReporteUsuariosActivos());
                break;
            case "Reporte de Clases Más Reservadas":
                reporte.append(generarReporteClasesMasReservadas());
                break;
            case "Reporte de Vencimiento de Membresías":
                reporte.append(generarReporteVencimientoMembresias());
                break;
            default:
                reporte.append("Tipo de reporte no reconocido.\n");
        }

        return reporte.toString();
    }


    public String generarReporteAsistencia() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("--- REPORTE DE ASISTENCIA ---\n\n");
        long usuariosConMembresiaActiva = listaUsuarios.stream()
                .filter(u -> u.getMembresia() != null && u.getMembresia().isEstado())
                .count();
        long usuariosEnClases = listaUsuarios.stream()
                .filter(u -> u.getClase() != null)
                .count();
        double porcentajeAsistencia = listaUsuarios.isEmpty() ? 0 :
                (usuariosEnClases * 100.0) / listaUsuarios.size();

        reporte.append("Total de Usuarios: ").append(listaUsuarios.size()).append("\n");
        reporte.append("Usuarios con Membresía Activa: ").append(usuariosConMembresiaActiva).append("\n");
        reporte.append("Usuarios Inscritos en Clases: ").append(usuariosEnClases).append("\n");
        reporte.append("Porcentaje de Asistencia: ").append(String.format("%.2f", porcentajeAsistencia)).append("%\n\n");

        // Detalle por clases
        reporte.append("DETALLE POR CLASES:\n");
        for (Clase clase : listaClases) {
            int usuariosEnClase = obtenerCantidadUsuariosEnClase(clase);
            double porcentajeOcupacion = (usuariosEnClase * 100.0) / clase.getCupoMaximo();
            reporte.append("- ").append(clase.getNombre())
                    .append(": ").append(usuariosEnClase).append("/").append(clase.getCupoMaximo())
                    .append(" (").append(String.format("%.1f", porcentajeOcupacion)).append("%)\n");
        }

        return reporte.toString();
    }

    public String generarReporteIngresos() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("--- REPORTE DE INGRESOS POR MEMBRESÍA ---\n\n");

        Map<String, Double> ingresosPorMembresia = new HashMap<>();
        Map<String, Integer> cantidadPorMembresia = new HashMap<>();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getMembresia() != null && usuario.getMembresia().isEstado()) {
                String tipoMembresia = usuario.getMembresia().getTipoMembresia();
                double costo = usuario.getMembresia().getCosto();

                ingresosPorMembresia.put(tipoMembresia,
                        ingresosPorMembresia.getOrDefault(tipoMembresia, 0.0) + costo);
                cantidadPorMembresia.put(tipoMembresia,
                        cantidadPorMembresia.getOrDefault(tipoMembresia, 0) + 1);
            }
        }

        double ingresosTotales = ingresosPorMembresia.values().stream().mapToDouble(Double::doubleValue).sum();

        reporte.append("INGRESOS TOTALES: $").append(String.format("%,.2f", ingresosTotales)).append("\n\n");

        reporte.append("DETALLE POR TIPO DE MEMBRESÍA:\n");
        ingresosPorMembresia.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> {
                    String tipo = entry.getKey();
                    double ingreso = entry.getValue();
                    int cantidad = cantidadPorMembresia.get(tipo);
                    double porcentaje = (ingreso * 100.0) / ingresosTotales;

                    reporte.append("- ").append(tipo).append(": ")
                            .append("$").append(String.format("%,.2f", ingreso))
                            .append(" (").append(cantidad).append(" usuarios, ")
                            .append(String.format("%.1f", porcentaje)).append("%)\n");
                });
        reporte.append("\nINGRESOS POR PERÍODO:\n");
        Map<String, Double> ingresosPorPeriodo = new HashMap<>();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getMembresia() != null && usuario.getMembresia().isEstado()) {
                String periodo = usuario.getMembresia().getPeriodoMembresia().name();
                double costo = usuario.getMembresia().getCosto();
                ingresosPorPeriodo.put(periodo, ingresosPorPeriodo.getOrDefault(periodo, 0.0) + costo);
            }
        }

        ingresosPorPeriodo.forEach((periodo, ingreso) -> {
            reporte.append("- ").append(periodo).append(": $")
                    .append(String.format("%,.2f", ingreso)).append("\n");
        });

        return reporte.toString();
    }

    public String generarReporteClasesPopulares() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("--- REPORTE DE CLASES POPULARES ---\n\n");

        Map<String, Integer> popularidadClases = new HashMap<>();
        Map<String, Double> ocupacionClases = new HashMap<>();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getClase() != null) {
                String nombreClase = usuario.getClase().getNombre();
                popularidadClases.put(nombreClase, popularidadClases.getOrDefault(nombreClase, 0) + 1);
            }
        }
        for (Clase clase : listaClases) {
            int usuariosInscritos = obtenerCantidadUsuariosEnClase(clase);
            double porcentajeOcupacion = (usuariosInscritos * 100.0) / clase.getCupoMaximo();
            ocupacionClases.put(clase.getNombre(), porcentajeOcupacion);
        }

        reporte.append("CLASES MÁS POPULARES:\n");
        popularidadClases.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    String clase = entry.getKey();
                    int usuarios = entry.getValue();
                    double ocupacion = ocupacionClases.getOrDefault(clase, 0.0);

                    reporte.append("- ").append(clase).append(": ")
                            .append(usuarios).append(" usuarios")
                            .append(" (").append(String.format("%.1f", ocupacion)).append("% de ocupación)\n");
                });
        if (!popularidadClases.isEmpty()) {
            String claseMasPopular = popularidadClases.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .get().getKey();
            reporte.append("\nCLASE MÁS POPULAR: ").append(claseMasPopular)
                    .append(" (").append(popularidadClases.get(claseMasPopular)).append(" usuarios)\n");
        }

        return reporte.toString();
    }

    public String generarReporteUsuariosPorTipo() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("--- REPORTE DE USUARIOS POR TIPO ---\n\n");

        Map<String, Long> usuariosPorTipo = listaUsuarios.stream()
                .collect(Collectors.groupingBy(Usuario::getTipo, Collectors.counting()));

        int totalUsuarios = listaUsuarios.size();

        reporte.append("DISTRIBUCIÓN DE USUARIOS:\n");
        usuariosPorTipo.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> {
                    String tipo = entry.getKey();
                    long cantidad = entry.getValue();
                    double porcentaje = (cantidad * 100.0) / totalUsuarios;

                    reporte.append("- ").append(tipo).append(": ")
                            .append(cantidad).append(" usuarios")
                            .append(" (").append(String.format("%.1f", porcentaje)).append("%)\n");
                });

        reporte.append("\nTOTAL GENERAL: ").append(totalUsuarios).append(" usuarios\n");

        return reporte.toString();
    }
    public String generarReporteUsuariosActivos() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("--- REPORTE DE USUARIOS ACTIVOS ---\n\n");

        long usuariosActivos = listaUsuarios.stream()
                .filter(u -> u.getMembresia() != null && u.getMembresia().isEstado())
                .count();

        long usuariosInactivos = listaUsuarios.size() - usuariosActivos;
        double porcentajeActivos = listaUsuarios.isEmpty() ? 0 :
                (usuariosActivos * 100.0) / listaUsuarios.size();

        reporte.append("RESUMEN GENERAL:\n");
        reporte.append("Total de Usuarios: ").append(listaUsuarios.size()).append("\n");
        reporte.append("Usuarios Activos: ").append(usuariosActivos).append("\n");
        reporte.append("Usuarios Inactivos: ").append(usuariosInactivos).append("\n");
        reporte.append("Porcentaje de Activos: ").append(String.format("%.1f", porcentajeActivos)).append("%\n\n");

        reporte.append("DETALLE DE USUARIOS ACTIVOS:\n");
        listaUsuarios.stream()
                .filter(u -> u.getMembresia() != null && u.getMembresia().isEstado())
                .forEach(usuario -> {
                    reporte.append("- ").append(usuario.getNombre()).append(" ").append(usuario.getApellido())
                            .append(" (").append(usuario.getIdentificacion()).append(")")
                            .append(" - ").append(usuario.getMembresia().getTipoMembresia())
                            .append(" - Vence: ").append(usuario.getMembresia().getFechaFinal())
                            .append("\n");
                });

        return reporte.toString();
    }

    public String generarReporteClasesMasReservadas() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("--- REPORTE DE CLASES MÁS RESERVADAS ---\n\n");

        Map<String, Integer> reservasPorClase = new HashMap<>();
        Map<String, Double> ingresosPorClase = new HashMap<>();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getClase() != null) {
                String nombreClase = usuario.getClase().getNombre();
                reservasPorClase.put(nombreClase, reservasPorClase.getOrDefault(nombreClase, 0) + 1);
                if (usuario.getMembresia() != null) {
                    double ingreso = usuario.getMembresia().getCosto() / 30;
                    ingresosPorClase.put(nombreClase, ingresosPorClase.getOrDefault(nombreClase, 0.0) + ingreso);
                }
            }
        }

        reporte.append("CLASES POR POPULARIDAD:\n");
        reservasPorClase.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    String clase = entry.getKey();
                    int reservas = entry.getValue();
                    double ingresoDiario = ingresosPorClase.getOrDefault(clase, 0.0);
                    double ingresoMensual = ingresoDiario * 30;

                    reporte.append("- ").append(clase).append(": ")
                            .append(reservas).append(" reservas")
                            .append(" - Ingreso mensual estimado: $").append(String.format("%,.2f", ingresoMensual))
                            .append("\n");
                });
        if (!reservasPorClase.isEmpty()) {
            int totalReservas = reservasPorClase.values().stream().mapToInt(Integer::intValue).sum();
            String claseMasPopular = reservasPorClase.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .get().getKey();

            reporte.append("\nESTADÍSTICAS:\n");
            reporte.append("Total de Reservas: ").append(totalReservas).append("\n");
            reporte.append("Clase Más Popular: ").append(claseMasPopular)
                    .append(" (").append(reservasPorClase.get(claseMasPopular)).append(" reservas)\n");
            reporte.append("Promedio de Reservas por Clase: ")
                    .append(String.format("%.1f", (double) totalReservas / reservasPorClase.size())).append("\n");
        }

        return reporte.toString();
    }

    public String generarReporteVencimientoMembresias() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("--- REPORTE DE VENCIMIENTO DE MEMBRESÍAS ---\n\n");

        LocalDate hoy = LocalDate.now();
        LocalDate enUnaSemana = hoy.plusWeeks(1);
        LocalDate enUnMes = hoy.plusMonths(1);

        List<Usuario> vencenEstaSemana = new ArrayList<>();
        List<Usuario> vencenEsteMes = new ArrayList<>();
        List<Usuario> vencidas = new ArrayList<>();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getMembresia() != null && usuario.getMembresia().isEstado()) {
                LocalDate fechaVencimiento = usuario.getMembresia().getFechaFinal();

                if (fechaVencimiento.isBefore(hoy)) {
                    vencidas.add(usuario);
                } else if (fechaVencimiento.isBefore(enUnaSemana) || fechaVencimiento.isEqual(enUnaSemana)) {
                    vencenEstaSemana.add(usuario);
                } else if (fechaVencimiento.isBefore(enUnMes) || fechaVencimiento.isEqual(enUnMes)) {
                    vencenEsteMes.add(usuario);
                }
            }
        }
        reporte.append("ALERTAS DE VENCIMIENTO:\n");
        reporte.append("Membresías Vencidas: ").append(vencidas.size()).append("\n");
        reporte.append("Vencen en los próximos 7 días: ").append(vencenEstaSemana.size()).append("\n");
        reporte.append("Vencen en los próximos 30 días: ").append(vencenEsteMes.size()).append("\n\n");

        if (!vencidas.isEmpty()) {
            reporte.append("MEMBRESÍAS VENCIDAS (URGENTE):\n");
            vencidas.forEach(usuario -> {
                long diasVencidos = java.time.temporal.ChronoUnit.DAYS.between(
                        usuario.getMembresia().getFechaFinal(), hoy);
                reporte.append("- ").append(usuario.getNombre()).append(" ").append(usuario.getApellido())
                        .append(" - Vencida hace ").append(diasVencidos).append(" días")
                        .append(" - ").append(usuario.getMembresia().getTipoMembresia())
                        .append("\n");
            });
            reporte.append("\n");
        }
        if (!vencenEstaSemana.isEmpty()) {
            reporte.append("VENCEN ESTA SEMANA:\n");
            vencenEstaSemana.forEach(usuario -> {
                long diasRestantes = java.time.temporal.ChronoUnit.DAYS.between(
                        hoy, usuario.getMembresia().getFechaFinal());
                reporte.append("- ").append(usuario.getNombre()).append(" ").append(usuario.getApellido())
                        .append(" - Vence en ").append(diasRestantes).append(" días")
                        .append(" - ").append(usuario.getMembresia().getTipoMembresia())
                        .append("\n");
            });
            reporte.append("\n");
        }

        if (!vencenEsteMes.isEmpty()) {
            reporte.append("VENCEN ESTE MES:\n");
            vencenEsteMes.forEach(usuario -> {
                long diasRestantes = java.time.temporal.ChronoUnit.DAYS.between(
                        hoy, usuario.getMembresia().getFechaFinal());
                reporte.append("- ").append(usuario.getNombre()).append(" ").append(usuario.getApellido())
                        .append(" - Vence en ").append(diasRestantes).append(" días")
                        .append(" - ").append(usuario.getMembresia().getTipoMembresia())
                        .append("\n");
            });
        }

        if (vencidas.isEmpty() && vencenEstaSemana.isEmpty() && vencenEsteMes.isEmpty()) {
            reporte.append("✅ No hay membresías próximas a vencer.\n");
        }

        return reporte.toString();
    }
}
