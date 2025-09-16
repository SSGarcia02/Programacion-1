package co.edu.uniquindio.TestType;

import co.edu.uniquindio.TestType.model.Docente;
import co.edu.uniquindio.TestType.model.Estudiante;

import javax.print.Doc;

public class Main {
    public static void main(String[] args) {

        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Juan");
        estudiante1.setApellido("Perez");
        estudiante1.setEdad(20);
        estudiante1.setNota1(3.8);
        estudiante1.setNota2(2.5);
        estudiante1.setNota3(1.5);
        estudiante1.setNota4(3.0);

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Julian");
        estudiante2.setApellido("Alavarez");
        estudiante2.setEdad(19);
        estudiante2.setNota1(4.4);
        estudiante2.setNota2(3.5);
        estudiante2.setNota3(2.9);
        estudiante2.setNota4(4.6);

        Estudiante estudiante3 = new Estudiante();
        estudiante3.setNombre("Sebastian");
        estudiante3.setApellido("Garcia");
        estudiante3.setEdad(24);
        estudiante3.setNota1(5.0);
        estudiante3.setNota2(4.4);
        estudiante3.setNota3(4.8);
        estudiante3.setNota4(4.5);

        Docente docente1 = new Docente();
        docente1.setNombre("Oscar");
        docente1.setSalario(3000);
        docente1.setEdad(30);

        Docente docente2 = new Docente();
        docente2.setNombre("Melissa");
        docente2.setSalario(3500);
        docente2.setEdad(45);

        System.out.println(" ");
        obtenerNotaMayorEstudiante(docente1, estudiante1);
        obternerNotaMenorEstudiante(docente1, estudiante1);
        obtenerPormedioEstudiante(docente1, estudiante1);
        aprobacionEstudianteCurso(docente1, estudiante1);
        obtenerNumeroConsonates(docente1, estudiante1);
        obtenerEstudianteNotasMayorA4(docente1, estudiante1);
        System.out.println(" ");
        obtenerNotaMayorEstudiante(docente1, estudiante2);
        obternerNotaMenorEstudiante(docente1, estudiante2);
        obtenerPormedioEstudiante(docente1, estudiante2);
        aprobacionEstudianteCurso(docente1, estudiante2);
        obtenerNumeroConsonates(docente1, estudiante2);
        obtenerEstudianteNotasMayorA4(docente1, estudiante2);
        System.out.println(" ");
        obtenerNotaMayorEstudiante(docente1, estudiante3);
        obternerNotaMenorEstudiante(docente1, estudiante3);
        obtenerPormedioEstudiante(docente1, estudiante3);
        aprobacionEstudianteCurso(docente1, estudiante3);
        obtenerNumeroConsonates(docente1, estudiante3);
        obtenerEstudianteNotasMayorA4(docente1, estudiante3);

    }
    public static void obtenerNotaMayorEstudiante(Docente docente, Estudiante estudiante){
        double notaMayor = docente.obtenerNotaMayorEstudiante(estudiante.getNota1(),
                estudiante.getNota2(),
                estudiante.getNota3(),
                estudiante.getNota4());
        System.out.println("Nota mayor del estudiante: "+estudiante.getNombre()+" "
                +estudiante.getApellido()+" = "+notaMayor);
    }
    public static void obternerNotaMenorEstudiante(Docente docente, Estudiante estudiante){
        double notaMenor = docente.obternerNotaMenorEstudiante(estudiante.getNota1(),
                estudiante.getNota2(),
                estudiante.getNota3(),
                estudiante.getNota4());
        System.out.println("Nota menor del estudiante: "+estudiante.getNombre()+" "
                +estudiante.getApellido()+" = "+notaMenor);
    }
    public static void obtenerPormedioEstudiante(Docente docente, Estudiante estudiante){
        double promedio = docente.obtenerPormedioEstudiante(estudiante.getNota1(),
                estudiante.getNota2(),
                estudiante.getNota3(),
                estudiante.getNota4());
        System.out.println("Promedio del estudiante: "+estudiante.getNombre()+" "
                +estudiante.getApellido()+" = "+promedio);
    }
    public static void aprobacionEstudianteCurso(Docente docente, Estudiante estudiante){
        boolean notaDefinitiva = docente.aprobacionEstudianteCurso(estudiante.getNota1(),
                estudiante.getNota2(),
                estudiante.getNota3(),
                estudiante.getNota4());
        if(notaDefinitiva == true){
             System.out.println("El estudiante: "+estudiante.getNombre()+" "
                    +estudiante.getApellido()+", aprobo el curso");
        }else{
            System.out.println("El estudiante: "+estudiante.getNombre()+" "
                    +estudiante.getApellido()+", reaprobo el curso");;
        }
    }
    public static void obtenerNumeroConsonates(Docente docente, Estudiante estudiante){
        boolean estudianteConsonantes = docente.obtenerNumeroConsonates(estudiante.getNombre());
        if(estudianteConsonantes == true){
            System.out.println("El nombre del estudiante tiene mas de 3 consonantes");
        }else{
            System.out.println("El nombre del estudiante tiene 3 o menos consonanttes");
        }
    }
    public static void obtenerEstudianteNotasMayorA4(Docente docente, Estudiante estudiante){
        boolean notaMayorA4 = docente.obtenerEstudianteNotasMayorA4(estudiante.getNota1(),
                estudiante.getNota2(),
                estudiante.getNota3(),
                estudiante.getNota4());
        if(notaMayorA4 == true){
            System.out.println(estudiante.getNombre()+" "+estudiante.getApellido()+" tiene todas sus notas superiores a 4.0");
        }
    }
}