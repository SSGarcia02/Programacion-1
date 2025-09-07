package co.edu.uniquindio.CasoUniversidad.model;

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
        double notaMayorEstudiante = 0;
        double notaMayorCurso = 0;
        for(int i = 0; i<curso.getListaEstudiantes().size(); i++){
            Estudiante estudiante = curso.getListaEstudiantes().get(i); //<<<<<<<<<<<<<<<<<<<
            notaMayorEstudiante = Math.max(estudiante.getNota1(),
                    Math.max(estudiante.getNota2(),estudiante.getNota3()));
        }if(notaMayorEstudiante > notaMayorCurso){
                notaMayorCurso = notaMayorEstudiante;
        }
        return notaMayorCurso;
    }
    public double calcularNotaMenorDelCurso(Curso curso){
        double notaMenorEstudiante = 0;
        double notaMenorCurso = 0;
        for(int i = 0; i < curso.getListaEstudiantes().size(); i++){
            Estudiante estudiante = curso.getListaEstudiantes().get(i);
            notaMenorEstudiante = Math.min(estudiante.getNota1(),
                    Math.min(estudiante.getNota2(),estudiante.getNota3()));
        }if(notaMenorEstudiante > notaMenorCurso){
            notaMenorCurso = notaMenorEstudiante;
        }
        return notaMenorCurso;
    }
    public String aprobacionEstudianteCurso(double nota1, double nota2, double nota3){
        double notaDefinitiva = calcularDefinitivaEstudiante(nota1,nota2,nota3);
        if(notaDefinitiva < 3.0){
            return "Estudiante reporbo el curso";
        }
        return "Estudiante aprobo el curso";
    }
    public int aprobacionTotalCurso(double nota1, double nota2, double nota3){
        double notaDefinitiva = calcularDefinitivaEstudiante(nota1,nota2,nota3);
        int contadorEstudianteAprobado = 0;
        if(notaDefinitiva >= 3.0){
            contadorEstudianteAprobado += 1;
        }
        return contadorEstudianteAprobado;
    }
    public int reporbadoTotalCurso(double nota1, double nota2, double nota3){
        double notaDefinitiva = calcularDefinitivaEstudiante(nota1, nota2, nota3);
        int contadorEstudianteReporbado = 0;
        if(notaDefinitiva < 3.0){
            contadorEstudianteReporbado += 1;
        }
        return contadorEstudianteReporbado;
    }
    public double calcularPorcentajeGanaronCurso(double nota1, double nota2, double nota3){
        double porcentajeGanaron = aprobacionTotalCurso(nota1, nota2, nota3);
        porcentajeGanaron = (porcentajeGanaron*100)/3;
        return porcentajeGanaron;
    }
    public double calcularPorcentajePerdieronCurso(double nota1, double nota2, double nota3){
        double porcentajeReporbado = reporbadoTotalCurso(nota1, nota2, nota3);
        porcentajeReporbado = (porcentajeReporbado*100)/3;
        return porcentajeReporbado;
    }
//   obtener el estudiante donde todas las notas sean mayor o igual a 4.
    public String obtenerEstudianteNotasMayorA4(Curso curso){
        Estudiante estudianteEncontrado = null;
        for(int i = 0; i < curso.getListaEstudiantes().size(); i++){
            Estudiante estudiante = curso.getListaEstudiantes().get(i);
            if(estudiante.getNota1() >= 4.0 &&
                    estudiante.getNota2() >= 4.0 &&
                    estudiante.getNota3() >= 4.0){
            estudianteEncontrado = curso.getListaEstudiantes().get(i);
            return estudianteEncontrado+"tiene todas las notas supperiores a 4.0";
            }
        }return "Ningun estudiante tiene todas las notas supperiores a 4.0";
    }
//    Cuál es la máxima nota de cada estudiante?
    public double notaMaxima(double nota1, double nota2, double nota3){
        double notaMasAlta = Math.max(nota1,Math.max(nota2,nota3));
        return notaMasAlta;
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
