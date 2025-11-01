package co.edu.uniquindio.Parcial2.Model;

public class Jornalero extends Empleado{

    public Jornalero(){}
    public Jornalero(String nombre, String apellido, String cedula,
                     int edad, double salario, int numeroHorasTrabajo,
                     Finca ownedBYFincas) {
        super(nombre, apellido, cedula, edad, salario,
                numeroHorasTrabajo, ownedBYFincas);
    }
}
