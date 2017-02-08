package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.TransactionNumberDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.history.ProduktHistoryDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Dodavatel;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.backupable.Backupable;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.DatabaseSequence;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.TableName;

public class ProduktDaoImpl extends Backupable implements ProduktDao {

    private final JdbcTemplate jdbcTemplate;

    public ProduktDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        setTableName(TableName.produkt);
    }

    @Override
    public void save(Produkt produkt) {
        TransactionNumberDao transactionNumberDao = DaoFactory.INSTANCE.getTransactionNumberDao();

        Long generatedId = transactionNumberDao.getNextTransactionNumberFromSequence(DatabaseSequence.produkt_sequence);
        produkt.setId(generatedId);

        String sql = "INSERT INTO " + getTableName().toString() + " (id, nazov, nakupna_cena, predajna_cena, dodavatel_id) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, produkt.getId(), produkt.getNazov(), produkt.getNakupnaCena(), produkt.getPredajnaCena(), produkt.getDodavatel_id());
    }

    @Override
    public Produkt getById(Long id) {
        String sql = "SELECT * FROM " + getTableName().toString() + " WHERE id =" + id;
        BeanPropertyRowMapper<Produkt> rowMapper = new BeanPropertyRowMapper<>(Produkt.class);
        List<Produkt> result = jdbcTemplate.query(sql, rowMapper);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<Produkt> getProdukty() {
        String sql = "SELECT * FROM " + getTableName().toString() + "";
        BeanPropertyRowMapper<Produkt> rowMapper = new BeanPropertyRowMapper<>(Produkt.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    // TODO
    @Override
    public void edit(Produkt produkt) {
        String sql = "UPDATE " + getTableName().toString() + " SET nazov = ?, nakupna_cena = ?, predajna_cena = ?,"
                + " dodavatel_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, produkt.getNazov(), produkt.getNakupnaCena(),
                produkt.getPredajnaCena(), produkt.getDodavatel_id(), produkt.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM " + getTableName().toString() + " WHERE id=" + id;
        jdbcTemplate.execute(sql);
        
        // backup
        ProduktHistoryDao produktHistoryDao = DaoFactory.INSTANCE.getProduktHistoryDao();
        produktHistoryDao.save(getById(id));
    }

    @Override
    public double vycisliZisk(Long id) {
        String sql = "SELECT (predajna_cena - nakupna_cena) as zisk FROM " + getTableName().toString() + " WHERE id=" + id;
        return jdbcTemplate.queryForObject(sql, Double.class);
    }

    @Override
    public List<Produkt> getByDodavatel(Dodavatel dodavatel) {
        String sql = "SELECT * FROM " + getTableName().toString() + " WHERE dodavatel_id = ?";
        BeanPropertyRowMapper<Produkt> rowMapper = new BeanPropertyRowMapper<>(Produkt.class);
        return jdbcTemplate.query(sql, rowMapper, dodavatel.getId());
    }
}
