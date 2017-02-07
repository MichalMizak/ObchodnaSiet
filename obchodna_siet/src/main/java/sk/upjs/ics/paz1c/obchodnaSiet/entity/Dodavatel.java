package sk.upjs.ics.paz1c.obchodnaSiet.entity;

/**
 *
 * @author Mikey
 */
public class Dodavatel {
    
    private Long id;
    
    private String nazov;
    
    private String sidlo;
    
    private String kontakt;

    public Dodavatel() {
    }

    public Dodavatel(Long id, String nazov, String sidlo, String kontakt) {
        this.id = id;
        this.nazov = nazov;
        this.sidlo = sidlo;
        this.kontakt = kontakt;
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

    public String getSidlo() {
        return sidlo;
    }

    public void setSidlo(String sidlo) {
        this.sidlo = sidlo;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    @Override
    public String toString() {
        return nazov + ", " + sidlo;
    }
    
}
