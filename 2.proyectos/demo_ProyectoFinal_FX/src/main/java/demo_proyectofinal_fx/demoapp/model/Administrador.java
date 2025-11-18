package demo_proyectofinal_fx.demoapp.model;

import demo_proyectofinal_fx.demoapp.utils.DataUtil;

public class Administrador extends UsuarioSistema{

    private Gimnasio gimnasio;  // relación con Gimnasio (para acceder a entrenadores, clases)

    public Administrador(String nombre,String apellido, String id, int edad, String telefono, String contrasena, Gimnasio gimnasio) {
        super(nombre,apellido, id, edad, telefono, contrasena);
        this.gimnasio = gimnasio;
    }

    public Entrenador registrarEntrenador(String nombre, String apellido, String id, int edad, String telefono) {
        Entrenador nuevo = Entrenador.registrarEntrenador(nombre, apellido, id, edad, telefono);
        gimnasio.getListaEntrenadores().add(nuevo);
        return nuevo;
    }

    public void modificarEntrenador() {
        String id = DataUtil.leerStringConsola("Ingrese la identificacion del entrenador a modificar: ");
        Entrenador resultado = Entrenador.obtenerEntrenador(gimnasio, id);
        if(resultado != null) {
            Entrenador.modificarEntrenador(resultado);
            System.out.println("✅ Entrenador modificado correctamente.");
        } else {
            System.out.println("❌ No existe un entrenador con ese ID.");
        }
    }
    public boolean eliminarEntrenador(String id) {

        Entrenador resultado = Entrenador.obtenerEntrenador(gimnasio, id);

        if (resultado != null) {
            gimnasio.getListaEntrenadores().remove(resultado);
            return true;
        }

        return false;
    }
    public boolean asignarEntrenador(String idEntrenador, String nombreClase) {
        Entrenador entrenador = Entrenador.obtenerEntrenador(gimnasio, idEntrenador);
        if (entrenador == null) {
            System.out.println("❌ Entrenador no encontrado.");
            return false;
        }
        Clase clase = gimnasio.obtenerClase(nombreClase);
        if (clase == null) {
            System.out.println("❌ Clase no encontrada.");
            return false;
        }
        clase.asignarEntrenador(entrenador);
        entrenador.agregarClase(nombreClase);
        return true;
    }
    public void controlarAcceso() {
        String idUsuario = DataUtil.leerStringConsola("Ingrese identificación del usuario: ");
        Usuario usuario = gimnasio.obtenerUsuario(idUsuario);
        if (usuario == null) {
            System.out.println("❌ Usuario no encontrado.");
            return;
        }
        if(!usuario.tieneMembresiaActiva()){
            System.out.println("❌ Membresía inactiva. No puede ingresar.");
            return;
        }
        String nombreClase = DataUtil.leerStringConsola("Ingrese el nombre de la clase a la que desea acceder: ");
        Clase clase = gimnasio.obtenerClase(nombreClase);

        if(clase == null){
            System.out.println("❌ La clase no existe.");
            return;
        }

        if(clase.getListaUsuarios().size() >= clase.getCupoMaximo()){
            System.out.println("❌ La clase está llena.");
            return;
        }
        clase.inscribirUsuario(usuario);

        System.out.println("✅ Acceso concedido a la clase: " + clase.getNombre());

    }




}
