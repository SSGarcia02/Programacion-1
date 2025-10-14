package co.edu.uniquindio.Proyecto_Final.Model;

public abstract class Usuario {
    private int identificacion;
    private String nombre;
    private int edad;
    private String telefono;

    public Usuario(){}
    public Usuario(int identificacion, String nombre, int edad, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
