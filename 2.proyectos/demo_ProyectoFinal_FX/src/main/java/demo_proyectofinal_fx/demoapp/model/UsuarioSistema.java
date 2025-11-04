package demo_proyectofinal_fx.demoapp.model;

public abstract class UsuarioSistema extends Persona{
    private String password;


    public UsuarioSistema() {}
    public UsuarioSistema(String nombre, String apellido, String identificacion,
                          int edad, String telefono, String password) {
        super(nombre, apellido, identificacion, edad, telefono);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
