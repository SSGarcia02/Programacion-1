package demo_proyectofinal_fx.demoapp.model;

import demo_proyectofinal_fx.demoapp.utils.DataUtil;

import java.util.ArrayList;

public class Entrenador extends Persona {
    private Membresia membresia;
    private ArrayList<String> clasesAsignadas = new ArrayList<>();

    public Entrenador(Membresia membresia, ArrayList<String> clasesAsignadas) {
        this.membresia = membresia;
        this.clasesAsignadas = clasesAsignadas;
    }
    public Entrenador() {}
    public Entrenador(String nombre, String apellido, String identificacion, int edad, String telefono) {
        super(nombre, apellido, identificacion, edad, telefono);
    }
    public Membresia getMembresia() {
        return membresia;
    }
    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
    public ArrayList<String> getClasesAsignadas() {
        return clasesAsignadas;
    }
    public void setClasesAsignadas(ArrayList<String> clasesAsignadas) {
        this.clasesAsignadas = clasesAsignadas;
    }
    public static Entrenador registrarEntrenador(String nombre, String apellido, String id, int edad, String telefono){
        return new Entrenador(nombre, apellido, id, edad, telefono);
    }
    public static Entrenador obtenerEntrenador(Gimnasio gimnasio, String identificacion) {
        Entrenador buscarId = null;
        for(int i = 0; i < gimnasio.getListaEntrenadores().size(); i++){
            if(gimnasio.getListaEntrenadores().get(i).getIdentificacion().equals(identificacion)){
                buscarId = gimnasio.getListaEntrenadores().get(i);
            }
        }
        return buscarId;
    }
    public static void modificarEntrenador(Entrenador entrenador){
        String nombre = DataUtil.leerStringConsola("Ingrese el nombre del Entrenador: ");
        String apellido = DataUtil.leerStringConsola("Ingrese el apellido del Entrenador: ");
        String identificacion = DataUtil.leerStringConsola("Ingrese la identificacion del Entrenador: ");
        int edad = DataUtil.leerEntero("Ingrese la edad del entrenador: ");
        String telefono = DataUtil.leerStringConsola("Ingrese el telefono del entrenador: ");
        entrenador.setNombre(nombre);
        entrenador.setApellido(apellido);
        entrenador.setIdentificacion(identificacion);
        entrenador.setEdad(edad);
        entrenador.setTelefono(telefono);
    }
    public void limpiarClases() {
        clasesAsignadas.clear();
    }

    public String getClasesAsString() {
        if (clasesAsignadas.isEmpty()) {
            return "Sin asignar";
        }
        return String.join(", ", clasesAsignadas);
    }

    public void agregarClase(String nombreClase) {
        if (!clasesAsignadas.contains(nombreClase)) {
            clasesAsignadas.add(nombreClase);
        }
    }

    public void eliminarClase(String nombreClase) {
        clasesAsignadas.remove(nombreClase);
    }
}
