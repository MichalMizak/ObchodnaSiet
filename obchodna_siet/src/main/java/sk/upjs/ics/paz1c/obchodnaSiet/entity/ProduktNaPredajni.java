package sk.upjs.ics.paz1c.obchodnaSiet.entity;

import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 * Inheritance almost not used, options are open
 * @author Mikey 
 */
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
        // my f***ing god no sorry for this
        ProduktDao produktDao = DaoFactory.INSTANCE.getProduktDao();
        Produkt produkt = produktDao.getById(getProduktId());
        
        return produkt.toString() + ", Počet kusov: " + kusy;
    }

}
