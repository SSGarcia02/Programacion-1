package co.edu.uniquindio.Pre_Parcial.punto2;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private int cedula;
    private int edad;
    private double salario;
    private int numeroHorasTrabajo;
    private Tarea tareaAsociacion;
    private Finca ownedBYFinca;

    public Empleado(){}
    public Empleado(String nombre, String apellido, int cedula, int edad, double salario, int numeroHorasTrabajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.salario = salario;
        this.numeroHorasTrabajo = numeroHorasTrabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getNumeroHorasTrabajo() {
        return numeroHorasTrabajo;
    }

    public void setNumeroHorasTrabajo(int numeroHorasTrabajo) {
        this.numeroHorasTrabajo = numeroHorasTrabajo;
    }

    public Tarea getTareaAsociacion() {
      return tareaAsociacion;

    }

    public void setTareaAsociacion(Tarea tarea) {
        this.tareaAsociacion = tarea;
    }

    @Override
    public String toString() {
        return '\n' +"Nombre: " + nombre + '\n' +
                "Apellido: " + apellido+'\n' +
                "Cedula: " + cedula+'\n' +
                "Edad: " + edad+'\n' +
                "Salario: " + salario+'\n' +
                "Numero de horas de trabajo: " + numeroHorasTrabajo+'\n'
                +"Tarea asignada: "+ (tareaAsociacion != null ? tareaAsociacion.getDescripcion() : "Ninguna");
    }
}
