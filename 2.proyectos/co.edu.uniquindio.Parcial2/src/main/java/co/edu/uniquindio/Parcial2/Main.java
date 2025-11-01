package co.edu.uniquindio.Parcial2;

import co.edu.uniquindio.Parcial2.Model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Finca finca = inicializarDatos();
        int opcionMenuListar = 0;
        int opcionMenuPrincipal = 0;
        int opcionMenuTarea = 0;
        int MenuasignarTarea;

        do {
            System.out.println("=========== Menu Principal ============\n");
            mostrarMenu();
            opcionMenuPrincipal = leerEntero("=========== Ingrese la opcion del menu ============\n");
           switch (opcionMenuPrincipal){
               case 1:
                   System.out.println("=========== Menu de mostrar listas ============\n");
                   System.out.println("1. Ver lista de todos los empleados");
                   System.out.println("2. Ver listar de Tareas");
                   System.out.println("3. ");
                   System.out.println("4. ");
                   opcionMenuListar =
                           leerEntero("=========== Ingrese la opcio del tipo de lista que desea crear ============\n");
                   switch (opcionMenuListar){
                       case 1:
                           System.out.println("Lista de Empleados:"+'\n');
                           listarEmpleados(finca);
                           break;
                       case 2:
                           System.out.println("Lista de Tareas:"+'\n');
                           listarTareas(finca);
                           break;
                   }
                   break;
               case 2:
                   System.out.println("=========== Menu de administrar Tareas ============\n");
                   System.out.println("1. Crear tarea");
                   System.out.println("2. Editar tarea");
                   System.out.println("3. Borrar Tarea");

                   switch(opcionMenuTarea){
                       case 1:
                           crearTarea(finca);
                           break;
                       case 2:
                           break;
                   }
                   break;
               case 3:
                   System.out.println("=========== Menu de Asignar Tareas ============\n");
                   asignarTareaAdmin(finca);
                   break;
            }
        }while(opcionMenuPrincipal != 8);

    }
    //----------------------------------------------------------
    //Asignar tareas
    public static void asignarTareaAdmin(Finca  finca){
        System.out.println("lista de Administradores:\n");
        listarAdmins(finca);
        String cedulaAdmin = leerStringConsola("Ingrese la cedula del Administrador a asignar tarea");

        Administrador adminExistente = finca.obtenerAdmin(cedulaAdmin);
        if(adminExistente == null ){
            System.out.println("No se encontró Administradir con cédula: " + cedulaAdmin);
            return;
        }
        System.out.println("\nInformación del Administrador:");
        System.out.println(
                "Nombre: " + adminExistente.getNombre() + '\n' +
                        "Apellido: " + adminExistente.getApellido()+'\n' +
                        "Cedula: " + adminExistente.getCedula()+'\n');
        System.out.println("Lista de tareas.\n");
        listarTareas(finca);
        int tareaSeleccionada = leerEntero("Seleccione el ID de la tarea a asignar.\n");

        ArrayList<Tarea> tareaEncontrada = null;
        for(int i = 0; i < finca.getListaTareas().size(); i++ ){
            if (tareaSeleccionada == finca.getListaTareas().get(i).getNumTarea()){
                tareaEncontrada = finca.getListaTareas();
                break;
            }
        }
        boolean resultado = finca.asignarTareaAdmin(adminExistente, tareaEncontrada, cedulaAdmin);

        if(resultado){
            System.out.println("\nTarea asignada exitosamente\n");

        }else{
            System.out.println("\nNo es posible asignar la tarea - " +
                    "\n");
        }
    }
    //--------------------------------------------------------
    public static void listarEmpleados(Finca finca){
        ArrayList<Empleado> listaAdmins = finca.listarEmpleados();
        for(int i = 0; i < listaAdmins.size(); i++){
            System.out.println("Empleado #"+(i +1)+". "+listaAdmins.get(i)+"\n");
        }
    }
    public static void listarAdmins(Finca finca){
        ArrayList<Administrador> listaAdmins = finca.listarAdmin();
        for(int i = 0; i < listaAdmins.size(); i++){
            System.out.println("Administrador #"+(i +1)+". "+listaAdmins.get(i)+"\n");
        }
    }
    //-------------------------------------------------
    //CRUD Tarea
    public static void listarTareas(Finca finca){
        ArrayList<Tarea> listaTarea = finca.listarTareas();
        for(int i = 0; i < listaTarea.size(); i++){
            System.out.println("Tarea #"+(i +1)+". "+listaTarea.get(i)+"\n");
        }
    }
    public static void crearTarea(Finca finca){
        int numTarea = leerEntero("Ingrese id de la Tarea: ");
        LocalDate horaInicio = leerTiempo("Ingrese hora de inicio de la Tarea: ");
        LocalDate horaFinal = leerTiempo("Ingrese hora de cierre de la Tarea: ");
        long duracionTarea = leerLongConsola("Ingrese las horas que dura la Tarea: ");
        String descipcion = leerStringConsola("Ingrese la descripcion de la Tarea: ");

        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setNumTarea(numTarea);
        nuevaTarea.setHoraInicio(horaInicio);
        nuevaTarea.setHoraFinal(horaFinal);
        nuevaTarea.setDuraciontarea(duracionTarea);
        nuevaTarea.setDescripcion(descipcion);

        boolean resultado = finca.crearTarea(nuevaTarea);

        if(resultado){
            System.out.println("\nTarea creada exitosamente\n");

        }else{
            System.out.println("\nNo es posible crear la Tarea - " +
                    "El id de la Tarea ya existe en la base de datos\n");
        }
    }
    public static void editartarea(Finca finca){
        int idActual = leerEntero("Ingrese el id de la Tarea a Editar: ");

        Tarea TareaExistente = finca.obtenerTarea(idActual);
        if(TareaExistente == null){
            System.out.println("No se encontró Tarea con ID: " + idActual);
            return;
        }
        System.out.println("\nInformación actual del Recolector:");
        System.out.println(
                "ID: " + TareaExistente.getNumTarea()+'\n' +
                        "Hora de Inicio: " + TareaExistente.getHoraInicio()+'\n' +
                        "Hora de Cierre: " + TareaExistente.getHoraFinal()+'\n' +
                        "Duracion: " + TareaExistente.getDuraciontarea()+'\n' +
                        "Descripcion: " + TareaExistente.getDescripcion());

        System.out.println("\nIngrese los nuevos datos:");
        int numTarea = leerEntero("Ingrese id de la Tarea: ");
        LocalDate fechaInicio = leerTiempo("Ingrese hora de inicio de la Tarea: ");
        LocalDate fechaFinal = leerTiempo("Ingrese hora de cierre de la Tarea: ");
        long duracionTarea = leerLongConsola("Ingrese las horas que dura la Tarea: ");
        String descipcion = leerStringConsola("Ingrese la descripcion de la Tarea: ");

        Tarea tareaEditada = new Tarea();
        tareaEditada.setNumTarea(numTarea);
        tareaEditada.setHoraInicio(fechaInicio);
        tareaEditada.setHoraFinal(fechaFinal);
        tareaEditada.setDuraciontarea(duracionTarea);
        tareaEditada.setDescripcion(descipcion);

        boolean resultado = finca.editarTarea(tareaEditada, numTarea);
        if(resultado){
            System.out.println("\nTarea editada exitosamente\n");
        }else{
            System.out.println("\nNo es posible editar la Tarea - " +
                    "El id de la Tarea ya existe en la base de datos\n");

        }
    }
    public static void borrarTarea(Finca finca, int numTarea){
        boolean resultado = finca.borrarTarea(numTarea);
        if(resultado){
            System.out.println("\nTarea borrada exitosamente\n");
        }else{
            System.out.println("\nNo es posible borrar la Tarea - " +
                    "El id de la Tarea ya existe en la base de datos\n");

        }
    }
    public static Finca inicializarDatos(){
        Finca finca = new Finca("Finca UQ");

        Administrador administrador1 = new Administrador();
        administrador1.setNombre("Julian");
        administrador1.setApellido("Alvarez");
        administrador1.setCedula("1001");
        administrador1.setEdad(30);
        administrador1.setSalario(2000000);
        administrador1.setNumeroHorasTrabajo(8);
        administrador1.setListaTareaAsociadas(null);

        Jornalero jornalero1 = new Jornalero();
        jornalero1.setNombre("William");
        jornalero1.setApellido("Wallace");
        jornalero1.setCedula("1002");
        jornalero1.setEdad(40);
        jornalero1.setSalario(2000000);
        jornalero1.setNumeroHorasTrabajo(8);
        jornalero1.setListaTareaAsociadas(null);

        Jornalero jornalero2 = new Jornalero();
        jornalero2.setNombre("Alberto");
        jornalero2.setApellido("Sucullini");
        jornalero2.setCedula("1003");
        jornalero2.setEdad(44);
        jornalero2.setSalario(2000000);
        jornalero2.setNumeroHorasTrabajo(8);
        jornalero2.setListaTareaAsociadas(null);

        Tarea tarea1 = new Tarea();
        tarea1.setNumTarea(101);
        tarea1.setHoraInicio(LocalDate.of(2025,10,21));
        tarea1.setHoraFinal(LocalDate.of(2025,10,21));
        tarea1.setDuraciontarea(8);
        tarea1.setDescripcion("Recoger cafe");

        Tarea tarea2 = new Tarea();
        tarea2.setNumTarea(102);
        tarea2.setHoraInicio(LocalDate.of(2025,10,21));
        tarea2.setHoraFinal(LocalDate.of(2025,10,27));
        tarea2.setDuraciontarea(8);
        tarea2.setDescripcion("Sembrar maiz");

        Tarea tarea3 = new Tarea();
        tarea3.setNumTarea(103);
        tarea3.setHoraInicio(LocalDate.of(2025,10,21));
        tarea3.setHoraFinal(LocalDate.of(2025,10,21));
        tarea3.setDuraciontarea(8);
        tarea3.setDescripcion("Abonar plantas");

        Tarea tarea4 = new Tarea();
        tarea4.setNumTarea(104);
        tarea4.setHoraInicio(LocalDate.of(2025,10,21));
        tarea4.setHoraFinal(LocalDate.of(2025,10,21));
        tarea4.setDuraciontarea(8);
        tarea4.setDescripcion("Trabajo de contabilidad");

        Tarea tarea5 = new Tarea();
        tarea5.setNumTarea(105);
        tarea5.setHoraInicio(LocalDate.of(2025,10,21));
        tarea5.setHoraFinal(LocalDate.of(2025,10,21));
        tarea5.setDuraciontarea(8);
        tarea5.setDescripcion("Administrar Finansas");

        finca.getListaEmpleados().add(administrador1);
        finca.getListaEmpleados().add(jornalero1);
        finca.getListaEmpleados().add(jornalero2);
        finca.getListaTareas().add(tarea1);
        finca.getListaTareas().add(tarea2);
        finca.getListaTareas().add(tarea3);
        finca.getListaTareas().add(tarea4);
        finca.getListaTareas().add(tarea5);

        return finca;
    }
    public static void mostrarMenu(){
        System.out.println("1 - Menu Mostrar lista de Empleados y Tareas");
        System.out.println("2 - Administrar Tarea");
        System.out.println("3 - Asignar Tarea");
        System.out.println("4 - ");
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
    public static double leerDoubleConsola(String mensaje) {
        double dato=0;
        String captura="";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        dato=Double.parseDouble(captura);
        return dato;
    }
    private static LocalDate leerTiempo(String mensaje) {
        int dia = leerEntero("Ingrese dia:");
        int mes = leerEntero("Ingrese mes:");
        int year = leerEntero("Ingrese año:");

        LocalDate fecha = LocalDate.of(dia,mes,year);

        return fecha;
    }
    public static long leerLongConsola(String mensaje) {
        long dato=0;
        String captura="";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        dato=Long.parseLong(captura);
        return dato;
    }

}