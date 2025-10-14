package co.edu.uniquindio.CasoUniversidad;

import co.edu.uniquindio.CasoUniversidad.model.Curso;
import co.edu.uniquindio.CasoUniversidad.model.Docente;
import co.edu.uniquindio.CasoUniversidad.model.Estudiante;
import co.edu.uniquindio.CasoUniversidad.model.Universidad;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Universidad universidad = inicializarDatos();
        int opcion = 0;
        do{
            mostrarMenu();
            opcion = leerEntero("Ingrese la opcion del menu");
            switch (opcion){
                case 1:
                    crearEstudiante(universidad);
                    System.out.println("Informacion del estudiante: "+universidad);
                    break;
                case 2:
                    mostrarListaEstudiante(universidad);
                    System.out.println("Lista de estudiantes:\n");
                    break;
                case 3:
                    String idborrar = leerStringConsola("Ingreese la cedula del estudiante a borrar");
                    borrarEstudiante(universidad, idborrar);
                    break;
                case 4:
                    String edEditar = leerStringConsola("Ingreese la cedula del estudiante a editar");
                    editarEstudiante(universidad, edEditar);
                    break;
            }
        }while (opcion!=8);
    }
    public static Universidad inicializarDatos(){
        //crear curso
        Universidad universidad = new Universidad("UQ");

        Curso curso = new Curso();
        curso.setNombre("Calculo");
        curso.setSemestre(3);
        curso.setGrupo("1");
        curso.setCreditos(4);
        curso.setJornada("Nocturna");
        universidad.getListaCursos().add(curso);
        //crear Docente
        Docente docente = new Docente();
        docente.setNombre("Andres Garcia");
        docente.setEdad(30);
        docente.setCorreo("andres@uniquindio.co");
        universidad.getListaDocente().add(docente);
        //crear Estudiantes
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Juan");
        estudiante1.setEdad(20);
        estudiante1.setIdentificacion("1001");
        estudiante1.setCorreo("juan@uniquindio.co");
        estudiante1.setSemestre(3);
        estudiante1.setNota1(3.5);
        estudiante1.setNota2(2.9);
        estudiante1.setNota3(4.0);

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Jose");
        estudiante2.setEdad(17);
        estudiante2.setIdentificacion("1002");
        estudiante2.setCorreo("jose@uniquindio.co");
        estudiante2.setSemestre(3);
        estudiante2.setNota1(1.9);
        estudiante2.setNota2(2.2);
        estudiante2.setNota3(3.3);

        Estudiante estudiante3 = new Estudiante();
        estudiante3.setNombre("Julian");
        estudiante3.setEdad(24);
        estudiante3.setIdentificacion("1003");
        estudiante3.setCorreo("julian@uniquindio.co");
        estudiante3.setSemestre(3);
        estudiante3.setNota1(4.5);
        estudiante3.setNota2(4.8);
        estudiante3.setNota3(4.1);
        universidad.getListaEstudiantes().add(estudiante1);
        universidad.getListaEstudiantes().add(estudiante2);
        universidad.getListaEstudiantes().add(estudiante3);
        return universidad;
    }
    public  static void mostrarListaEstudiante(Universidad universidad){
        ArrayList<Estudiante> listaEstudiantes = universidad.mostrarListaEstudiante();
        for(int i = 0; i < listaEstudiantes.size(); i++){
            System.out.println((i +1)+". "+listaEstudiantes.get(i)+"\n");
        }
    }
    public static void editarEstudiante(Universidad universidad, String id){
        String nombre = leerStringConsola("Inrege el nombre del estudiante: ");
        int edad = leerEntero("Inrege la edad del estudiante: ");
        String identificacion = leerStringConsola("Inrege la identificacion del estudiante: ");
        String correo = leerStringConsola("Inrege el correo del estudiante: ");
        int semestre = leerEntero("Inrege el semestre del estudiante: ");
        double nota1 = leerDoubleConsola("Inrege la nota 1 del estudiante: ");
        double nota2 = leerDoubleConsola("Inrege la nota 2 del estudiante: ");
        double nota3 = leerDoubleConsola("Inrege la nota 3 del estudiante: ");

        boolean resultado = universidad.crearEstudiante(nombre, edad, identificacion, correo, semestre, nota1, nota2, nota3);

        if(resultado){
            System.out.println("Estudiante editado exitosamente");
        }else{
            System.out.println("No es posible editar al estudiante - El numero de cedula del estudiante ya existe en la base de datos");

        }
    }
    public static void crearEstudiante(Universidad universidad){
        String nombre = leerStringConsola("Inrege el nombre del estudiante: ");
        int edad = leerEntero("Inrege la edad del estudiante: ");
        String identificacion = leerStringConsola("Inrege la identificacion del estudiante: ");
        String correo = leerStringConsola("Inrege el correo del estudiante: ");
        int semestre = leerEntero("Inrege el semestre del estudiante: ");
        double nota1 = leerDoubleConsola("Inrege la nota 1 del estudiante: ");
        double nota2 = leerDoubleConsola("Inrege la nota 2 del estudiante: ");
        double nota3 = leerDoubleConsola("Inrege la nota 3 del estudiante: ");

        boolean resultado = universidad.crearEstudiante(nombre, edad, identificacion, correo, semestre, nota1, nota2, nota3);

        if(resultado){
            System.out.println("Estudiante creado exitosamente");
        }else{
            System.out.println("No es posible crear al estudiante - El numero de cedula del estudiante ya existe en la base de datos");

        }
    }

    public static void borrarEstudiante(Universidad universidad, String identificacion){
        boolean resultado = universidad.borrarEstudiante(identificacion);
        if(resultado){
            System.out.println("Estudiante borrado exitosamente");
        }else{
            System.out.println("No es posible borrar al estudiante - El numero de cedula del estudiante no existe en la base de datos");
        }
    }
    public static void mostrarMenu() {
        System.out.println("1 - Crear Estudiante");
        System.out.println("2 - Mostrar lista de estudiantes");
        System.out.println("3 - Borrar Estudiante");
        System.out.println("4 - Editar Estudiante");
        System.out.println("5 - ");
        System.out.println("6 - Salir");
    }
    public static String leerStringConsola(String mensaje)
    {
        String captura="";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        return captura;
    }

    private static int leerEntero(String mensaje) {
        int dato = 0;
        String captura = "";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        dato = Integer.parseInt(captura);
        return dato;
    }
    public static double leerDoubleConsola(String mensaje)
    {
        double dato=0;
        String captura="";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        dato=Double.parseDouble(captura);
        return dato;
    }


}