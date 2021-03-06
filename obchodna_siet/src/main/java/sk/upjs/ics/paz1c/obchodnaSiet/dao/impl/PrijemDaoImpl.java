package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrijemDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.PrijemZProdukty;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.TransactionNumberDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.history.ProduktHistoryDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.backupable.Backupable;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.DatabaseSequence;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.TableName;

public class PrijemDaoImpl extends Backupable implements PrijemDao {

    private JdbcTemplate jdbcTemplate;

    public PrijemDaoImpl(JdbcTemplate jdbcTemplate) {
        setJdbcTemplate(jdbcTemplate);
        setTableName(TableName.prijem);
    }

    protected final void setJdbcTemplate(JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate = jdbcTemplate1;
    }

    @Override
    public void save(PrijemZProdukty prijem) {
        TransactionNumberDao transactionNumberDao = DaoFactory.INSTANCE.getTransactionNumberDao();

        Long generatedId = transactionNumberDao.getNextTransactionNumberFromSequence(DatabaseSequence.prijem_sequence);
        prijem.setId(generatedId);

        String sql = "INSERT INTO " + getTableName().toString() + "(id, popis, "
                + "datum, produkt_id, prevadzka_id, zlava, kusy, suma) VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, prijem.getId(), prijem.getPopis(), prijem.getDatum(),
                prijem.getProduktId(), prijem.getPrevadzkaId(), prijem.getZlava(), prijem.getKusy(), prijem.getSuma());
    }

    @Override
    public PrijemZProdukty getById(Long id) {
        String sql = "SELECT p.id, p.popis, p.datum, p.produkt_id, p.prevadzka_id,"
                + " p.zlava, p.kusy, p.suma from " + getTableName().toString() + " p WHERE p.id=?";
        return jdbcTemplate.queryForObject(sql, new PrijemRowMapper(), id);
    }

    @Override
    public List<PrijemZProdukty> getPrijmy() {
        String sql = "SELECT p.id, p.popis, p.datum, p.produkt_id, p.prevadzka_id, "
                + "p.zlava, p.kusy, p.suma from " + getTableName().toString() + " p";
        return jdbcTemplate.query(sql, new PrijemRowMapper());
    }

    @Override
    public List<PrijemZProdukty> getPrijmyByPrevadzka(Long prevadzkaId) {
        String sql = "SELECT p.id, p.popis, p.datum, p.produkt_id, p.prevadzka_id,"
                + " p.zlava, p.kusy, p.suma from " + getTableName().toString() + " p "
                + "WHERE p.prevadzka_id = ?";
        return jdbcTemplate.query(sql, new PrijemRowMapper(), prevadzkaId);
    }

    // TODO
    @Override
    public void edit(PrijemZProdukty prijem) {
        String sql = "UPDATE " + getTableName().toString() + " SET popis = ?, "
                + "datum = ?, produkt_id = ?, prevadzka_id = ?, zlava = ?, kusy = ?, "
                + "suma = ? WHERE id = ?";
        jdbcTemplate.update(sql, prijem.getPopis(), prijem.getDatum(),
                prijem.getProduktId(), prijem.getPrevadzkaId(), prijem.getZlava(), 
                prijem.getKusy(), prijem.getSuma(), prijem.getId());
    }

    @Override
    public void delete(PrijemZProdukty prijem) {
        String sql = "DELETE FROM " + getTableName().toString() + " WHERE id=" + prijem.getId();
        jdbcTemplate.execute(sql);
    }

    // todo manager layer
    @Override
    public double getSuma(PrijemZProdukty prijem) {

        ProduktDao produktDao = DaoFactory.INSTANCE.getProduktDao();
        Long produktId = prijem.getProduktId();
        Produkt produkt = produktDao.getById(produktId);

        if (produkt == null) {
            ProduktHistoryDao produktHistoryDao = DaoFactory.INSTANCE.getProduktHistoryDao();
            produkt = produktHistoryDao.getById(produktId);
        }

        int kusy = prijem.getKusy();
        double zlava = prijem.getZlava();

        return (produkt.getPredajnaCena() * (1 - (zlava / 100))) * kusy;

//        
//        ProduktNaPredajniDao produktNaPredajniDao = DaoFactory.INSTANCE.getProduktNaPredajniDao();
//        ProduktNaPredajni produktNaPredajni = produktNaPredajniDao.getById(prijem.getProduktId(), prijem.getPrevadzkaId());
//
//        int count = produktNaPredajni.getKusy();
//        double zlava = produktNaPredajni.getZlava();
//
//        ProduktDao produktDao = DaoFactory.INSTANCE.getProduktDao();
//        Produkt produkt = produktDao.getById(produktNaPredajni.getProduktId());
//
    }

    @Override
    public double getSuma(Long prevadzkaId) {
        List<PrijemZProdukty> prijmy = getPrijmyByPrevadzka(prevadzkaId);
        double result = 0;
        for (PrijemZProdukty prijem : prijmy) {
            result += prijem.getSuma();
        }
        return result;
    }

    private class PrijemRowMapper implements RowMapper<PrijemZProdukty> {

        @Override
        public PrijemZProdukty mapRow(ResultSet rs, int i) throws SQLException {
            PrijemZProdukty prijem = new PrijemZProdukty();
            prijem.setId(rs.getLong("id"));
            prijem.setPopis(rs.getString("popis"));
            prijem.setDatum(rs.getDate("datum"));
            prijem.setProduktId(rs.getLong("produkt_id"));
            prijem.setPrevadzkaId(rs.getLong("prevadzka_id"));
            prijem.setKusy(rs.getInt("kusy"));
            prijem.setZlava(rs.getDouble("Zlava"));
            prijem.setSuma(rs.getDouble("suma"));

            return prijem;
        }
    }
}
