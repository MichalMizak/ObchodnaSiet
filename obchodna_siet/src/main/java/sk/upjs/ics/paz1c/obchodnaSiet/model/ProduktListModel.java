package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.AbstractListModel;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;

public class ProduktListModel extends AbstractListModel<Produkt> {

    private ProduktDao produktDao;
    private List<Produkt> produkty;

    public ProduktListModel() {
        produktDao = DaoFactory.INSTANCE.getProduktDao();
        produkty = produktDao.getProdukty();
    }

    @Override
    public int getSize() {
        return produkty.size();
    }

    @Override
    public Produkt getElementAt(int index) {
        return produkty.get(index);
    }

    public void refresh(){
        produkty = produktDao.getProdukty();
        fireContentsChanged(this, 0, getSize());
    }
    
}
