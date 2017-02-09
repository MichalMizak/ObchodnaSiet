package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.backupable.Backupable;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.NakladNaProduktyDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.TransactionNumberDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.history.ProduktHistoryDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.NakladNaProdukty;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.NakladNaProdukty;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.ProduktNaPredajni;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.DatabaseSequence;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.TableName;

/**
 *
 * @author Mikey
 */
public class NakladNaProduktyDaoImpl extends Backupable implements NakladNaProduktyDao {

    private final JdbcTemplate jdbcTemplate;

    public NakladNaProduktyDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        setTableName(TableName.naklad_na_produkty);
    }

    @Override
    public void save(NakladNaProdukty prijem) {
        TransactionNumberDao transactionNumberDao = DaoFactory.INSTANCE.getTransactionNumberDao();

        Long generatedId = transactionNumberDao.getNextTransactionNumberFromSequence(DatabaseSequence.prijem_sequence);
        prijem.setId(generatedId);

        String sql = "INSERT INTO " + getTableName().toString() + "(id, popis, "
                + "datum, produkt_id, prevadzka_id, zlava, kusy, suma) VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, prijem.getId(), prijem.getPopis(), prijem.getDatum(),
                prijem.getProduktId(), prijem.getPrevadzkaId(), prijem.getZlava(), prijem.getKusy(), prijem.getSuma());
    }

    @Override
    public NakladNaProdukty getById(Long id) {
        String sql = "SELECT p.id, p.popis, p.datum, p.produkt_id, p.prevadzka_id,"
                + " p.zlava, p.kusy, p.suma from " + getTableName().toString() + " p WHERE p.id=?";
        return jdbcTemplate.queryForObject(sql, new PrijemRowMapper(), id);
    }

    @Override
    public List<NakladNaProdukty> getPrijmy() {
        String sql = "SELECT p.id, p.popis, p.datum, p.produkt_id, p.prevadzka_id, "
                + "p.zlava, p.kusy, p.suma from " + getTableName().toString() + " p";
        return jdbcTemplate.query(sql, new PrijemRowMapper());
    }

    @Override
    public List<NakladNaProdukty> getPrijmyByPrevadzka(Long prevadzkaId) {
        String sql = "SELECT p.id, p.popis, p.datum, p.produkt_id, p.prevadzka_id,"
                + " p.zlava, p.kusy, p.suma from " + getTableName().toString() + " p "
                + "WHERE p.prevadzka_id = ?";
        return jdbcTemplate.query(sql, new PrijemRowMapper(), prevadzkaId);
    }

    // TODO
    @Override
    public void edit(NakladNaProdukty prijem) {
        String sql = "UPDATE " + getTableName().toString() + " SET popis = ?, "
                + "datum = ?, produkt_id = ?, prevadzka_id = ?, zlava = ?, kusy = ?, "
                + "suma = ? WHERE id = ?";
        jdbcTemplate.update(sql, prijem.getPopis(), prijem.getDatum(),
                prijem.getProduktId(), prijem.getPrevadzkaId(), prijem.getZlava(),
                prijem.getKusy(), prijem.getSuma(), prijem.getId());
    }

    @Override
    public void delete(NakladNaProdukty prijem) {
        String sql = "DELETE FROM " + getTableName().toString() + " WHERE id=" + prijem.getId();
        jdbcTemplate.execute(sql);
    }

    // todo manager layer
    @Override
    public double getSuma(NakladNaProdukty prijem) {

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
    }

    @Override
    public double getSuma(Long prevadzkaId) {
        List<NakladNaProdukty> naklady = getPrijmyByPrevadzka(prevadzkaId);
        double result = 0;
        for (NakladNaProdukty prijem : naklady) {
            result += prijem.getSuma();
        }
        return result;
    }

    @Override
    public NakladNaProdukty createNaklad(ProduktNaPredajni pnp) {
        NakladNaProdukty naklad = new NakladNaProdukty(null, "Pridávanie produktu na prevádzku",
                new Date(0), pnp.getProduktId(), pnp.getPrevadzkaId(), pnp.getKusy(), (int) pnp.getZlava());

        naklad.setSuma(getSuma(naklad));
        
        return naklad;
    }

    private class PrijemRowMapper implements RowMapper<NakladNaProdukty> {

        @Override
        public NakladNaProdukty mapRow(ResultSet rs, int i) throws SQLException {
            NakladNaProdukty naklad = new NakladNaProdukty();
            naklad.setId(rs.getLong("id"));
            naklad.setPopis(rs.getString("popis"));
            naklad.setDatum(rs.getDate("datum"));
            naklad.setProduktId(rs.getLong("produkt_id"));
            naklad.setPrevadzkaId(rs.getLong("prevadzka_id"));
            naklad.setKusy(rs.getInt("kusy"));
            naklad.setZlava(rs.getDouble("Zlava"));
            naklad.setSuma(rs.getDouble("suma"));

            return naklad;
        }
    }

}
