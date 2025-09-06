package co.edu.uniquindio.biblioteca.model;

public class Prestamo {
    private String numPrestamo;
    private String fechaPrestamo;
    private String fechaEntrega;
    private String descripcion;

    public Prestamo(String numPrestamo, String fechaPrestamo, String fechaEntrega, String descripcion) {
        this.numPrestamo = numPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.descripcion = descripcion;
    }

    public String getNumPrestamo() {
        return numPrestamo;
    }

    public void setNumPrestamo(String numPrestamo) {
        this.numPrestamo = numPrestamo;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
