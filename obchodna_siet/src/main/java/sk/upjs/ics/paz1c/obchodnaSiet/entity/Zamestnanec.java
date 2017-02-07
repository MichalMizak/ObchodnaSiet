package sk.upjs.ics.paz1c.obchodnaSiet.entity;

import java.sql.Date;

public class Zamestnanec {

    private Long id;
    private String meno;
    private String priezvisko;
    private Long prevadzkaId;
    private Date datumNastupu;
    private double platBrutto;

    public Zamestnanec() {
    }

    public Zamestnanec(String meno, String priezvisko, Long prevadzkaId, Date datumNastupu, double platBrutto) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.prevadzkaId = prevadzkaId;
        this.datumNastupu = datumNastupu;
        this.platBrutto = platBrutto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public Long getPrevadzkaId() {
        return prevadzkaId;
    }

    public void setPrevadzkaId(Long prevadzkaId) {
        this.prevadzkaId = prevadzkaId;
    }

    public Date getDatumNastupu() {
        return datumNastupu;
    }

    public void setDatumNastupu(Date datumNastupu) {
        this.datumNastupu = datumNastupu;
    }

    public double getPlatBrutto() {
        return platBrutto;
    }

    public void setPlatBrutto(double platBrutto) {
        this.platBrutto = platBrutto;
    }

    @Override
    public String toString() {
        return meno + " " + priezvisko + ", plat: " + platBrutto;
    }

}
