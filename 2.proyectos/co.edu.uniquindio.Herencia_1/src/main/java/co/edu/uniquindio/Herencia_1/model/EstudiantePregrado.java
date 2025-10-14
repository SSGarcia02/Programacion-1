package co.edu.uniquindio.Herencia_1.model;

public class EstudiantePregrado extends Estudiante{
    private int puntajeIngreso;

    public EstudiantePregrado(){}
    public EstudiantePregrado(int puntajeIngreso,int cedula, String nombre){
        super(cedula, nombre);
        this.puntajeIngreso = puntajeIngreso;
    }

    public int getPuntajeIngreso() {
        return puntajeIngreso;
    }

    public void setPuntajeIngreso(int puntajeIngreso) {
        this.puntajeIngreso = puntajeIngreso;
    }
}
