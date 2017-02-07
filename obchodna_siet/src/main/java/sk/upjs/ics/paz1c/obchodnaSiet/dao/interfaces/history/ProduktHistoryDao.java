package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.history;

import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrijemDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;

/**
 *
 * @author Mikey
 */
public interface ProduktHistoryDao extends ProduktDao {
    @Override
    void delete(Long id);
}
