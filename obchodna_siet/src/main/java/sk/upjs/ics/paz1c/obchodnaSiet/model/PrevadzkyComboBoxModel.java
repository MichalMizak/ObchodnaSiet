package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;

public class PrevadzkyComboBoxModel extends DefaultComboBoxModel<Prevadzka>{
    
    private PrevadzkaDao dao = DaoFactory.INSTANCE.getPrevadzkaDao();
    private List<Prevadzka> prevadzky = dao.getPrevadzky();

    public PrevadzkyComboBoxModel() {
       refresh();
    }
    
    public void refresh() {
        removeAllElements();
        for (Prevadzka p : prevadzky){
           addElement(p);
       }
    }
    
    public void sleep() {
        removeAllElements();
    }
    
}
