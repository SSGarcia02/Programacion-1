package co.edu.uniquindio.Pre_Parcial.punto2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class mainPunto2 {
    public static void main(String[] args) {
        Finca finca = inicializarDatos();
        int opcionMenuPrincipal = 0;
        int opcionMenuCrearEmpleados = 0;
        int opcionMenuListarEmpleados = 0;
        int opcionMenuAsignarTarea = 0;
        do{
            System.out.println("=========== Menu Principal ============\n");
            mostrarMenu();
            opcionMenuPrincipal = leerEntero("=========== Ingrese la opcion del menu ============\n");
            switch (opcionMenuPrincipal){
                case 1:
                    System.out.println("=========== Menu de crear Empleado ============\n");
                    System.out.println("1. Crear Administrador");
                    System.out.println("2. Crear Jornalero");
                    System.out.println("3. Crear Recolector");
                    opcionMenuCrearEmpleados =
                            leerEntero("=========== Ingrese la opcio del tipo de empleado que desea crear ============\n");
                    switch(opcionMenuCrearEmpleados){
                        case 1:
                            crearAdmin(finca);
                            System.out.println("Informacion del Administrador :"+'\n' +finca);
                            break;
                        case 2:
                            crearJornalero(finca);
                            System.out.println("Informacion del Jornalero :"+'\n' +finca);
                            break;
                        case 3:
                            crearRecolector(finca);
                            System.out.println("Informacion del Recolector :"+'\n' +finca);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("=========== Menu de mostrar listas ============\n");
                    System.out.println("1. Ver listar de Administradores");
                    System.out.println("2. Ver listar de Jornaleros");
                    System.out.println("3. Ver listar de Recolectores");
                    System.out.println("4. Ver lista de todos los empleados");
                    System.out.println("5. Ver listar de Tareas");
                    opcionMenuListarEmpleados =
                            leerEntero("=========== Ingrese la opcio del tipo de lista que desea crear ============\n");
                    switch(opcionMenuListarEmpleados){
                        case 1:
                            System.out.println("Lista Administradores:"+'\n');
                            listarAdmins(finca);
                            break;
                        case 2:
                            System.out.println("Lista Jornaleros:"+'\n');
                            listarJornalero(finca);
                            break;
                        case 3:
                            System.out.println("Lista Recolectores:"+'\n');
                            listarRecolectores(finca);
                            break;
                        case 4:
                            System.out.println("=========== Lista de Empleados ============"+'\n');
                            System.out.println("\nAdministradores:"+'\n');
                            listarAdmins(finca);
                            System.out.println("\nLista Jornaleros:"+'\n');
                            listarJornalero(finca);
                            System.out.println("\nLista Recolectores:"+'\n');
                            listarRecolectores(finca);
                            break;
                        case 5:
                            System.out.println("Lista de Tareas:"+'\n');
                            listarTareas(finca);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("=========== Menu de Asignar tarea a Empleados ============\n");
                    System.out.println("1. Asignar tarea a Administrador");
                    System.out.println("2. Asignar tarea a Jornalero");
                    System.out.println("3. Asignar tarea a Recolector");
                    opcionMenuAsignarTarea = leerEntero("=========== Ingrese la opcio del menu ============\n ");
                    switch (opcionMenuAsignarTarea){
                        case 1:
                            asignarTareaAdmin(finca);
                            break;
                        case 2:
                            asignarTareaJornalero(finca);
                            break;
                        case 3:
                            asignarTareaRecolector(finca);
                            break;
                    }
                    break;
                case 4:

                    break;
            }
        }while(opcionMenuPrincipal != 8);
        System.out.println("Good Bye!");
    }
    public static void asignarTareaAdmin(Finca  finca){
        System.out.println("lista de Administradores:\n");
        listarAdmins(finca);
        int cedulaAdmin = leerEntero("Ingrese la cedula del Administrador a asignar tarea");

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

        Tarea tareaEncontrada = null;
        for(int i = 0; i < finca.getListaTareas().size(); i++ ){
            if (tareaSeleccionada == finca.getListaTareas().get(i).getNumTarea()){
               tareaEncontrada = finca.getListaTareas().get(i);
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
    public static void asignarTareaJornalero(Finca finca){
        System.out.println("lista de Jornaleros:\n");
        listarJornalero(finca);
        int cedulaJornalero = leerEntero("Ingrese la cedula del Jornalero a asignar tarea");

        Jornalero jornaleroExistente = finca.obtenerJornalero(cedulaJornalero);
        if(jornaleroExistente == null ){
            System.out.println("No se encontró Administradir con cédula: " + cedulaJornalero);
            return;
        }
        System.out.println("\nInformación del Administrador:");
        System.out.println(
                "Nombre: " + jornaleroExistente.getNombre() + '\n' +
                        "Apellido: " + jornaleroExistente.getApellido()+'\n' +
                        "Cedula: " + jornaleroExistente.getCedula()+'\n');
        System.out.println("Lista de tareas.\n");
        listarTareas(finca);
        int tareaSeleccionada = leerEntero("Seleccione el ID de la tarea a asignar.\n");

        Tarea tareaEncontrada = null;
        for(int i = 0; i < finca.getListaTareas().size(); i++ ){
            if (tareaSeleccionada == finca.getListaTareas().get(i).getNumTarea()){
                tareaEncontrada = finca.getListaTareas().get(i);
                break;
            }
        }
        boolean resultado = finca.asignarJornalero(jornaleroExistente, tareaEncontrada, cedulaJornalero);

        if(resultado){
            System.out.println("\nTarea asignada exitosamente\n");

        }else{
            System.out.println("\nNo es posible asignar la tarea - " +
                    "\n");
        }
    }
    public static void asignarTareaRecolector(Finca finca){
        System.out.println("lista de Recolectores:\n");
        listarJornalero(finca);
        int cedulaRecolector = leerEntero("Ingrese la cedula del Recolector a asignar tarea");

        Recolector recolectorExistente = finca.obtenerRecolector(cedulaRecolector);
        if(recolectorExistente == null ){
            System.out.println("No se encontró Recolector con cédula: " + cedulaRecolector);
            return;
        }
        System.out.println("\nInformación del Recolector:");
        System.out.println(
                "Nombre: " + recolectorExistente.getNombre() + '\n' +
                        "Apellido: " + recolectorExistente.getApellido()+'\n' +
                        "Cedula: " + recolectorExistente.getCedula()+'\n');
        System.out.println("Lista de tareas.\n");
        listarTareas(finca);
        int tareaSeleccionada = leerEntero("Seleccione el ID de la tarea a asignar.\n");

        Tarea tareaEncontrada = null;
        for(int i = 0; i < finca.getListaTareas().size(); i++ ){
            if (tareaSeleccionada == finca.getListaTareas().get(i).getNumTarea()){
                tareaEncontrada = finca.getListaTareas().get(i);
                break;
            }
        }
        boolean resultado = finca.asignarRecolector(recolectorExistente, tareaEncontrada, cedulaRecolector);

        if(resultado){
            System.out.println("\nTarea asignada exitosamente\n");

        }else{
            System.out.println("\nNo es posible asignar la tarea - " +
                    "\n");
        }
    }
    //CRUD Admin
    public static void listarAdmins(Finca finca){
        ArrayList<Administrador> listaAdmins = finca.listarAdmin();
        for(int i = 0; i < listaAdmins.size(); i++){
            System.out.println("Administrador #"+(i +1)+". "+listaAdmins.get(i)+"\n");
        }
    }
    public static void crearAdmin(Finca finca){
        String nombre = leerStringConsola("Ingrese nombre del Administrador: ");
        String apellido = leerStringConsola("Ingrese apellido del Administrador: ");
        int cedula = leerEntero("Ingrese cedula del Administrador: ");
        int edad = leerEntero("Ingrese edad del Administrador: ");
        double salario = leerDoubleConsola("Ingrese salario del Administrador: ");
        int numHorasTrabajo = leerEntero("Ingrese numero de horas de trabajo del Administrador: ");

        Administrador nuevoAdmin = new Administrador();
        nuevoAdmin.setNombre(nombre);
        nuevoAdmin.setApellido(apellido);
        nuevoAdmin.setCedula(cedula);
        nuevoAdmin.setEdad(edad);
        nuevoAdmin.setSalario(salario);
        nuevoAdmin.setNumeroHorasTrabajo(numHorasTrabajo);
        nuevoAdmin.setTareaAsociacion(null);

        boolean resultado = finca.crearAdmin(nuevoAdmin);

        if(resultado){
            System.out.println("\nAdministrador creado exitosamente\n");

        }else{
            System.out.println("\nNo es posible crear el Administrador - " +
                    "El numero de cedula del Administrador ya existe en la base de datos\n");
        }
    }
    public static void editarAdmin(Finca finca){
        int cedulaActual = leerEntero("Ingrese la cedula del Administrador a Editar: ");

        Administrador adminExistente = finca.obtenerAdmin(cedulaActual);
        if(adminExistente == null){
            System.out.println("No se encontró Administrador con cédula: " + cedulaActual);
            return;
        }
        System.out.println("\nInformación actual del Administrador:");
        System.out.println(
                "Nombre: " + adminExistente.getNombre() + '\n' +
                "Apellido: " + adminExistente.getApellido()+'\n' +
                "Cedula: " + adminExistente.getCedula()+'\n' +
                "Edad: " + adminExistente.getEdad()+'\n' +
                "Salario: " + adminExistente.getSalario()+'\n' +
                "Numero de horas de trabajo: " + adminExistente.getNumeroHorasTrabajo());

        System.out.println("\nIngrese los nuevos datos:");
        String nombre = leerStringConsola("Ingrese nombre del Administrador: ");
        String apellido = leerStringConsola("Ingrese apellido del Administrador: ");
        int cedula = leerEntero("Ingrese cedula del Administrador: ");
        int edad = leerEntero("Ingrese edad del Administrador: ");
        double salario = leerDoubleConsola("Ingrese salario del Administrador: ");
        int numHorasTrabajo = leerEntero("Ingrese numero de horas de trabajo del Administrador: ");

        Administrador adminEditado = new Administrador();
        adminEditado.setNombre(nombre);
        adminEditado.setApellido(apellido);
        adminEditado.setCedula(cedula);
        adminEditado.setEdad(edad);
        adminEditado.setSalario(salario);
        adminEditado.setNumeroHorasTrabajo(numHorasTrabajo);

        boolean resultado = finca.editarAdmin(adminEditado, cedula);
        if(resultado){
            System.out.println("\nAdministrador editado exitosamente\n");
        }else{
            System.out.println("\nNo es posible editar el Administrador - El numero de cedula del Administrador ya existe en la base de datos\n");

        }
    }
    public static void borrarAdmin(Finca finca, int cedula){
        boolean resultado = finca.borrarAdmin(cedula);
        if(resultado){
            System.out.println("\nAdministrador borradp exitosamente\n");
        }else{
            System.out.println("\nNo es posible editar el Administrador - El numero de cedula del Administrador ya existe en la base de datos\n");

        }

    }
    //----------------------------------------------
    //CRUD Jornalero
    public static void listarJornalero(Finca finca){
        ArrayList<Jornalero> listaJornaleros = finca.listarJornaleros();
        for(int i = 0; i < listaJornaleros.size(); i++){
            System.out.println("Jornalero #"+(i +1)+". "+listaJornaleros.get(i)+"\n");
        }
    }
    public static void crearJornalero(Finca finca){
        String nombre = leerStringConsola("Ingrese nombre del Jornalero: ");
        String apellido = leerStringConsola("Ingrese apellido del Jornalero: ");
        int cedula = leerEntero("Ingrese cedula del Jornalero: ");
        int edad = leerEntero("Ingrese edad del Jornalero: ");
        double salario = leerDoubleConsola("Ingrese salario del Jornalero: ");
        int numHorasTrabajo = leerEntero("Ingrese numero de horas de trabajo del Jornalero: ");

        Jornalero nuevoJornalero = new Jornalero();
        nuevoJornalero.setNombre(nombre);
        nuevoJornalero.setApellido(apellido);
        nuevoJornalero.setCedula(cedula);
        nuevoJornalero.setEdad(edad);
        nuevoJornalero.setSalario(salario);
        nuevoJornalero.setNumeroHorasTrabajo(numHorasTrabajo);

        boolean resultado = finca.crearJornalero(nuevoJornalero);

        if(resultado){
            System.out.println("\nJornalero creado exitosamente\n");

        }else{
            System.out.println("\nNo es posible crear el Jornalero - " +
                    "El numero de cedula del Jornalero ya existe en la base de datos\n");
        }
    }
    public static void editarJornalero(Finca finca){
        int cedulaActual = leerEntero("Ingrese la cedula del Jornalero a Editar: ");

        Jornalero jornaleroExistente = finca.obtenerJornalero(cedulaActual);
        if(jornaleroExistente == null){
            System.out.println("No se encontró jornalero con cédula: " + cedulaActual);
            return;
        }
        System.out.println("\nInformación actual del Jornalero:");
        System.out.println(
                "Nombre: " + jornaleroExistente.getNombre() + '\n' +
                        "Apellido: " + jornaleroExistente.getApellido()+'\n' +
                        "Cedula: " + jornaleroExistente.getCedula()+'\n' +
                        "Edad: " + jornaleroExistente.getEdad()+'\n' +
                        "Salario: " + jornaleroExistente.getSalario()+'\n' +
                        "Numero de horas de trabajo: " + jornaleroExistente.getNumeroHorasTrabajo());

        System.out.println("\nIngrese los nuevos datos:");
        String nombre = leerStringConsola("Ingrese nombre del Jornalero: ");
        String apellido = leerStringConsola("Ingrese apellido del Jornalero: ");
        int cedula = leerEntero("Ingrese cedula del Jornalero: ");
        int edad = leerEntero("Ingrese edad del Jornalero: ");
        double salario = leerDoubleConsola("Ingrese salario del Jornalero: ");
        int numHorasTrabajo = leerEntero("Ingrese numero de horas de trabajo del Jornalero: ");

        Jornalero jornaleroEditado = new Jornalero();
        jornaleroEditado.setNombre(nombre);
        jornaleroEditado.setApellido(apellido);
        jornaleroEditado.setCedula(cedula);
        jornaleroEditado.setEdad(edad);
        jornaleroEditado.setSalario(salario);
        jornaleroEditado.setNumeroHorasTrabajo(numHorasTrabajo);

        boolean resultado = finca.editarJornalero(jornaleroEditado, cedula);
        if(resultado){
            System.out.println("\nJornalero editado exitosamente\n");
        }else{
            System.out.println("\nNo es posible editar el Jornalero - El numero de cedula del Jornalero ya existe en la base de datos\n");

        }
    }
    public static void borrarJornalero(Finca finca, int cedula){
        boolean resultado = finca.borrarJornalero(cedula);
        if(resultado){
            System.out.println("\nJornalero borradp exitosamente\n");
        }else{
            System.out.println("\nNo es posible editar el Jornalero - El numero de cedula del Jornalero ya existe en la base de datos\n");

        }
    }
    //----------------------------------------------
    //CRUD Recolector
    public static void listarRecolectores(Finca finca){
        ArrayList<Recolector> listaRecolectores = finca.listarRecolectores();
        for(int i = 0; i < listaRecolectores.size(); i++){
            System.out.println("Recolector #"+(i +1)+". "+listaRecolectores.get(i)+"\n");
        }
    }
    public static void crearRecolector(Finca finca){
        String nombre = leerStringConsola("Ingrese nombre del Recolector: ");
        String apellido = leerStringConsola("Ingrese apellido del Recolector: ");
        int cedula = leerEntero("Ingrese cedula del Recolector: ");
        int edad = leerEntero("Ingrese edad del Recolector: ");
        double salario = leerDoubleConsola("Ingrese salario del Recolector: ");
        int numHorasTrabajo = leerEntero("Ingrese numero de horas de trabajo del Recolector: ");

        Recolector nuevoRecolector = new Recolector();
        nuevoRecolector.setNombre(nombre);
        nuevoRecolector.setApellido(apellido);
        nuevoRecolector.setCedula(cedula);
        nuevoRecolector.setEdad(edad);
        nuevoRecolector.setSalario(salario);
        nuevoRecolector.setNumeroHorasTrabajo(numHorasTrabajo);

        boolean resultado = finca.crearRecolector(nuevoRecolector);

        if(resultado){
            System.out.println("\nRecolector creado exitosamente\n");

        }else{
            System.out.println("\nNo es posible crear el Recolector - " +
                    "El numero de cedula del Recolector ya existe en la base de datos\n");
        }
    }
    public static void editarRecolector(Finca finca){
        int cedulaActual = leerEntero("Ingrese la cedula del Recolector a Editar: ");

        Recolector RecolectorExistente = finca.obtenerRecolector(cedulaActual);
        if(RecolectorExistente == null){
            System.out.println("No se encontró Recolector con cédula: " + cedulaActual);
            return;
        }
        System.out.println("\nInformación actual del Recolector:");
        System.out.println(
                "Nombre: " + RecolectorExistente.getNombre() + '\n' +
                        "Apellido: " + RecolectorExistente.getApellido()+'\n' +
                        "Cedula: " + RecolectorExistente.getCedula()+'\n' +
                        "Edad: " + RecolectorExistente.getEdad()+'\n' +
                        "Salario: " + RecolectorExistente.getSalario()+'\n' +
                        "Numero de horas de trabajo: " + RecolectorExistente.getNumeroHorasTrabajo());

        System.out.println("\nIngrese los nuevos datos:");
        String nombre = leerStringConsola("Ingrese nombre del Recolector: ");
        String apellido = leerStringConsola("Ingrese apellido del Recolector: ");
        int cedula = leerEntero("Ingrese cedula del Recolector: ");
        int edad = leerEntero("Ingrese edad del Recolector: ");
        double salario = leerDoubleConsola("Ingrese salario del Recolector: ");
        int numHorasTrabajo = leerEntero("Ingrese numero de horas de trabajo del Recolector: ");

        Recolector RecolectorEditado = new Recolector();
        RecolectorEditado.setNombre(nombre);
        RecolectorEditado.setApellido(apellido);
        RecolectorEditado.setCedula(cedula);
        RecolectorEditado.setEdad(edad);
        RecolectorEditado.setSalario(salario);
        RecolectorEditado.setNumeroHorasTrabajo(numHorasTrabajo);

        boolean resultado = finca.editarRecolector(RecolectorEditado, cedula);
        if(resultado){
            System.out.println("\nRecolector editado exitosamente\n");
        }else{
            System.out.println("\nNo es posible editar el Recolector - " +
                    "El numero de cedula del Recolector ya existe en la base de datos\n");

        }
    }
    public static void borrarRecolector(Finca finca, int cedula){
        boolean resultado = finca.borrarRecolector(cedula);
        if(resultado){
            System.out.println("\nRecolector borradp exitosamente\n");
        }else{
            System.out.println("\nNo es posible editar el Recolector - " +
                    "El numero de cedula del Recolector ya existe en la base de datos\n");

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
        LocalTime horaInicio = leerTiempo("Ingrese hora de inicio de la Tarea: ");
        LocalTime horaFinal = leerTiempo("Ingrese hora de cierre de la Tarea: ");
        double duracionTarea = leerDoubleConsola("Ingrese las horas que dura la Tarea: ");
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
        LocalTime horaInicio = leerTiempo("Ingrese hora de inicio de la Tarea: ");
        LocalTime horaFinal = leerTiempo("Ingrese hora de cierre de la Tarea: ");
        double duracionTarea = leerDoubleConsola("Ingrese las horas que dura la Tarea: ");
        String descipcion = leerStringConsola("Ingrese la descripcion de la Tarea: ");

        Tarea tareaEditada = new Tarea();
        tareaEditada.setNumTarea(numTarea);
        tareaEditada.setHoraInicio(horaInicio);
        tareaEditada.setHoraFinal(horaFinal);
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
    //-------------------------------------------------
    public static Finca inicializarDatos() {
        Finca finca = new Finca();

        Administrador administrador1 = new Administrador();
        administrador1.setNombre("Julian");
        administrador1.setApellido("Alvarez");
        administrador1.setCedula(1001);
        administrador1.setEdad(30);
        administrador1.setSalario(2000000);
        administrador1.setNumeroHorasTrabajo(8);
        administrador1.setTareaAsociacion(null);

        Administrador administrador2 = new Administrador();
        administrador2.setNombre("Franco");
        administrador2.setApellido("Armani");
        administrador2.setCedula(1005);
        administrador2.setEdad(48);
        administrador2.setSalario(2000000);
        administrador2.setNumeroHorasTrabajo(8);
        administrador2.setTareaAsociacion(null);

        Jornalero jornalero1 = new Jornalero();
        jornalero1.setNombre("William");
        jornalero1.setApellido("Wallace");
        jornalero1.setCedula(1002);
        jornalero1.setEdad(40);
        jornalero1.setSalario(2000000);
        jornalero1.setNumeroHorasTrabajo(8);


        Jornalero jornalero2 = new Jornalero();
        jornalero2.setNombre("Alberto");
        jornalero2.setApellido("Sucullini");
        jornalero2.setCedula(1003);
        jornalero2.setEdad(44);
        jornalero2.setSalario(2000000);
        jornalero2.setNumeroHorasTrabajo(8);

        Recolector recolector1 = new Recolector();
        recolector1.setNombre("Julio");
        recolector1.setApellido("Becaccece");
        recolector1.setCedula(1004);
        recolector1.setEdad(51);
        recolector1.setSalario(2000000);
        recolector1.setNumeroHorasTrabajo(8);

        Tarea tarea1 = new Tarea();
        tarea1.setNumTarea(01);
        tarea1.setHoraInicio(LocalTime.of(7,0));
        tarea1.setHoraFinal(LocalTime.of(17,0));
        tarea1.setDuraciontarea(8);
        tarea1.setDescripcion("Recoger cafe");

        Tarea tarea2 = new Tarea();
        tarea2.setNumTarea(02);
        tarea2.setHoraInicio(LocalTime.of(7,0));
        tarea2.setHoraFinal(LocalTime.of(17,0));
        tarea2.setDuraciontarea(8);
        tarea2.setDescripcion("Sembrar maiz");

        finca.getListaAdmis().add(administrador1);
        finca.getListaAdmis().add(administrador2);
        finca.getListaJornaleros().add(jornalero1);
        finca.getListaJornaleros().add(jornalero2);
        finca.getListaRecolectores().add(recolector1);
        finca.getListaTareas().add(tarea1);
        finca.getListaTareas().add(tarea2);

        return finca;
    }
    public static void mostrarMenu(){
        System.out.println("1 - Menu Crear Empleado");
        System.out.println("2 - Menu Mostrar lista de Empleados y Tareas");
        System.out.println("3 - Asignar Tarea");
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
    private static LocalTime leerTiempo(String mensaje) {
        int hora = leerEntero("Ingrese hora:");
        int minuto = leerEntero("Ingrese minuto:");

        LocalTime tiempo = LocalTime.of(hora,minuto);

        return tiempo;
    }

}
