package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrijemDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktNaPredajniDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.PrijemZProdukty;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.ProduktNaPredajni;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class ProduktNaPredajniComboBoxModel extends DefaultComboBoxModel<ProduktNaPredajni> {

    private ProduktNaPredajniDao pnpDao = DaoFactory.INSTANCE.getProduktNaPredajniDao();
    private Prevadzka prevadzka;

    public ProduktNaPredajniComboBoxModel(Prevadzka prevadzka) {
        this.prevadzka = prevadzka;
        refresh(prevadzka);
    }

    public void refresh(Prevadzka prevadzka) {
        removeAllElements();
        
        List<ProduktNaPredajni> prijmy = pnpDao.getByPrevadzka(prevadzka.getId());
        
        for (ProduktNaPredajni p : prijmy) {
            addElement(p);
        }
    }

    public void sleep() {
        removeAllElements();
    }
}
