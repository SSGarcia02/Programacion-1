package co.edu.uniquindio.Herencia_3.model;

public class RevistaImportada extends Revista{
    private String country;


    public RevistaImportada(String name, String pubDate, String ISSNcode, String country){
        super(name, pubDate, ISSNcode);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
