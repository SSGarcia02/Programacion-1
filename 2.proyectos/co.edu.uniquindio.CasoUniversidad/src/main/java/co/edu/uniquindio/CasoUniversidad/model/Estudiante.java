package co.edu.uniquindio.CasoUniversidad.model;

public class Estudiante {
    private String nombre;
    private int edad;
    private String Correo;
    private int semestre;
    private double nota1;
    private double nota2;
    private double nota3;

    public Estudiante(){}
    public Estudiante(String nombre, int edad, String correo,
                      int semestre, double nota1, double nota2, double nota3) {
        this.nombre = nombre;
        this.edad = edad;
        Correo = correo;
        this.semestre = semestre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    public double calcularNotaDefinitiva(double nota1, double nota2, double nota3){
        double notaDefinitiva = (nota1 + nota2 + nota3)/3;
        return notaDefinitiva;
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
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    public double getNota1() {
        return nota1;
    }
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }
    public double getNota2() {return nota2;}
    public void setNota2(double nota2) {this.nota2 = nota2;}
    public double getNota3() {
        return nota3;
    }
    public void setNota3(double nota3) {this.nota3 = nota3;}

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", Correo='" + Correo + '\'' +
                ", semestre=" + semestre +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                '}';
    }
}

