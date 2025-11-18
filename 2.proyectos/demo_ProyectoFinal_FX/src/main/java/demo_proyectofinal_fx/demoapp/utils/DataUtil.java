package demo_proyectofinal_fx.demoapp.utils;

import demo_proyectofinal_fx.demoapp.model.*;

import java.time.LocalDate;
import java.time.LocalTime;
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
        Gimnasio gimnasio = new Gimnasio("Gimnasio UQ");

        Administrador admin = new Administrador(
                "admin",
                "Sistema",
                "10065",
                36,
                "3185658564",
                "1234",
                gimnasio
        );
        Recepcionista recepcionista = new Recepcionista(
                "recepcion",
                "Recepcion",
                "10066",
                28,
                "3185658565",
                "1234"
        );
        gimnasio.getListaUsuariosSistema().add(admin);
        gimnasio.getListaUsuariosSistema().add(recepcionista);
        gimnasio.setAdministrador(admin);


        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Sebastian");
        estudiante1.setApellido("Garcia");
        estudiante1.setEdad(20);
        estudiante1.setTelefono("3167844799");
        estudiante1.setIdentificacion("1001");
        estudiante1.setTipo("Estudiante");

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Sebastian");
        estudiante2.setApellido("Cortez");
        estudiante2.setEdad(20);
        estudiante2.setTelefono("3103010283");
        estudiante2.setIdentificacion("1002");
        estudiante2.setTipo("Estudiante");


        Estudiante estudiante3 = new Estudiante();
        estudiante3.setNombre("Camilo");
        estudiante3.setApellido("Ortiz");
        estudiante3.setEdad(20);
        estudiante3.setTelefono("3004751613");
        estudiante3.setIdentificacion("1003");
        estudiante3.setTipo("Estudiante");

        TrabajadorUQ trabajadorUQ1 = new TrabajadorUQ();
        trabajadorUQ1.setNombre("Franco");
        trabajadorUQ1.setApellido("Armani");
        trabajadorUQ1.setEdad(40);
        trabajadorUQ1.setTelefono("3100000000");
        trabajadorUQ1.setIdentificacion("1004");
        trabajadorUQ1.setTipo("Trabajador");

        Externo externo1 = new Externo();
        externo1.setNombre("Romulo");
        externo1.setApellido("Remo");
        externo1.setEdad(35);
        externo1.setTelefono("31600000000");
        externo1.setIdentificacion("1005");
        externo1.setTipo("Externo");

        Estudiante estudiante4 = new Estudiante();
        estudiante4.setNombre("Laura");
        estudiante4.setApellido("Martinez");
        estudiante4.setEdad(22);
        estudiante4.setTelefono("3151234567");
        estudiante4.setIdentificacion("1008");
        estudiante4.setTipo("Estudiante");

        TrabajadorUQ trabajadorUQ2 = new TrabajadorUQ();
        trabajadorUQ2.setNombre("Carlos");
        trabajadorUQ2.setApellido("Rodriguez");
        trabajadorUQ2.setEdad(45);
        trabajadorUQ2.setTelefono("3177654321");
        trabajadorUQ2.setIdentificacion("1009");
        trabajadorUQ2.setTipo("Trabajador");

        Externo externo2 = new Externo();
        externo2.setNombre("Ana");
        externo2.setApellido("Gomez");
        externo2.setEdad(28);
        externo2.setTelefono("3185554444");
        externo2.setIdentificacion("1010");
        externo2.setTipo("Externo");

        Entrenador entrenador1 = new Entrenador();
        entrenador1.setNombre("Alejandro");
        entrenador1.setApellido("Garces");
        entrenador1.setEdad(30);
        entrenador1.setTelefono("3167844799");
        entrenador1.setIdentificacion("1006");

        Entrenador entrenador2 = new Entrenador();
        entrenador2.setNombre("Rubiel");
        entrenador2.setApellido("Ramirez");
        entrenador2.setEdad(40);
        entrenador2.setTelefono("3103010283");
        entrenador2.setIdentificacion("1007");

        Clase yoga = new Clase("Yoga Mañana", TipoClases.YOGA, LocalTime.of(8, 0), 20);
        Clase rumba = new Clase("Rumba", TipoClases.RUMBA, LocalTime.of(18, 0), 25);
        Clase spinning = new Clase("Spinning Nocturno", TipoClases.SPINNING, LocalTime.of(20, 0), 15);
        Clase yogaTarde = new Clase("Yoga Tarde", TipoClases.YOGA, LocalTime.of(16, 0), 20);
        Clase spinningAvanzado = new Clase("Spinning Avanzado", TipoClases.SPINNING, LocalTime.of(19, 0), 10);
        Clase pilates = new Clase("Pilates", TipoClases.YOGA, LocalTime.of(10, 0), 15);
        Clase zumba = new Clase("Zumba", TipoClases.RUMBA, LocalTime.of(17, 0), 30);

        yoga.setEntrenadorAsignado(entrenador1);
        rumba.setEntrenadorAsignado(entrenador2);
        spinning.setEntrenadorAsignado(entrenador1);
        yogaTarde.setEntrenadorAsignado(entrenador2);
        spinningAvanzado.setEntrenadorAsignado(entrenador1);
        pilates.setEntrenadorAsignado(entrenador1);
        zumba.setEntrenadorAsignado(entrenador2);

        gimnasio.getListaClases().add(yoga);
        gimnasio.getListaClases().add(rumba);
        gimnasio.getListaClases().add(spinning);
        gimnasio.getListaClases().add(yogaTarde);
        gimnasio.getListaClases().add(spinningAvanzado);
        gimnasio.getListaClases().add(pilates);
        gimnasio.getListaClases().add(zumba);

        LocalDate hoy = LocalDate.now();

        MembresiaBasica membresiaVencida1 = new MembresiaBasica(50000, hoy.minusDays(30), hoy.minusDays(5));
        membresiaVencida1.setEstado(true);
        membresiaVencida1.setPeriodoMembresia(PeriodoMembresia.MENSUAL);

        MembresiaPremium membresiaVencida2 = new MembresiaPremium(70000, hoy.minusDays(60), hoy.minusDays(15));
        membresiaVencida2.setEstado(true);
        membresiaVencida2.setPeriodoMembresia(PeriodoMembresia.MENSUAL);

        MembresiaVIP membresiaPorVencer1 = new MembresiaVIP(100000, hoy.minusDays(27), hoy.plusDays(3));
        membresiaPorVencer1.setEstado(true);
        membresiaPorVencer1.setPeriodoMembresia(PeriodoMembresia.MENSUAL);

        MembresiaBasica membresiaPorVencer2 = new MembresiaBasica(50000, hoy.minusDays(27), hoy.plusDays(3));
        membresiaPorVencer2.setEstado(true);
        membresiaPorVencer2.setPeriodoMembresia(PeriodoMembresia.MENSUAL);

        MembresiaPremium membresiaPorVencer15dias1 = new MembresiaPremium(180000, hoy.minusDays(75), hoy.plusDays(15));
        membresiaPorVencer15dias1.setEstado(true);
        membresiaPorVencer15dias1.setPeriodoMembresia(PeriodoMembresia.TRIMESTRAL);

        MembresiaVIP membresiaPorVencer15dias2 = new MembresiaVIP(270000, hoy.minusDays(75), hoy.plusDays(15));
        membresiaPorVencer15dias2.setEstado(true);
        membresiaPorVencer15dias2.setPeriodoMembresia(PeriodoMembresia.TRIMESTRAL);

        MembresiaBasica membresiaLejana1 = new MembresiaBasica(130000, hoy.minusDays(60), hoy.plusDays(45));
        membresiaLejana1.setEstado(true);
        membresiaLejana1.setPeriodoMembresia(PeriodoMembresia.TRIMESTRAL);

        MembresiaPremium membresiaLejana2 = new MembresiaPremium(180000, hoy.minusDays(60), hoy.plusDays(60));
        membresiaLejana2.setEstado(true);
        membresiaLejana2.setPeriodoMembresia(PeriodoMembresia.TRIMESTRAL);
        estudiante1.setMembresia(membresiaVencida1);
        estudiante2.setMembresia(membresiaVencida2);
        estudiante3.setMembresia(membresiaPorVencer1);
        trabajadorUQ1.setMembresia(membresiaPorVencer2);
        externo1.setMembresia(membresiaPorVencer15dias1);
        estudiante4.setMembresia(membresiaPorVencer15dias2);
        trabajadorUQ2.setMembresia(membresiaLejana1);
        estudiante1.setClase(yoga);
        estudiante2.setClase(rumba);
        estudiante3.setClase(spinning);
        trabajadorUQ1.setClase(yogaTarde);
        externo1.setClase(spinning);
        estudiante4.setClase(rumba);
        trabajadorUQ2.setClase(spinningAvanzado);
        estudiante1.setClase(pilates);
        estudiante3.setClase(zumba);
        for (int i = 11; i <= 15; i++) {
            Estudiante estudianteExtra = new Estudiante();
            estudianteExtra.setNombre("Estudiante" + i);
            estudianteExtra.setApellido("Apellido" + i);
            estudianteExtra.setEdad(20 + (i % 5));
            estudianteExtra.setTelefono("311111111" + i);
            estudianteExtra.setIdentificacion("101" + i);
            estudianteExtra.setTipo("Estudiante");

            if (i % 3 == 0) {
                MembresiaBasica membresia = new MembresiaBasica(50000, hoy.minusDays(20), hoy.plusDays(10 + i));
                membresia.setEstado(true);
                membresia.setPeriodoMembresia(PeriodoMembresia.MENSUAL);
                estudianteExtra.setMembresia(membresia);
            } else if (i % 3 == 1) {
                MembresiaPremium membresia = new MembresiaPremium(70000, hoy.minusDays(40), hoy.plusDays(20 + i));
                membresia.setEstado(true);
                membresia.setPeriodoMembresia(PeriodoMembresia.MENSUAL);
                estudianteExtra.setMembresia(membresia);
            }
            if (i % 2 == 0) {
                estudianteExtra.setClase(spinning);
            } else if (i % 3 == 0) {
                estudianteExtra.setClase(rumba);
            } else {
                estudianteExtra.setClase(yoga);
            }

            gimnasio.getListaUsuarios().add(estudianteExtra);
        }

        gimnasio.getListaUsuarios().add(estudiante1);
        gimnasio.getListaUsuarios().add(estudiante2);
        gimnasio.getListaUsuarios().add(estudiante3);
        gimnasio.getListaUsuarios().add(trabajadorUQ1);
        gimnasio.getListaUsuarios().add(externo1);
        gimnasio.getListaUsuarios().add(estudiante4);
        gimnasio.getListaUsuarios().add(trabajadorUQ2);
        gimnasio.getListaUsuarios().add(externo2);
        gimnasio.getListaEntrenadores().add(entrenador1);
        gimnasio.getListaEntrenadores().add(entrenador2);

        entrenador1.agregarClase("Yoga Mañana");
        entrenador1.agregarClase("Spinning Nocturno");
        entrenador1.agregarClase("Spinning Avanzado");
        entrenador1.agregarClase("Pilates");
        entrenador2.agregarClase("Rumba");
        entrenador2.agregarClase("Yoga Tarde");
        entrenador2.agregarClase("Zumba");

        System.out.println("✅ Datos de prueba MEJORADOS inicializados correctamente:");
        System.out.println("   - 13 usuarios creados ");
        System.out.println("   - 7 clases diferentes");
        System.out.println("   - 2 entrenadores");

        return gimnasio;
    }
}