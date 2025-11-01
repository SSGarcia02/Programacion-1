package co.edu.uniquindio.Parcial2.Model;

public class Recolector extends Empleado{
    public Recolector(){}
    public Recolector(String nombre, String apellido, String cedula,
                      int edad, double salario, int numeroHorasTrabajo,
                      Finca ownedBYFinca) {
        super(nombre, apellido, cedula, edad, salario,
                numeroHorasTrabajo, ownedBYFinca);
    }
}
