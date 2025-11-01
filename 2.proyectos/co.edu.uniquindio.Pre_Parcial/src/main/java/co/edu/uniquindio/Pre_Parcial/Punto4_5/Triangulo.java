package co.edu.uniquindio.Pre_Parcial.Punto4_5;

public class Triangulo extends FiguraGeometrica{
    private double base;
    private double altura;

    public Triangulo(Colores color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double calcularArea() {
        return (base*altura)/2;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Triangulo\nColor: "+getColor()+
                "\nbase: " + base +
                "\naltura:" + altura;
    }
}
