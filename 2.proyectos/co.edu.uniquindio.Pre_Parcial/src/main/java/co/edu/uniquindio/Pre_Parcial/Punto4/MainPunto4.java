package co.edu.uniquindio.Pre_Parcial.Punto4;

import java.util.ArrayList;

public class MainPunto4 {
    public static void main(String[] args) {

        EmpleadoFijo empleadoFijo = new EmpleadoFijo("Juan", 1001, 1000);
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Pepe", 1002, 42, 20);
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(empleadoFijo);
        listaEmpleados.add(empleadoPorHoras);

        for(int i = 0; i < listaEmpleados.size(); i++){
            System.out.println("Empleado N."+(i +1)+". "+listaEmpleados.get(i));
            System.out.println("Salario Total: "+listaEmpleados.get(i).calcularSalario());
            System.out.println(" ");
        }
    }
}
