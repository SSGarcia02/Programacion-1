package co.edu.uniquindio.Parcial2.Model;

public class Administrador extends Empleado{

    public Administrador(){}
    public Administrador(String nombre, String apellido,
                         String cedula, int edad, double salario,
                         int numeroHorasTrabajo, Finca ownedBYFinca) {
        super(nombre, apellido, cedula, edad, salario,
                numeroHorasTrabajo, ownedBYFinca);
    }
}
