package co.edu.uniquindio.Herencia_2.model;

public enum Categoria {
    AUXILIAR(2418460.0),
    ASISTENTE(2671350.0),
    ASOCIADO(2989580.0),
    TITULAR(3434420.0);

    private final double salario;

    Categoria(double salario){
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }
}
