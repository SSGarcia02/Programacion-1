package co.edu.uniquindio.CasoUniversidad.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Universidad {
    private String nombre;

    private ArrayList<Estudiante> listaEstudiantes = new ArrayList();
    private ArrayList<Docente> listaDocente = new ArrayList<>();
    private ArrayList<Curso> listaCursos = new ArrayList<>();
    private Rector rector;

    public Universidad(){}
    public Universidad(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Estudiante> mostrarListaEstudiante(){
        return listaEstudiantes;
    }
    public boolean crearEstudiante(String nombre,
                                   int edad,
                                   String identificacion,
                                   String correo,
                                   int semestre,
                                   double nota1,
                                   double nota2,
                                   double nota3) {
        //Obtener el estduiante
        Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
        if(estudianteEncontrado == null) {
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre(nombre);
            estudiante.setEdad(edad);
            estudiante.setIdentificacion(identificacion);
            estudiante.setCorreo(correo);
            estudiante.setSemestre(semestre);
            estudiante.setNota1(nota1);
            estudiante.setNota2(nota2);
            estudiante.setNota3(nota3);

            getListaEstudiantes().add(estudiante);

            return true;
        }else{
            return false;
        }
    }
    public boolean editarEstudiante(String nombre,
                                    int edad,
                                    String identificacion,
                                    String correo,
                                    int semestre,
                                    double nota1,
                                    double nota2,
                                    double nota3){
        Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
        for(Estudiante estudiante : getListaEstudiantes()){
            if(estudiante.getIdentificacion().equalsIgnoreCase(identificacion)){
                estudianteEncontrado.setNombre(nombre);
                estudianteEncontrado.setEdad(edad);
                estudianteEncontrado.setIdentificacion(identificacion);
                estudianteEncontrado.setCorreo(correo);
                estudianteEncontrado.setSemestre(semestre);
                estudianteEncontrado.setNota1(nota1);
                estudianteEncontrado.setNota2(nota2);
                estudianteEncontrado.setNota3(nota3);

                return true;
            };
        }
        return false;
    }
    public boolean borrarEstudiante(String identificacion){
       Estudiante estudianteBorrar = obtenerEstudiante(identificacion);
       if(estudianteBorrar != null){
           getListaEstudiantes().remove(estudianteBorrar);
           return true;
       }else{
           return false;
       }
    }

    private Estudiante obtenerEstudiante(String identificacion) {
        Estudiante estudianteEncontrado =  null;
        for (Estudiante estudiante : getListaEstudiantes()) {
            if(estudiante.getIdentificacion().equalsIgnoreCase(identificacion)) {
                estudianteEncontrado = estudiante;
                break;
            }
        }

        return estudianteEncontrado;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
    public ArrayList<Docente> getListaDocente() {
        return listaDocente;
    }
    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }
}
