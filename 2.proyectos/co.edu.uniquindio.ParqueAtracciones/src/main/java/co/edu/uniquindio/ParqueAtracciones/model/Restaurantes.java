package co.edu.uniquindio.ParqueAtracciones.model;

import java.util.ArrayList;

public class Restaurantes {
    private String nombre;
    private int numeroComensales;
    private int numeroRestaurante;
    private ArrayList<String> menu = new ArrayList<>();

    public Restaurantes(){}
    public Restaurantes(String nombre, int numeroComensales, int numeroRestaurante, ArrayList<String> menu) {
        this.nombre = nombre;
        this.numeroComensales = numeroComensales;
        this.numeroRestaurante = numeroRestaurante;
        this.menu = menu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroComensales() {
        return numeroComensales;
    }

    public void setNumeroComensales(int numeroComensales) {
        this.numeroComensales = numeroComensales;
    }

    public int getNumeroRestaurante() {
        return numeroRestaurante;
    }

    public void setNumeroRestaurante(int numeroRestaurante) {
        this.numeroRestaurante = numeroRestaurante;
    }

    public ArrayList<String> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<String> menu) {
        this.menu = menu;
    }
}
