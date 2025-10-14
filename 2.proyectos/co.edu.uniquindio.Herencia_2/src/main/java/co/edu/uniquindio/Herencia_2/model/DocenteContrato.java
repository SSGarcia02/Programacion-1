package co.edu.uniquindio.Herencia_2.model;

public class DocenteContrato extends Docente{
    private Categoria categoria;

    public DocenteContrato( ) {}
    public DocenteContrato(int cedula, String nombre, Categoria categoria) {
        super(cedula, nombre);
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
