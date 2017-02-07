package sk.upjs.ics.paz1c.obchodnaSiet.entity;

public class Nastavenia {

    private Long id;
    private String nazovObchodnejSiete;
    private String mena;

    public Nastavenia() {

    }

    public Nastavenia(String nazovObchodnejSiete, String mena) {
        this.nazovObchodnejSiete = nazovObchodnejSiete;
        this.mena = mena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazovObchodnejSiete() {
        return nazovObchodnejSiete;
    }

    public void setNazovObchodnejSiete(String nazovObchodnejSiete) {
        this.nazovObchodnejSiete = nazovObchodnejSiete;
    }

    public String getMena() {
        return mena;
    }

    public void setMena(String mena) {
        this.mena = mena;
    }

}
