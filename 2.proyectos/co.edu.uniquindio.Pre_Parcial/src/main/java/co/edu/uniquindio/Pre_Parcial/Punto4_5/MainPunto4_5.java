package co.edu.uniquindio.Pre_Parcial.Punto4_5;

import java.util.ArrayList;

public class MainPunto4_5 {
    public static void main(String[] args) {

        Circulo circulo = new Circulo(Colores.AZUL, 2);
        Triangulo triangulo = new Triangulo(Colores.ROJO, 5, 3);
        Cuadrado cuadrado = new Cuadrado(Colores.AMARILLO, 4);

        ArrayList<FiguraGeometrica> listaFiguras = new ArrayList<>();
        listaFiguras.add(circulo);
        listaFiguras.add(triangulo);
        listaFiguras.add(cuadrado);

        for(int i = 0; i < listaFiguras.size(); i++){
            System.out.println(listaFiguras.get(i));
            System.out.println("Area: "+listaFiguras.get(i).calcularArea());
            System.out.println(" ");
        }
    }
}
