package sk.upjs.ics.paz1c.obchodnaSiet.entity;

import java.sql.Date;

public class Prijem extends ProduktNaPredajni {

    private Long id;
    private String popis;
    private Date datum;

    public Prijem() {
    }

    public Prijem(Long id, String popis, Date datum, Long produktId, Long prevadzkaId, double zlava, int kusy) {
        super(produktId, prevadzkaId, zlava, kusy);
        this.id = id;
        this.popis = popis;
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return getProduktId() + " (id prevádzky: " + getPrevadzkaId() + ", dátum: " + datum + ", popis: " + popis + ")";
    }

}
