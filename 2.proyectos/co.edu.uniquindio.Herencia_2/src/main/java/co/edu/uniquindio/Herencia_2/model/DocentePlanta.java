package co.edu.uniquindio.Herencia_2.model;

public class DocentePlanta extends Docente{
    private int cantidadPuntos;

    public DocentePlanta(){}
    public DocentePlanta(int cedula, String nombre, int cantidadPuntos) {
        super(cedula, nombre);
        this.cantidadPuntos = cantidadPuntos;
    }

    public int getCantidadPuntos() {
        return cantidadPuntos;
    }

    public void setCantidadPuntos(int cantidadPuntos) {
        this.cantidadPuntos = cantidadPuntos;
    }
}
