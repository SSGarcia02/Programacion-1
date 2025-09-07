package co.edu.uniquindio.CasoUniversidad;

import co.edu.uniquindio.CasoUniversidad.model.Curso;
import co.edu.uniquindio.CasoUniversidad.model.Docente;
import co.edu.uniquindio.CasoUniversidad.model.Estudiante;

public class Main {
    public static void main(String[] args) {

    }
    public Curso inicializarDatos(){
        //crear curso
        Curso curso = new Curso();
        curso.setNombre("Calculo");
        curso.setSemestre(3);
        curso.setGrupo("1");
        curso.setCreditos(4);
        curso.setJornada("Nocturna");
        //crear Docente
        Docente docente = new Docente();
        docente.setNombre("Andres Garcia");
        docente.setEdad(30);
        docente.setCorreo("andres@uniquindio.co");
        //crear Estudiantes
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Juan");
        estudiante1.setEdad(20);
        estudiante1.setCorreo("juan@uniquindio.co");
        estudiante1.setSemestre(3);
        estudiante1.setNota1(3.5);
        estudiante1.setNota2(2.9);
        estudiante1.setNota3(4.0);

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Jose");
        estudiante2.setEdad(17);
        estudiante2.setCorreo("jose@uniquindio.co");
        estudiante2.setSemestre(3);
        estudiante2.setNota1(1.9);
        estudiante2.setNota2(2.2);
        estudiante2.setNota3(3.3);

        Estudiante estudiante3 = new Estudiante();
        estudiante3.setNombre("Julian");
        estudiante3.setEdad(24);
        estudiante3.setCorreo("julian@uniquindio.co");
        estudiante3.setSemestre(3);
        estudiante3.setNota1(4.5);
        estudiante3.setNota2(4.8);
        estudiante3.setNota3(4.1);

        curso.getListaEstudiantes().add(estudiante1);
        curso.getListaEstudiantes().add(estudiante2);
        curso.getListaEstudiantes().add(estudiante3);
        return curso;
    }
}