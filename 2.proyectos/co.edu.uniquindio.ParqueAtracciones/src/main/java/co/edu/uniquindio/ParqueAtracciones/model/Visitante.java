package co.edu.uniquindio.ParqueAtracciones.model;

public class Visitante {
    private String nombre;
    private String apellido;
    private int edad;
    private String id;
    private String sexo;
    private int peso;

    public Visitante(){}

    public Visitante(String nombre, String apellido, int edad, String id, String sexo, int peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.id = id;
        this.sexo = sexo;
        this.peso = peso;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
