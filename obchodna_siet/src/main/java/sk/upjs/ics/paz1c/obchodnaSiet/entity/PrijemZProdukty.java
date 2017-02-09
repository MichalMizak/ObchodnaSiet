package sk.upjs.ics.paz1c.obchodnaSiet.entity;

import java.sql.Date;

public class PrijemZProdukty extends ProduktNaPredajni {

    private Long id;
    private String popis;
    private Date datum;
    private double suma;

    public PrijemZProdukty() {
    }

    public PrijemZProdukty(Long id, String popis, Date datum, Long produktId, Long prevadzkaId, double zlava, int kusy) {
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

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    @Override
    public String toString() {
        return getProduktId() + " (id prevádzky: " + getPrevadzkaId() + ", dátum: " + datum + ", popis: " + popis + ")";
    }

}
