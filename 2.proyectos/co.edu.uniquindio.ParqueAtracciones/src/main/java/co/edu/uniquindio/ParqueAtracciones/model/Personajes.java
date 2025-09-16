package co.edu.uniquindio.ParqueAtracciones.model;

import java.security.PrivateKey;

public class Personajes {
    private String nombre;
    private String descripcion;

    public Personajes(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
