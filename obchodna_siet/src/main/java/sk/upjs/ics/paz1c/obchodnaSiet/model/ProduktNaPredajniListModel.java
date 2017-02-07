package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.AbstractListModel;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktNaPredajniDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.ProduktNaPredajni;

public class ProduktNaPredajniListModel extends AbstractListModel<ProduktNaPredajni> {

    private final ProduktNaPredajniDao produktNaPredajniDao;
    private final List<ProduktNaPredajni> produktyNaPredajni;

    public ProduktNaPredajniListModel() {
        produktNaPredajniDao = DaoFactory.INSTANCE.getProduktNaPredajniDao();
        produktyNaPredajni = produktNaPredajniDao.getProduktyNaPredajni();
    }

    @Override
    public int getSize() {
        return produktyNaPredajni.size();
    }

    @Override
    public ProduktNaPredajni getElementAt(int index) {
        return produktyNaPredajni.get(index);
    }

}
