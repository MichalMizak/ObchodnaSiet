package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl.history;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.impl.PrevadzkaDaoImpl;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.history.PrevadzkaHistoryDao;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.TableName;

/**
 *
 * @author Mikey
 */
public class PrevadzkaHistoryDaoImpl extends PrevadzkaDaoImpl implements PrevadzkaHistoryDao{
    
    public PrevadzkaHistoryDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        setTableName(TableName.prevadzka_history);
    }

    @Override
    public void delete(Long id) {
        try {
            throw new Exception("Useless method");
        } catch (Exception ex) {
            Logger.getLogger(PrevadzkaHistoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
