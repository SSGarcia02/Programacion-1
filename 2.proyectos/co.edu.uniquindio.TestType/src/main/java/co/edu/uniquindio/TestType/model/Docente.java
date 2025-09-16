package co.edu.uniquindio.TestType.model;

import javax.print.Doc;

public class Docente {
    private String nombre;
    private int salario;
    private int edad;

    public Docente(){}

    public Docente(String nombre, int salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }
    public double obtenerNotaMayorEstudiante(double nota1, double nota2,
                                             double nota3, double nota4){
        double notaMayor;
        if(nota1 > nota2 && nota1 > nota3 && nota1 > nota4){
            notaMayor = nota1;
        }else if(nota2 > nota3 && nota2 > nota4){
            notaMayor = nota2;
        }else if(nota3 > nota4){
            notaMayor = nota3;
        }else{
            notaMayor = nota4;
        }
        return notaMayor;
    }
    public double obternerNotaMenorEstudiante(double nota1, double nota2,
                                              double nota3, double nota4){
        double notaMenor;
        if(nota1 < nota2 && nota1 < nota3 && nota1 < nota4){
            notaMenor = nota1;
        }else if(nota2 < nota3 && nota2 < nota4){
            notaMenor = nota2;
        }else if(nota3 < nota4){
            notaMenor = nota3;
        }else{
            notaMenor = nota4;
        }
        return notaMenor;
    }
    public double obtenerPormedioEstudiante(double nota1, double nota2,
                                            double nota3, double nota4){
        double promedio = (nota1 + nota2 + nota3 + nota4)/4;

        return promedio;
    }
    public boolean aprobacionEstudianteCurso(double nota1, double nota2,
                                          double nota3, double nota4){
        double notaDefinitiva = obtenerPormedioEstudiante(nota1, nota2, nota3, nota4);
        if(notaDefinitiva >= 3.0){
            return true;
        }else{
            return false;
        }
    }
    public boolean obtenerNumeroConsonates(String nombreEstudiante){
        int contador = 0;
        char a = 'a';
        char e = 'e';
        char i = 'i';
        char o = 'o';
        char u = 'u';

        nombreEstudiante = nombreEstudiante.toLowerCase();
        for(int j = 0; j < nombreEstudiante.length(); j++){
            if(nombreEstudiante.charAt(j) != a
                    && nombreEstudiante.charAt(j) != e
                    && nombreEstudiante.charAt(j) != i
                    && nombreEstudiante.charAt(j) != o
                    && nombreEstudiante.charAt(j) != u) {
                contador += 1;
            }
        }
        if(contador > 3){
            return true;
        }else{
            return false;
        }
    }
    //   obtener el estudiante donde todas las notas sean mayor o igual a 4.
    public boolean obtenerEstudianteNotasMayorA4(double nota1, double nota2,
                                                 double nota3, double nota4){
        if(nota1 >= 4.0 && nota2 >= 4.0 && nota3 >= 4.0 && nota4 >= 4.0){
            return true;
        }else{
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", edad=" + edad +
                '}';
    }
}
