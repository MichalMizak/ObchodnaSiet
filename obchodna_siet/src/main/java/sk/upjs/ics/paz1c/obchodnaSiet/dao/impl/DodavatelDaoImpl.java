package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.DodavatelDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktNaPredajniDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.TransactionNumberDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Dodavatel;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.ProduktNaPredajni;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.DatabaseSequence;

/**
 *
 * @author Mikey
 */
public class DodavatelDaoImpl implements DodavatelDao {

    private final JdbcTemplate jdbcTemplate;

    public DodavatelDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Dodavatel> getDodavatelia() {
        // String sql = "SELECT id as dodavatel_id, nazov dodavatel_nazov,sidlo dodavatel_sidlo, kontakt dodavatel_kontakt, statny_poplatok_id as dodavatel_statny_poplatok_id from dodavatel";
        // return jdbcTemplate.query(sql, new DodavatelRowMapper());
        String sql = "SELECT * from dodavatel";
        BeanPropertyRowMapper<Dodavatel> rowMapper = new BeanPropertyRowMapper<>(Dodavatel.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Dodavatel getById(Long id) {
        String sql = "SELECT id as dodavatel_id, nazov dodavatel_nazov,sidlo dodavatel_sidlo, kontakt dodavatel_kontakt, statny_poplatok_id as dodavatel_statny_poplatok_id from dodavatel where id = ?";

        List<Dodavatel> dodavatelia = jdbcTemplate.query(sql, new DodavatelRowMapper(), id);

        if (dodavatelia.isEmpty()) {
            return null;
        } else {
            return dodavatelia.get(0);
        }
    }

    @Override
    public void saveOrEdit(Dodavatel dodavatel) {
        if (dodavatel.getId() == null) {
            // (id, nazov, sidlo, kontakt)
            TransactionNumberDao transactionNumberDao = DaoFactory.INSTANCE.getTransactionNumberDao();
            Long generatedId = transactionNumberDao.getNextTransactionNumberFromSequence(DatabaseSequence.dodavatel_sequence);
            dodavatel.setId(generatedId);

            String sql = "INSERT INTO dodavatel VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, dodavatel.getId(), dodavatel.getNazov(), dodavatel.getSidlo(), dodavatel.getKontakt(), dodavatel.getStatnyPoplatokId());

        } else {
            String sql = "UPDATE dodavatel SET nazov = ?, sidlo = ?, kontakt = ?, statny_poplatok_id = ? "
                    + " where id = ?";

            jdbcTemplate.update(sql, dodavatel.getNazov(), dodavatel.getSidlo(),
                    dodavatel.getKontakt(), dodavatel.getStatnyPoplatokId(), dodavatel.getId());
        }
    }

    @Override
    public void delete(Dodavatel dodavatel) {
        String sql = "DELETE FROM dodavatel WHERE id = ?";
        jdbcTemplate.update(sql, dodavatel.getId());
    }

    @Override
    public double podielNaPonukeTrhu(Dodavatel dodavatel) {
        ProduktDao produktDao = DaoFactory.INSTANCE.getProduktDao();
        List<Produkt> dodavatelia = produktDao.getByDodavatel(dodavatel);
        List<Produkt> vsetky = produktDao.getProdukty();
        return 100 * (dodavatelia.size() * 1.0) / vsetky.size();
    }

    @Override
    public double podielNaObchodnejSieti(Dodavatel dodavatel) {
        ProduktNaPredajniDao produktDao = DaoFactory.INSTANCE.getProduktNaPredajniDao();
        List<ProduktNaPredajni> dodavatelia = produktDao.getByDodavatel(dodavatel);
        List<ProduktNaPredajni> vsetky = produktDao.getProduktyNaPredajni();

        int allCount = 0;

        for (ProduktNaPredajni produktNaPredajni : vsetky) {
            allCount += produktNaPredajni.getKusy();
        }
        int dodavatelCount = 0;

        for (ProduktNaPredajni produktNaPredajni : dodavatelia) {
            dodavatelCount += produktNaPredajni.getKusy();
        }
        return 100 * (dodavatelCount * 1.0) / allCount;
    }

    private class DodavatelRowMapper implements RowMapper<Dodavatel> {

        @Override
        public Dodavatel mapRow(ResultSet rs, int i) throws SQLException {
            Dodavatel dodavatel = new Dodavatel();
            dodavatel.setId(rs.getLong("dodavatel_id"));
            dodavatel.setNazov(rs.getString("dodavatel_nazov"));
            dodavatel.setSidlo(rs.getString("dodavatel_sidlo"));
            dodavatel.setKontakt(rs.getString("dodavatel_kontakt"));
            dodavatel.setStatnyPoplatokId(rs.getLong("dodavatel_statny_poplatok_id"));
            return dodavatel;
        }
    }
}
