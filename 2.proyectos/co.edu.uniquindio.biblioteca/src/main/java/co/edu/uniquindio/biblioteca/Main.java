package co.edu.uniquindio.biblioteca;
import co.edu.uniquindio.biblioteca.model.Biblioteca;
import co.edu.uniquindio.biblioteca.model.Cliente;
import co.edu.uniquindio.biblioteca.model.Empleado;
import co.edu.uniquindio.biblioteca.model.Libro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = inicializarDatos();
        int opcion = 0;
        do {
            mostrarMenu();
            opcion=leerEntero("Ingrese la opción del menu");
            switch (opcion) {
                case 1:
                    String resultadoCliente = crearCliente(biblioteca);
                    System.out.println("Informacion del Cliente: "+resultadoCliente);
                    break;
                case 2:
                    Cliente cliente = obtenerCliente(biblioteca);
                    int edad = leerEntero("Ingrese edad del cliente a validar");
                    String resultadoValidacionCliente = validarCLiente(cliente, edad);
                    System.out.println("Resultado: "+ resultadoValidacionCliente);
                    break;
                case 3:
                    String resultadoEmpleado = crearEmpleado(biblioteca);
                    System.out.println("Informacion del Empleado: "+resultadoEmpleado);
                    break;
                case 4:
                    String resultadoLibro = crearLibro(biblioteca);
                    System.out.println("Informacion del Libro: "+resultadoLibro);
                    break;
                case 5:
                    Libro libro = obtenerLibro(biblioteca);
                    String nombreLibro = leerStringConsola("Ingrese nombre del libro a validar");
                    String resultadoValidacionLibro = validarLibro(libro, nombreLibro);
                    System.out.println("Resultado: "+resultadoValidacionLibro);
                    break;

            }
        }while(opcion!=6);
    }

    public static String crearCliente(Biblioteca biblioteca){
        //Capturar datos del cliente
        String nombre = leerStringConsola("Ingrese nombre del CLiente: ");
        String apellido = leerStringConsola("Ingrese apellido del CLiente: ");
        String cedula = leerStringConsola("Ingrese cedula del CLiente: ");
        int edad = leerEntero("Ingrese edad del CLiente: ");
        String telefono = leerStringConsola("Ingrese telefono del CLiente: ");

        //Crear instancia del cliente
        Cliente cliente = new Cliente();
        //Agregar los datos capturados
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCedula(cedula);
        cliente.setEdad(edad);
        cliente.setTelefono(telefono);
        biblioteca.getListaClientes().add(cliente);

        return cliente.toString();
    }
    private static Cliente obtenerCliente(Biblioteca biblioteca){
        String idCliente = leerStringConsola("Ingrese cedula del cliente");
        Cliente clienteEncontrado = null;
        for(int i = 0; i<biblioteca.getListaClientes().size(); i++){
            if(biblioteca.getListaClientes().get(i).getCedula().equals(idCliente)){
                clienteEncontrado = biblioteca.getListaClientes().get(i);
                break;
            }
        }
        return clienteEncontrado;
    }
    private static String validarCLiente(Cliente cliente, int edad){
        if(cliente != null){
            if(cliente.getEdad() == edad){
                return "La edad del cliente es valida";
            }else{
                return "La edad del cliente no es valida";
            }
        }else{
            return "No se puede validar, el cliente no existe";
        }
    }
    public static String crearEmpleado(Biblioteca  biblioteca){
        String nombre = leerStringConsola("Ingrese nombre del Empleado: ");
        String apellido = leerStringConsola("Ingrese apellido del Empleado: ");
        String cedula = leerStringConsola("Ingrese cedula del Empleado: ");
        int edad = leerEntero("Ingrese edad del Empleado: ");
        String cargo = leerStringConsola("Ingrese cargo del Empleado: ");

        Empleado empleado = new Empleado();

        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setCedula(cedula);
        empleado.setEdad(edad);
        empleado.setCargo(cargo);

        biblioteca.getListaEmpleados().add(empleado);

        return empleado.toString();
    }

    public static String crearLibro(Biblioteca biblioteca){
        String nombre = leerStringConsola("Ingrese nombre del Libroo: ");
        String autor = leerStringConsola("Ingrese autor del Libro: ");
        String editorial = leerStringConsola("Ingrese editorial del Libro: ");
        int yearPublicacion = leerEntero("Ingrese año de publicacion del Libro: ");
        int libroId = leerEntero("Ingrese codigo del Libro: ");

        Libro libro = new Libro();

        libro.setNombre(nombre);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setYearPublicacion(yearPublicacion);
        libro.setLibroId(libroId);

        biblioteca.getListaLibros().add(libro);

        return libro.toString();
    }
    private static Libro obtenerLibro(Biblioteca biblioteca) {
        int idLibro = leerEntero("Ingrese id del libro: ");
        Libro libroEncontrado = null;
        for(int i = 0; i<biblioteca.getListaLibros().size(); i++){
            if(biblioteca.getListaLibros().get(i).getLibroId() == idLibro){
                libroEncontrado = biblioteca.getListaLibros().get(i);
                break;
            }
        }
        return libroEncontrado;
    }
    private static String validarLibro(Libro libro, String nombreLibro) {
        if(libro != null){
            if(libro.getNombre().equals(nombreLibro.toLowerCase())){
                return "El libro esta disponible";
            }
        }
        return "No se puede validar, el libro no existe";
    }
    public static Biblioteca inicializarDatos(){
        //Crear la biblioteca
        Biblioteca biblioteca = new Biblioteca("UQ");
        //Crear el cliente
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan");
        cliente1.setApellido("Garcia");
        cliente1.setCedula("1094");
        cliente1.setEdad(20);
        cliente1.setTelefono("316587");

        biblioteca.getListaClientes().add(cliente1);

        //Crear Libro
        Libro libro1 = new Libro();
        libro1.setNombre("1984");
        libro1.setAutor("George Oswell");
        libro1.setYearPublicacion(1949);
        libro1.setEditorial("xxxx");
        libro1.setLibroId(1111);

        Libro libro2 = new Libro();
        libro2.setNombre("animal farm");
        libro2.setAutor("George Oswell");
        libro2.setYearPublicacion(1945);
        libro2.setEditorial("xxxx");
        libro2.setLibroId(1112);

        biblioteca.getListaLibros().add(libro1);
        biblioteca.getListaLibros().add(libro2);
        return biblioteca;
    }
    public static String validarEdadCliente(){
        int edad = leerEntero("Ingrese la edad del Cliente:" );
        String mensaje;
        if(edad >= 18){
            mensaje = "El cliente es mayor de edad";
        }else{
            mensaje = "El cliente es menor de edad";
        }
        return mensaje;
    }
    public static void mostrarMenu() {
        System.out.println("1 - Crear Cliente");
        System.out.println("2 - Validar edad del cliente");
        System.out.println("3 - Crear Empleado");
        System.out.println("4 - Crear Libro");
        System.out.println("5 - Validar nombre de un libro");
        System.out.println("6 - Salir");
    }
    private static int leerEntero(String mensaje){
        int dato = 0;
        String captura = "";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        dato = Integer.parseInt(captura);
        return dato;
    }
    public static String leerStringConsola(String mensaje) {
        String captura="";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        return captura;
    }

}