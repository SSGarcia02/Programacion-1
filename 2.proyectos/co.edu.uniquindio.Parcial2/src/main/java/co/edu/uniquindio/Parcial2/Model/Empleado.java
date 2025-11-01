package co.edu.uniquindio.Parcial2.Model;

import java.util.ArrayList;

public class Empleado extends Persona{
    private double salario;
    private int numeroHorasTrabajo;
    private Finca ownedBYFinca;
    private ArrayList<Tarea> listaTareaAsociadas;
    private TipoContrato tipoContrato;

    public Empleado(){}
    public Empleado(String nombre, String apellido, String cedula,
                    int edad, double salario, int numeroHorasTrabajo,
                    Finca ownedBYFinca) {
        super(nombre, apellido, cedula, edad);
        this.salario = salario;
        this.numeroHorasTrabajo = numeroHorasTrabajo;
        this.ownedBYFinca = ownedBYFinca;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getNumeroHorasTrabajo() {
        return numeroHorasTrabajo;
    }

    public void setNumeroHorasTrabajo(int numeroHorasTrabajo) {
        this.numeroHorasTrabajo = numeroHorasTrabajo;
    }

    public Finca getOwnedBYFinca() {
        return ownedBYFinca;
    }

    public void setOwnedBYFinca(Finca ownedBYFinca) {
        this.ownedBYFinca = ownedBYFinca;
    }

    public ArrayList<Tarea> getListaTareaAsociadas() {
        return listaTareaAsociadas;
    }

    public void setListaTareaAsociadas(ArrayList<Tarea> listaTareaAsociadas) {
        this.listaTareaAsociadas = listaTareaAsociadas;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
}
