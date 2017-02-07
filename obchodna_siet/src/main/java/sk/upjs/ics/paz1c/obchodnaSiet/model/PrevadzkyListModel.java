package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.AbstractListModel;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;

public class PrevadzkyListModel extends AbstractListModel<Prevadzka>{

    private PrevadzkaDao dao;
    private List<Prevadzka> prevadzky;
    
    public PrevadzkyListModel(){
        dao = DaoFactory.INSTANCE.getPrevadzkaDao();
        prevadzky = dao.getPrevadzky();
    }
    
    @Override
    public int getSize() {
        return prevadzky.size();
    }

    @Override
    public Prevadzka getElementAt(int index) {
        return prevadzky.get(index);
    }
    
    public void refresh(){
        prevadzky = dao.getPrevadzky();
        fireContentsChanged(this, 0, getSize());
    }
    
}
