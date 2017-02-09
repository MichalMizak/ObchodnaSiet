package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.StatnyPoplatokDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.StatnyPoplatok;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class StatnyPoplatokComboBoxModel extends DefaultComboBoxModel {

    StatnyPoplatokDao statnyPoplatokDao = DaoFactory.INSTANCE.getStatnyPoplatokDao();
    
    public void refresh() {
        List<StatnyPoplatok> list = statnyPoplatokDao.getItems();
        
        for (StatnyPoplatok sp: list) {
            addElement(sp);
        }
    }
}
