package co.edu.uniquindio.Herencia_3.model;

public class Revista {
    private String name;
    private String pubDate;
    private  String ISSNcode;

    public Revista(String name, String pubDate, String ISSNcode) {
        this.name = name;
        this.pubDate = pubDate;
        this.ISSNcode = ISSNcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getISSNcode() {
        return ISSNcode;
    }

    public void setISSNcode(String ISSNcode) {
        this.ISSNcode = ISSNcode;
    }
}
