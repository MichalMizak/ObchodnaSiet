package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.AbstractListModel;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrijemDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prijem;

public class PrijemListModel extends AbstractListModel<Prijem> {

    private PrijemDao prijemDao;
    private List<Prijem> prijmy;

    public PrijemListModel() {
        prijemDao = DaoFactory.INSTANCE.getPrijemDao();
        prijmy = prijemDao.getPrijmy();
    }

    @Override
    public int getSize() {
        return prijmy.size();
    }

    @Override
    public Prijem getElementAt(int index) {
        return prijmy.get(index);
    }

    public void refresh(){
        prijmy = prijemDao.getPrijmy();
        fireContentsChanged(this, 0, getSize());
    }
    
}
