package demo_proyectofinal_fx.demoapp.model;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String identificacion;
    private int edad;
    private String telefono;
    private Gimnasio ownedByGimnasio;

    public Persona(){}
    public Persona(String nombre, String apellido, String identificacion, int edad, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Gimnasio getOwnedByGimnasio() {
        return ownedByGimnasio;
    }

    public void setOwnedByGimnasio(Gimnasio ownedByGimnasio) {
        this.ownedByGimnasio = ownedByGimnasio;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
