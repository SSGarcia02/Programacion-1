package demo_proyectofinal_fx.demoapp.utils;


import demo_proyectofinal_fx.demoapp.model.Estudiante;
import demo_proyectofinal_fx.demoapp.model.Externo;
import demo_proyectofinal_fx.demoapp.model.Gimnasio;
import demo_proyectofinal_fx.demoapp.model.TrabajadorUQ;

import java.util.Scanner;

public class DataUtil {


    public static String leerStringConsola(String mensaje) {
        String captura = "";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        return captura;
    }

    public static int leerEntero(String mensaje) {
        int dato = 0;
        String captura = "";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        dato = Integer.parseInt(captura);
        return dato;
    }
    public static Gimnasio inicializarDatos(){

        Gimnasio gimnasio = new Gimnasio("Gimnacio Uq");

        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Sebastian");
        estudiante1.setApellido("Garcia");
        estudiante1.setEdad(20);
        estudiante1.setTelefono("3167844799");
        estudiante1.setIdentificacion("1001");

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Sebastian");
        estudiante2.setApellido("Cortez");
        estudiante2.setEdad(20);
        estudiante2.setTelefono("3103010283");
        estudiante2.setIdentificacion("1002");

        Estudiante estudiante3 = new Estudiante();
        estudiante3.setNombre("Camilo");
        estudiante3.setApellido("Ortiz");
        estudiante3.setEdad(20);
        estudiante3.setTelefono("3004751613");
        estudiante3.setIdentificacion("1003");

        TrabajadorUQ trabajadorUQ1 = new TrabajadorUQ();
        trabajadorUQ1.setNombre("Franco");
        trabajadorUQ1.setApellido("Armani");
        trabajadorUQ1.setEdad(40);
        trabajadorUQ1.setTelefono("3100000000");
        trabajadorUQ1.setIdentificacion("1004");

        Externo externo1 = new Externo();
        externo1.setNombre("Romulo");
        externo1.setApellido("Remo");
        externo1.setEdad(35);
        externo1.setTelefono("31600000000");
        externo1.setIdentificacion("1005");

        gimnasio.getListaUsuarios().add(estudiante1);
        gimnasio.getListaUsuarios().add(estudiante2);
        gimnasio.getListaUsuarios().add(estudiante3);
        gimnasio.getListaUsuarios().add(trabajadorUQ1);
        gimnasio.getListaUsuarios().add(externo1);

        return gimnasio;
    }
}
