package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.NastaveniaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Nastavenia;

public class NastaveniaDaoImpl implements NastaveniaDao {

    private final JdbcTemplate jdbcTemplate;
    private static final Long NASTAVENIA_DEFAULT = 1L;

    public NastaveniaDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // defaultne nastavenia su v db, daju sa len updatovat
    @Override
    public void pridajUpravNastavenia(Nastavenia nastavenia) {
        String sql = "UPDATE nastavenia SET nazov_obchodnej_siete=?, mena=? WHERE id="+NASTAVENIA_DEFAULT;
        jdbcTemplate.update(sql, nastavenia.getNazovObchodnejSiete(), nastavenia.getMena());
    }

    @Override
    public Nastavenia nacitajNastavenia(Long id) {
        String sql = "SELECT * FROM nastavenia n WHERE n.id="+NASTAVENIA_DEFAULT;
        BeanPropertyRowMapper<Nastavenia> rowMapper = new BeanPropertyRowMapper<>(Nastavenia.class);
        return jdbcTemplate.queryForObject(sql, rowMapper);
    }

}
