package co.edu.uniquindio.Pre_Parcial.Punto4_5;

public abstract class FiguraGeometrica implements I_FiguraGeometrica{
    private Colores color;

    public FiguraGeometrica(Colores color) {
        this.color = color;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }
}
