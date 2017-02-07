package sk.upjs.ics.paz1c.obchodnaSiet.entity;

public class ProduktNaPredajni {

    private Long produktId;
    private Long prevadzkaId;
    private double zlava;
    private int kusy;

    public ProduktNaPredajni() {
    }

    public ProduktNaPredajni(Long produktId, Long prevadzkaId, double zlava, int kusy) {
        this.produktId = produktId;
        this.prevadzkaId = prevadzkaId;
        this.zlava = zlava;
        this.kusy = kusy;
    }

    public final Long getProduktId() {
        return produktId;
    }
    
    public final void setProduktId(Long produktId) {
        this.produktId = produktId;
    }

    public final Long getPrevadzkaId() {
        return prevadzkaId;
    }

    public final void setPrevadzkaId(Long prevadzkaId) {
        this.prevadzkaId = prevadzkaId;
    }

    public double getZlava() {
        return zlava;
    }

    public void setZlava(double zlava) {
        this.zlava = zlava;
    }

    public int getKusy() {
        return kusy;
    }

    public void setKusy(int kusy) {
        this.kusy = kusy;
    }

    @Override
    public String toString() {
        return "id produktu: " + produktId + ", id predajne: " + prevadzkaId + ", zľava: " + zlava + "počet kusov: " + kusy;
    }

}
