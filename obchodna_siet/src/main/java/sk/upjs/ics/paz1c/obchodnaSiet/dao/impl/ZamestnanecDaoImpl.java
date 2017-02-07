package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ZamestnanecDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Zamestnanec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.TransactionNumberDao;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.DatabaseSequence;

public class ZamestnanecDaoImpl implements ZamestnanecDao {

    private final JdbcTemplate jdbcTemplate;

    public ZamestnanecDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void pridajZamestnanca(Zamestnanec zamestnanec) {
        TransactionNumberDao transactionNumberDao = DaoFactory.INSTANCE.getTransactionNumberDao();

        Long generatedId = transactionNumberDao.getNextTransactionNumberFromSequence(DatabaseSequence.zamestnanec_sequence);
        zamestnanec.setId(generatedId);
        
        String sql = "INSERT INTO zamestnanec (id, meno, priezvisko, prevadzka_id, datum_nastupu, plat_brutto) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, zamestnanec.getId(), zamestnanec.getMeno(), zamestnanec.getPriezvisko(), zamestnanec.getPrevadzkaId(), zamestnanec.getDatumNastupu(), zamestnanec.getPlatBrutto());
    }

    @Override
    public Zamestnanec nacitajZamestnanca(Long id) {
        String sql = "SELECT z.id, z.meno, z.priezvisko, z.prevadzka_id, z.datum_nastupu,"
                + " z.plat_brutto from zamestnanec z WHERE z.id=?";
        return jdbcTemplate.queryForObject(sql, new ZamestnanecRowMapper(), id);
    }

    @Override
    public List<Zamestnanec> getZamestnanci() {
        String sql = "SELECT z.id, z.meno, z.priezvisko, z.prevadzka_id, z.datum_nastupu,"
                + " z.plat_brutto from zamestnanec z";
        return jdbcTemplate.query(sql, new ZamestnanecRowMapper());
    }

    @Override
    public List<Zamestnanec> getZamestnanecByPrevadzka(Long prevadzka_id) {
        String sql = "SELECT z.id, z.meno, z.priezvisko, z.prevadzka_id, z.datum_nastupu,"
                + " z.plat_brutto from zamestnanec z where z.prevadzka_id = ?";
        return jdbcTemplate.query(sql, new ZamestnanecRowMapper(), prevadzka_id);
    }

    // TODO
    /**
     * Upraví zamestnanca, nezmení však prevadzka_id
     *
     * @param zamestnanec
     */
    @Override
    public void upravZamestnanca(Zamestnanec zamestnanec) {
        String sql = "UPDATE zamestnanec SET meno = ?, priezvisko = ?,"
                + " datum_nastupu = ?, plat_brutto = ? WHERE id = ?";
        jdbcTemplate.update(sql, zamestnanec.getMeno(), zamestnanec.getPriezvisko(),
                zamestnanec.getDatumNastupu(), zamestnanec.getPlatBrutto(), zamestnanec.getId());
    }

    @Override
    public void odoberZamestnanca(Long id) {
        String sql = "DELETE FROM zamestnanec WHERE id=" + id;
        jdbcTemplate.execute(sql);
    }

    private class ZamestnanecRowMapper implements RowMapper<Zamestnanec> {

        @Override
        public Zamestnanec mapRow(ResultSet rs, int i) throws SQLException {
            Zamestnanec zamestnanec = new Zamestnanec();
            zamestnanec.setId(rs.getLong("id"));
            zamestnanec.setMeno(rs.getString("meno"));
            zamestnanec.setPriezvisko(rs.getString("priezvisko"));
            zamestnanec.setPrevadzkaId(rs.getLong("prevadzka_id"));
            zamestnanec.setDatumNastupu(rs.getDate("datum_nastupu"));
            zamestnanec.setPlatBrutto(rs.getDouble("plat_brutto"));
            return zamestnanec;
        }
    }
}
