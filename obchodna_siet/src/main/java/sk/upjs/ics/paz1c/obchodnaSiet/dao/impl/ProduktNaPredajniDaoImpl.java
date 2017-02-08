package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktNaPredajniDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.ProduktNaPredajni;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prijem;

public class ProduktNaPredajniDaoImpl implements ProduktNaPredajniDao {

    private final JdbcTemplate jdbcTemplate;

    public ProduktNaPredajniDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Ak uz takyto produkt existuje, nastavi zlavu na novu hodnotu a pripocita
     * kusy ku predoslej hodnote
     *
     * @param pnp
     */
    @Override
    public void saveOrEdit(ProduktNaPredajni pnp) {
        ProduktNaPredajni produkt = getById(pnp.getProduktId(), pnp.getPrevadzkaId());

        if (produkt == null) {
            String sql = "INSERT INTO produkt_na_predajni (produkt_id, prevadzka_id, zlava, kusy) VALUES (?,?,?,?)";
            jdbcTemplate.update(sql, pnp.getProduktId(), pnp.getPrevadzkaId(), pnp.getZlava(), pnp.getKusy());
        } else {
            String sql = "UPDATE produkt_na_predajni SET zlava = ?, kusy = ? "
                    + "WHERE produkt_id = ? AND prevadzka_id = ?";
            jdbcTemplate.update(sql, pnp.getZlava(), produkt.getKusy() + pnp.getKusy(),
                    pnp.getProduktId(), pnp.getPrevadzkaId());
        }
    }

    @Override
    public ProduktNaPredajni getById(Long produktId, Long prevadzkaId) {
        String sql = "SELECT * FROM produkt_na_predajni WHERE produkt_id=? AND prevadzka_id=?";
        BeanPropertyRowMapper<ProduktNaPredajni> rowMapper = new BeanPropertyRowMapper<>(ProduktNaPredajni.class);
        List<ProduktNaPredajni> result = jdbcTemplate.query(sql, rowMapper, produktId, prevadzkaId);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<ProduktNaPredajni> getProduktyNaPredajni() {
        String sql = "SELECT * FROM produkt_na_predajni";
        BeanPropertyRowMapper<ProduktNaPredajni> rowMapper = new BeanPropertyRowMapper<>(ProduktNaPredajni.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<ProduktNaPredajni> getByPrevadzka(Long prevadzkaId) {
        String sql = "SELECT * FROM produkt_na_predajni WHERE prevadzka_id=?";
        BeanPropertyRowMapper<ProduktNaPredajni> rowMapper = new BeanPropertyRowMapper<>(ProduktNaPredajni.class);
        List<ProduktNaPredajni> result = jdbcTemplate.query(sql, rowMapper, prevadzkaId);
        return result;
    }

    @Override
    public void delete(Long produktId, Long prevadzkaId) {
        String sql = "DELETE FROM produkt_na_predajni WHERE produkt_id=" + produktId + " AND prevadzka_id=" + prevadzkaId;
        jdbcTemplate.execute(sql);
    }
}
