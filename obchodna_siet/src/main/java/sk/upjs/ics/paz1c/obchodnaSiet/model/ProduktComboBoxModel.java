package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;

public class ProduktComboBoxModel extends DefaultComboBoxModel<Produkt> {
    
    private ProduktDao dao = DaoFactory.INSTANCE.getProduktDao();
    private List<Produkt> produkty = dao.getProdukty();

    public ProduktComboBoxModel() {
        for (Produkt p : produkty){
            addElement(p);
        }
    }   
    
    
}
