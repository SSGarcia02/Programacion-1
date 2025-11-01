package co.edu.uniquindio.Pre_Parcial.Punto4;

import java.util.ArrayList;

public abstract class Empleado {
    private String nombre;
    private int ID;
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    public Empleado(){}
    public Empleado(String nombre, int ID) {
        this.nombre = nombre;
        this.ID = ID;
    }

    public abstract double calcularSalario();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + '\n' +
                "ID: " + ID +'\n';
    }
}
