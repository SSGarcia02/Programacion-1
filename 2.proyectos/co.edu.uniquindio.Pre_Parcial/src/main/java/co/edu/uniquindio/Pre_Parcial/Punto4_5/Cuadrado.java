package co.edu.uniquindio.Pre_Parcial.Punto4_5;

public class Cuadrado extends FiguraGeometrica{
    private double lado;

    public Cuadrado(Colores color, double lado) {
        super(color);
        this.lado = lado;
    }
    @Override
    public double calcularArea() {
        return lado*lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public String toString() {
        return "Cuadrado\nColor: " +getColor()+
                "\nlado: " + lado;
    }
}
