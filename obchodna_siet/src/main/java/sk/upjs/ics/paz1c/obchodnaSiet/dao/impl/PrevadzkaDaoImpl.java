package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import java.sql.ResultSet;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import java.util.List;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.TransactionNumberDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.history.PrevadzkaHistoryDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.backupable.Backupable;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.DatabaseSequence;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.TableName;

public class PrevadzkaDaoImpl extends Backupable implements PrevadzkaDao {

    private final JdbcTemplate jdbcTemplate;

    public PrevadzkaDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        setTableName(TableName.prevadzka);
    }

    @Override
    public void saveOrEdit(Prevadzka prevadzka) {
        if (prevadzka.getId() != null) {
            String sql = "UPDATE " + getTableName().toString() + " SET nazov = ?, adresa = ?, otvaracie_hodiny = ? where id = ?";
            jdbcTemplate.update(sql, prevadzka.getNazov(), prevadzka.getAdresa(), prevadzka.getOtvaracieHodiny(),
                    prevadzka.getId());
        } else {
            TransactionNumberDao transactionNumberDao = DaoFactory.INSTANCE.getTransactionNumberDao();

            Long generatedId = transactionNumberDao.getNextTransactionNumberFromSequence(DatabaseSequence.prevadzka_sequence);
            prevadzka.setId(generatedId);

            String sql = "INSERT INTO " + getTableName().toString() + " (id, nazov, adresa, otvaracie_hodiny) VALUES (?,?,?,?)";
            jdbcTemplate.update(sql, prevadzka.getId(), prevadzka.getNazov(), prevadzka.getAdresa(), prevadzka.getOtvaracieHodiny());
        }
    }

    @Override
    public Prevadzka getById(Long id) {
        if (id == null) {
            return null;
        }
        String sql = "SELECT * FROM " + getTableName().toString() + " WHERE id=" + id;
        BeanPropertyRowMapper<Prevadzka> rowMapper = new BeanPropertyRowMapper<>(Prevadzka.class);
        // return jdbcTemplate.queryForObject(sql, rowMapper);
        // aj nasledujuce funguje :)
        List<Prevadzka> result = jdbcTemplate.query(sql, rowMapper);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<Prevadzka> getPrevadzky() {
        String sql = "SELECT * FROM " + getTableName().toString();
        BeanPropertyRowMapper<Prevadzka> rowMapper = new BeanPropertyRowMapper<>(Prevadzka.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM " + getTableName().toString() + " WHERE id=" + id;
        jdbcTemplate.execute(sql);
        
         // backup
        PrevadzkaHistoryDao produktHistoryDao = DaoFactory.INSTANCE.getPrevadzkaHistoryDao();
        produktHistoryDao.saveOrEdit(getById(id));
    }

    /**
     * unfunctional for history
     * @param id
     * @return 
     */
    @Override
    public double vycisliZisk(Long id) {
        String sql1 = "SELECT SUM(suma) as suma FROM naklad WHERE prevadzka_id=?";

        Double naklad = jdbcTemplate.queryForObject(sql1, (ResultSet rs, int i) -> {
            Double result = rs.getDouble("suma");
            return result;
        }, id);

        String sql2 = "SELECT SUM(produkt_id) as produkt_id FROM prijem WHERE prevadzka_id=?";
        Double prijem = jdbcTemplate.queryForObject(sql2, (ResultSet rs, int i) -> {
            Double result = rs.getDouble("produkt_id");
            return result;
        }, id);
        // TODO should throw Exception instead of returning Double.MIN_VALUE
        if (naklad == null && prijem == null) {
            return Double.MIN_VALUE;
        }
        if (naklad == null) {
            return prijem;
        }
        if (prijem == null) {
            return -naklad;
        }
        return prijem - naklad;
    }
}
