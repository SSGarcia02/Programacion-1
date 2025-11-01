package co.edu.uniquindio.Pre_Parcial.Punto4;

public class EmpleadoPorHoras extends Empleado{
    private int horasTrabajas;
    private int pagoPorHora;

    public EmpleadoPorHoras() {
    }
    public EmpleadoPorHoras(String nombre, int ID, int horasTrabajas, int pagoPorHora) {
        super(nombre, ID);
        this.horasTrabajas = horasTrabajas;
        this.pagoPorHora = pagoPorHora;
    }

    @Override
    public double calcularSalario() {
        double salarioTotal = horasTrabajas*pagoPorHora;
        return salarioTotal;
    }

    public int getHorasTrabajas() {
        return horasTrabajas;
    }

    public void setHorasTrabajas(int horasTrabajas) {
        this.horasTrabajas = horasTrabajas;
    }

    public int getPagoPorHora() {
        return pagoPorHora;
    }

    public void setPagoPorHora(int pagoPorHora) {
        this.pagoPorHora = pagoPorHora;
    }

    @Override
    public String toString() {
        return "\nNombre: "+getNombre()+"\nID: "+getID()+
                "\nhorasTrabajas: " + horasTrabajas +
                "\npagoPorHora: " + pagoPorHora;
    }
}
