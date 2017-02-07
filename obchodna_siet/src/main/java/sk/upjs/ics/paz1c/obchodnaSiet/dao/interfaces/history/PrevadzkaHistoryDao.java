package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.history;

import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;

/**
 *
 * @author Mikey
 */
public interface PrevadzkaHistoryDao extends PrevadzkaDao{
    @Override
    void delete(Long id);
}
