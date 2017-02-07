package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.TransactionNumberDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.DatabaseSequence;

/**
 *
 * @author jake123 http://forum.spring.io/forum/spring-projects/data/36141-getting-sequence-value-from-database
 * @contributor Mikey (added enum)
 */
public class TransactionNumberDaoImpl extends JdbcDaoSupport implements TransactionNumberDao {

    @Override
    public Long getNextTransactionNumberFromSequence(DatabaseSequence sequence) {

        JdbcTemplate jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();
        String sql = "select " + sequence.toString() + ".nextval from dual";
        return jdbcTemplate.execute((Connection connection) -> connection.prepareStatement(sql), (PreparedStatement ps) -> {
            ResultSet rs = ps.executeQuery();
            Long value = null;
            while (rs.next()) {
                value = rs.getLong(1);
            }
            return value;
        });
    }
}
