package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl.history;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.impl.ProduktDaoImpl;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.history.ProduktHistoryDao;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.TableName;

/**
 *
 * @author Mikey
 */
public class ProduktHistoryDaoImpl extends ProduktDaoImpl implements ProduktHistoryDao {

    public ProduktHistoryDaoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        setTableName(TableName.produkt_history);
    }

    @Override
    public void delete(Long id) {
        try {
            throw new Exception("Useless method");
        } catch (Exception ex) {
            Logger.getLogger(ProduktHistoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
