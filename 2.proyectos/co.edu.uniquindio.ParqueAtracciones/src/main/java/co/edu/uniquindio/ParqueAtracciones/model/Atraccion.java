package co.edu.uniquindio.ParqueAtracciones.model;

public class Atraccion {
    private String nombre;
    private String horario;
    private String descripcion;
    private int rangoEdad;
    private String nivelPeligro;
    private int pesoMaximo;

    public Atraccion(String nombre, String horario, String descripcion,
                     int rangoEdad, String nivelPeligro, int pesoMaximo) {
        this.nombre = nombre;
        this.horario = horario;
        this.descripcion = descripcion;
        this.rangoEdad = rangoEdad;
        this.nivelPeligro = nivelPeligro;
        this.pesoMaximo = pesoMaximo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(int rangoEdad) {
        this.rangoEdad = rangoEdad;
    }

    public String getNivelPeligro() {
        return nivelPeligro;
    }

    public void setNivelPeligro(String nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
}
