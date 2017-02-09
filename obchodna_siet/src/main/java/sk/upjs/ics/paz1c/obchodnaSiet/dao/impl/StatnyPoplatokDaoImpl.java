package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Builder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.StatnyPoplatokDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.TransactionNumberDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.PrijemZProdukty;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.StatnyPoplatok;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.DatabaseSequence;

/**
 *
 * @author Mikey
 */
public class StatnyPoplatokDaoImpl implements StatnyPoplatokDao {

    JdbcTemplate jdbcTemplate;

    public StatnyPoplatokDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public StatnyPoplatok getById(Long id) {
        String sql = "SELECT s.id, s.krajina, s.percent FROM statny_poplatok s WHERE s.id = ?";
        List<StatnyPoplatok> result = jdbcTemplate.query(sql, new StatnyPoplatokRowMapper(), id);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<StatnyPoplatok> getItems() {
        String sql = "SELECT s.id, s.krajina, s.percent FROM statny_poplatok s";
        List<StatnyPoplatok> result = jdbcTemplate.query(sql, new StatnyPoplatokRowMapper());
        return result;
    }

    @Override
    public void saveOrEdit(StatnyPoplatok statnyPoplatok) {
        if (statnyPoplatok.getId() != null) {
            String sql = "UPDATE statny_poplatok s SET s.krajina = ?, s.percent = ? where id = ?";
            jdbcTemplate.update(sql, statnyPoplatok.getKrajina(), statnyPoplatok.getPercent(), statnyPoplatok.getId());
        } else {
            TransactionNumberDao transactionNumberDao = DaoFactory.INSTANCE.getTransactionNumberDao();

            Long generatedId = transactionNumberDao.getNextTransactionNumberFromSequence(DatabaseSequence.statny_poplatok_sequence);
            statnyPoplatok.setId(generatedId);

            String sql = "INSERT INTO statny_poplatok (id, krajina, percent) VALUES (?,?,?)";
            jdbcTemplate.update(sql, statnyPoplatok.getId(), statnyPoplatok.getKrajina(), statnyPoplatok.getPercent());
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM statny_poplatok WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private class StatnyPoplatokRowMapper implements RowMapper<StatnyPoplatok> {

        @Override
        public StatnyPoplatok mapRow(ResultSet rs, int i) throws SQLException {
            StatnyPoplatok statnyPoplatok = new StatnyPoplatok();

            statnyPoplatok.setId(rs.getLong("id"));
            statnyPoplatok.setKrajina(rs.getString("krajina"));
            statnyPoplatok.setPercent(rs.getDouble("percent"));

            return statnyPoplatok;
        }
    }

}
