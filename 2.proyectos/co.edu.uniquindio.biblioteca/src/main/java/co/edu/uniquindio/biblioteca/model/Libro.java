package co.edu.uniquindio.biblioteca.model;

public class Libro {
    private String nombre;
    private String autor;
    private String editorial;
    private int yearPublicacion;
    private int libroId;

    public Libro(){

    }
    public Libro(String nombre, String autor, String editorial,
                 int yearPublicacion, int libroId) {
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.yearPublicacion = yearPublicacion;
        this.libroId = libroId;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public int getYearPublicacion() {
        return yearPublicacion;
    }
    public void setYearPublicacion(int yearPublicacion) {
        this.yearPublicacion = yearPublicacion;
    }
    public int getLibroId() {
        return libroId;
    }
    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", yearPublicacion=" + yearPublicacion +
                ", libroId=" + libroId +
                '}';
    }
}
