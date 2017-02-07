package sk.upjs.ics.paz1c.obchodnaSiet.entity;

public class Produkt {

    private Long id;
    private String nazov;
    private double nakupnaCena;
    private double predajnaCena;
    private Long dodavatel_id;

    public Produkt() {
    }

    public Produkt(String nazov, double nakupnaCena, double predajnaCena, Long dodavatel_id) {
        this.nazov = nazov;
        this.nakupnaCena = nakupnaCena;
        this.predajnaCena = predajnaCena;
        this.dodavatel_id = dodavatel_id;
    }


    public Long getDodavatel_id() {
        return dodavatel_id;
    }

    public void setDodavatel_id(Long dodavatel_id) {
        this.dodavatel_id = dodavatel_id;
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

    public double getNakupnaCena() {
        return nakupnaCena;
    }

    public void setNakupnaCena(double nakupnaCena) {
        this.nakupnaCena = nakupnaCena;
    }

    public double getPredajnaCena() {
        return predajnaCena;
    }

    public void setPredajnaCena(double predajnaCena) {
        this.predajnaCena = predajnaCena;
    }

    @Override
    public String toString() {
        return nazov + " (nákupná cena: " + nakupnaCena + ", predajná cena: " + predajnaCena + ")";
    }

}
