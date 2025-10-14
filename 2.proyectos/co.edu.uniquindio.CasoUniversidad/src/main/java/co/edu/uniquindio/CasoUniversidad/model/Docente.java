package co.edu.uniquindio.CasoUniversidad.model;

import java.util.ArrayList;

public class Docente {
    private String nombre;
    private int edad;
    private String Correo;
    private Universidad ownedByUniversidad;

    public Docente(){}
    public Docente(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        Correo = correo;
    }
    public double obtenerExponente(int edad, int semestre){
        double resutlado = edad;
        return resutlado;
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
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String correo) {
        Correo = correo;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", Correo='" + Correo + '\'' +
                '}';
    }
}
