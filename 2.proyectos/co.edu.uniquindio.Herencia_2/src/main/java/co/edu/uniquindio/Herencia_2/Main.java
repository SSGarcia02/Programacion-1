package co.edu.uniquindio.Herencia_2;

import co.edu.uniquindio.Herencia_2.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dependencia dependencia = inicializarDatos();
        int opcion = 0;
        do{
            mostrarMenu();
            opcion = leerEntero("=========== Ingrese la opcion del menu ============");
            switch (opcion){
                case 1:
                    crearDocente(dependencia);
                    System.out.println("Informacion del Docente :"+'\n' +dependencia);
                    break;
                case 2:
                    System.out.println("Lista de Docentes:\n");
                    listarDocente(dependencia);
                    break;
                case 3:
                    int cedulaBorrar = leerEntero("Ingreese la cedula del Docente a borrar");
                    borrarDocente(dependencia, cedulaBorrar);
                    break;
                case 4:
                    editarDocente(dependencia);
                    break;
            }
        }while (opcion !=8);
        System.out.println("Good Bye!");

    }
    public static void listarDocente(Dependencia dependencia){
        ArrayList<Docente> listaDocentes = dependencia.listarDocente();
        for(int i = 0; i < listaDocentes.size(); i++){
            System.out.println("Docente N "+(i +1)+". "+listaDocentes.get(i)+"\n");
        }
    }
    public static void crearDocente(Dependencia dependencia){
        String nombre = leerStringConsola("Inrege el nombre del Docente: ");
        int cedula = leerEntero("Ingrese la cedula del Docente");
         Docente docente = new Docente();
         docente.setNombre(nombre);
         docente.setCedula(cedula);
        boolean resultado = dependencia.crearDocente(docente);

        if(resultado){
            System.out.println("\nDocente creado exitosamente\n");
        }else{
            System.out.println("\nNo es posible crear al Docente - El numero de cedula del estudiante ya existe en la base de datos\n");

        }
    }
    public static void editarDocente(Dependencia dependencia){
        int cedulaActual = leerEntero("Ingrese la cédula del docente a editar: ");

        Docente docenteExistente = dependencia.obternerDocente(cedulaActual);
        if(docenteExistente == null){
            System.out.println("No se encontró docente con cédula: " + cedulaActual);
            return;
        }
        System.out.println("\nInformación actual del docente:");
        System.out.println("Nombre: " + docenteExistente.getNombre());
        System.out.println("Cédula: " + docenteExistente.getCedula());

        // Pedir nueva información
        System.out.println("\nIngrese los nuevos datos:");
        String nuevoNombre = leerStringConsola("Nuevo nombre: ");
        int nuevaCedula = leerEntero("Nueva cédula: ");

        // Crear objeto Docente con la nueva información
        Docente docenteEditado = new Docente();
        docenteEditado.setNombre(nuevoNombre);
        docenteEditado.setCedula(cedulaActual); // Mantener la cédula actual para búsqueda

        // Llamar metodo editar
        boolean resultado = dependencia.editarDocente(docenteEditado, nuevaCedula);
        if(resultado){
            System.out.println("\nDocente editado exitosamente\n");
        }else{
            System.out.println("\nNo es posible editar al Docente - El numero de cedula del docente ya existe en la base de datos\n");

        }

    }
    public static void borrarDocente(Dependencia dependencia, int cedula){
        boolean resulado = dependencia.borrarDocente(cedula);
        if(resulado){
            System.out.println("\nDocente borrado exitosamente\n");
        }else{
            System.out.println("\nNo es posible borrar al Docente - El numero de cedula del Docente no existe en la base de datos\n");

        }
    }
    public static void calcularSalarioDocentePlanta(Dependencia dependencia, DocentePlanta docentePlanta){
        double salarioTotal = dependencia.calcularSalarioDocente(docentePlanta.getCantidadPuntos());

        System.out.println("El salario del profesor de planta "+docentePlanta.getNombre()+" = "+salarioTotal);
    }
    public static void calcularSalarioDocenteContrato(Dependencia dependencia, DocenteContrato docenteContrato){
        double salarioTotal = dependencia.calcularSalarioDocente(docenteContrato.getCategoria());
        System.out.println("El salario del profesor "+docenteContrato.getNombre()+" de tipo de contrato "+docenteContrato.getCategoria()+" = "+salarioTotal);

    }

    public static Dependencia inicializarDatos(){
        Dependencia dependencia = new Dependencia();

        DocentePlanta docentePlanta1 = new DocentePlanta();
        docentePlanta1.setNombre("Juan");
        docentePlanta1.setCedula(1001);
        docentePlanta1.setCantidadPuntos(20);

        DocenteContrato docenteContrato1 = new DocenteContrato();
        docenteContrato1.setNombre("David");
        docenteContrato1.setCedula(1002);
        docenteContrato1.setCategoria(Categoria.AUXILIAR);

        dependencia.getListaDocentes().add(docentePlanta1);
        dependencia.getListaDocentes().add(docenteContrato1);

        return dependencia;
    }
    public static void mostrarMenu() {
        System.out.println("1 - Crear Docente");
        System.out.println("2 - Mostrar lista de Docentes");
        System.out.println("3 - Borrar Docente");
        System.out.println("4 - Editar Docente");
        System.out.println("5 - ");
        System.out.println("8 - Salir");
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