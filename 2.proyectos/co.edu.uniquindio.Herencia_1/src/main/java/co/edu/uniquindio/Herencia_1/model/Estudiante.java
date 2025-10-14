package co.edu.uniquindio.Herencia_1.model;

public class Estudiante {
    private int cedula;
    private String nombre;

    public Estudiante(){}

    public Estudiante(int cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
