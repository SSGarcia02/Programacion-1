package co.edu.uniquindio.Pre_Parcial.Punto4_5;

public class Circulo extends FiguraGeometrica{
    private double radio;

    public Circulo(Colores color, double radio) {
        super(color);
        this.radio = radio;
    }
    @Override
    public double calcularArea() {
        return Math.PI*(radio*radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circulo\nColor: "
                +getColor()+
                "\nradio: " + radio;
    }
}
