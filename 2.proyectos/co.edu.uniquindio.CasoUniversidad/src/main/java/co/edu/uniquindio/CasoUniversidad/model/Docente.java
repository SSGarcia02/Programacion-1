package co.edu.uniquindio.CasoUniversidad.model;

import javax.print.Doc;

public class Docente {
    private String nombre;
    private int edad;
    private String Correo;

    public Docente(){}
    public Docente(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        Correo = correo;
    }
    public double calcularDefinitivaEstudiante(double nota1, double nota2, double nota3){
        double notaDefinitiva = (nota1 + nota2 + nota3)/3;
        return notaDefinitiva;
    }
    public double calcularPromedioCurso(double Estudiante1Definitiva,
                                     double Estudiante2Definitiva,
                                     double Estudiante3Definitiva){
        double promedioCurso = (Estudiante1Definitiva + Estudiante2Definitiva + Estudiante3Definitiva)/3;
        return promedioCurso;
    }
    public double calcularPromedioEdad(double Estudiante1Edad,
                                    double Estudiante2Edad,
                                    double Estudiante3Edad){
        double promedioEdad = (Estudiante1Edad + Estudiante2Edad + Estudiante3Edad)/3;
        return promedioEdad;
    }
    public double calcularPromedioNota1(double Estudiante1nota1,
                                     double Estudiante2nota1,
                                     double Estudiante3nota1){
        double promedioNota1 = (Estudiante1nota1+Estudiante2nota1+Estudiante3nota1)/3;
        return promedioNota1;
    }
    public double calcularNotaMayorDelCurso(Curso curso){
        double NotaMayorEstudiante = 0;
        double notaMayorCurso = 0;
        for(int i = 0; i<curso.getListaEstudiantes().size(); i++){
            Estudiante estudiante = curso.getListaEstudiantes().get(i); //<<<<<<<<<<<<<<<<<<<
            NotaMayorEstudiante = Math.max(estudiante.getNota1(),
                    Math.max(estudiante.getNota2(),estudiante.getNota3()));
        }if(NotaMayorEstudiante > notaMayorCurso){
                notaMayorCurso = NotaMayorEstudiante;
        }
        return notaMayorCurso;
    }
    public void calcularNotaMenorDelCurso(){

    }
    public void aprobacionCurso(){

    }
    public void calcularPorcentajeGanaronCurso(){

    }
    public void calcularPorcentajePerdieronCurso(){

    }
//   obtener el estudiante donde todas las notas sean mayor o igual a 4.
    public void obtenerEstudianteNotasMayor4(){

    }
//    Cuál es la máxima nota de cada estudiante?
    public void notaMaxima(){

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String correo) {
        Correo = correo;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", Correo='" + Correo + '\'' +
                '}';
    }
}
