package co.edu.uniquindio.Herencia_1.model;

public class EstudiantePosgrado extends Estudiante{
    private String fechaGraduacion;

    public EstudiantePosgrado(){}
    public EstudiantePosgrado(String fechaGraduacion, int cedula, String nombre){
        super(cedula, nombre);
        this.fechaGraduacion = fechaGraduacion;
    }

    public String getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(String fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

}
