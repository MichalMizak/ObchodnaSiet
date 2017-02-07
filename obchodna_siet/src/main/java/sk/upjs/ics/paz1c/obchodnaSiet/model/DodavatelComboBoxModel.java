package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.DodavatelDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Dodavatel;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class DodavatelComboBoxModel extends DefaultComboBoxModel<Dodavatel> {
   
    private DodavatelDao dao = DaoFactory.INSTANCE.getDodavatelDao();
    private List<Dodavatel> produkty;

    public DodavatelComboBoxModel() {
        refresh();
    }

    private void refresh() {
        produkty = dao.getDodavatelia();
        for (Dodavatel p : produkty){
            addElement(p);
        }
    }
    
}
