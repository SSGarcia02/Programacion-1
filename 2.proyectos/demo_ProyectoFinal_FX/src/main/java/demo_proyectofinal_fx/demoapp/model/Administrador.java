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
    public void asignarEntrenadorClases(){
        String id = DataUtil.leerStringConsola("Ingrese la identificacion del entrenador a asignar: ");
        Entrenador resultado = Entrenador.obtenerEntrenador(gimnasio, id);
        if(resultado != null) {
            String nombreClase = DataUtil.leerStringConsola("Ingrese el nombre de la clase: ");
            Clase clase = gimnasio.obtenerClase(nombreClase);
            if(clase != null){
                clase.asignarEntrenador(resultado);
                System.out.println("✅ Entrenador asignado correctamente.");}
            else{
                System.out.println("❌ la clase no fue encontrada");
            }
        } else {
            System.out.println("❌ No existe un entrenador con ese ID.");
        }

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
