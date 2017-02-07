package sk.upjs.ics.paz1c.obchodnaSiet.entity;

public class Prevadzka {

    private Long id;
    private String nazov;
    private String adresa;
    private String otvaracieHodiny;

    public Prevadzka() {
    }

    public Prevadzka(String nazov, String adresa, String otvaracieHodiny) {
        this.nazov = nazov;
        this.adresa = adresa;
        this.otvaracieHodiny = otvaracieHodiny;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOtvaracieHodiny() {
        return otvaracieHodiny;
    }

    public void setOtvaracieHodiny(String otvaracieHodiny) {
        this.otvaracieHodiny = otvaracieHodiny;
    }

    @Override
    public String toString() {
        return nazov + ", " + adresa;
    }

}
