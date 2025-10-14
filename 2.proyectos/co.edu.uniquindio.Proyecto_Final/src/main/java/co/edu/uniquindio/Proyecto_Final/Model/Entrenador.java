package co.edu.uniquindio.Proyecto_Final.Model;

public class Entrenador {
    private int identificacion;
    private String nombre;

    public Entrenador(){}
    public Entrenador(int identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "identificacion=" + identificacion +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
