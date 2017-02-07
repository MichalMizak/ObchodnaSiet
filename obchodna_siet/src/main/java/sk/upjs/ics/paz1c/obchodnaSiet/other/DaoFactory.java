package sk.upjs.ics.paz1c.obchodnaSiet.other;

import sk.upjs.ics.paz1c.obchodnaSiet.dao.impl.*;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.impl.history.PrevadzkaHistoryDaoImpl;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.impl.history.ProduktHistoryDaoImpl;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.history.PrevadzkaHistoryDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.history.ProduktHistoryDao;

public enum DaoFactory {

    INSTANCE;

    private NakladDao nakladDao;
    private NastaveniaDao nastaveniaDao;
    private PrevadzkaDao prevadzkaDao;
    private PrijemDao prijemDao;
    private ProduktDao produktDao;
    private ProduktNaPredajniDao produktNaPredajniDao;
    private ZamestnanecDao zamestnanecDao;

    private DodavatelDao dodavatelDao;
    private TransactionNumberDao transactionNumberDao;
    private ProduktHistoryDao produktHistoryDao;
    private PrevadzkaHistoryDao prevadzkaHistoryDao;
    
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            try {
                OracleDataSource dataSource = new OracleDataSource();
                dataSource.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
                dataSource.setUser("obchodna_siet");
                dataSource.setPassword("password");

                jdbcTemplate = new JdbcTemplate(dataSource);

                return jdbcTemplate;
            } catch (SQLException ex) {
                Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jdbcTemplate;
    }

    public NakladDao getNakladDao() {
        if (nakladDao == null) {
            nakladDao = new NakladDaoImpl(getJdbcTemplate());
        }
        return nakladDao;
    }

    public NastaveniaDao getNastaveniaDao() {
        if (nastaveniaDao == null) {
            nastaveniaDao = new NastaveniaDaoImpl(getJdbcTemplate());
        }
        return nastaveniaDao;
    }

    public PrevadzkaDao getPrevadzkaDao() {
        if (prevadzkaDao == null) {
            prevadzkaDao = new PrevadzkaDaoImpl(getJdbcTemplate());
        }
        return prevadzkaDao;
    }

    public PrijemDao getPrijemDao() {
        if (prijemDao == null) {
            prijemDao = new PrijemDaoImpl(getJdbcTemplate());
        }
        return prijemDao;
    }

    public ProduktDao getProduktDao() {
        if (produktDao == null) {
            produktDao = new ProduktDaoImpl(getJdbcTemplate());
        }
        return produktDao;
    }

    public ProduktNaPredajniDao getProduktNaPredajniDao() {
        if (produktNaPredajniDao == null) {
            produktNaPredajniDao = new ProduktNaPredajniDaoImpl(getJdbcTemplate());
        }
        return produktNaPredajniDao;
    }

    public ZamestnanecDao getZamestnanecDao() {
        if (zamestnanecDao == null) {
            zamestnanecDao = new ZamestnanecDaoImpl(getJdbcTemplate());
        }
        return zamestnanecDao;
    }

    public DodavatelDao getDodavatelDao() {
        if (dodavatelDao == null) {
            dodavatelDao = new DodavatelDaoImpl(getJdbcTemplate());
        }
        return dodavatelDao;
    }

    public TransactionNumberDao getTransactionNumberDao() {
        if (transactionNumberDao == null) {
            transactionNumberDao = new TransactionNumberDaoImpl();
        }
        return transactionNumberDao;
    }

    public ProduktHistoryDao getProduktHistoryDao() {
        if (produktHistoryDao == null) {
            produktHistoryDao = new ProduktHistoryDaoImpl(getJdbcTemplate());
        }
        return produktHistoryDao;
    }

    public PrevadzkaHistoryDao getPrevadzkaHistoryDao() {
        if (prevadzkaHistoryDao == null) {
            prevadzkaHistoryDao = new PrevadzkaHistoryDaoImpl(getJdbcTemplate());
        }
        return prevadzkaHistoryDao;
    }

}
