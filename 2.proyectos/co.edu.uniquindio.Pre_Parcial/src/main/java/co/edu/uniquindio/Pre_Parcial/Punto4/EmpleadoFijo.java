package co.edu.uniquindio.Pre_Parcial.Punto4;

public class EmpleadoFijo extends Empleado{
    private double salarioBase;

    public EmpleadoFijo() {
    }
    public EmpleadoFijo(String nombre, int ID,double salarioBase) {
        super(nombre, ID);
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularSalario() {
        return salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return "\nNombre: "+getNombre()+"\nID: "+getID()+"\nsalarioBase: " + salarioBase;
    }
}

