package demo_proyectofinal_fx.demoapp.model;

import demo_proyectofinal_fx.demoapp.utils.DataUtil;

import java.util.ArrayList;

public class Entrenador extends Persona{
    private Membresia membresia;
    private ArrayList<Clase> listaClases = new ArrayList<>();

    public Entrenador(Membresia membresia, ArrayList<Clase> listaClases) {
        this.membresia = membresia;
        this.listaClases = listaClases;
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

    public ArrayList<Clase> getListaClases() {
        return listaClases;
    }

    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    public static Entrenador registrarEntrenador(String nombre, String apellido, String id, int edad, String telefono){
        return new Entrenador(nombre, apellido, id, edad, telefono);
    }
    public static Entrenador obtenerEntrenador(Gimnasio gimnasio, String identificacion) {
        Entrenador buscarId = null;
        for(int i=0;i<gimnasio.getListaEntrenadores().size();i++){
            if(gimnasio.getListaEntrenadores().get(i).getIdentificacion().equals(identificacion) ){
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

}
