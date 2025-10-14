package co.edu.uniquindio.Herencia_3.model;

public class RevistaNacional extends Revista{
    private String intitution;


    public RevistaNacional(String name, String pubDate, String ISSNcode, String intitution){
        super(name, pubDate, ISSNcode);
        this.intitution = intitution;
    }

    public String getCounty() {
        return intitution;
    }

    public void setCounty(String intitution) {
        this.intitution = intitution;
    }

}
