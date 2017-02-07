package sk.upjs.ics.paz1c.obchodnaSiet.entity;

import java.sql.Date;

public class Naklad {

    private Long id;
    private Long prevadzkaId;
    private String popis;
    private Date datum;
    private double suma;

    public Naklad() {
    }

    public Naklad(Long prevadzkaId, String popis, Date datum, double suma) {
        this.prevadzkaId = prevadzkaId;
        this.popis = popis;
        this.datum = datum;
        this.suma = suma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrevadzkaId() {
        return prevadzkaId;
    }

    public void setPrevadzkaId(Long prevadzkaId) {
        this.prevadzkaId = prevadzkaId;
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
        return suma + " (id prevádzky: " + prevadzkaId + ", popis: " + popis + ", dátum: " + datum + ")";
    }

}
