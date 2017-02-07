package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import java.sql.Date;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ZamestnanecDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Zamestnanec;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ZamestnanecDaoImplTest {

    private final ZamestnanecDao zamestnanecDao;

    public ZamestnanecDaoImplTest() {
        zamestnanecDao = DaoFactory.INSTANCE.getZamestnanecDao();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of pridajZamestnanca method, of class ZamestnanecDaoImpl.
     */
    @Test
    public void testPridajZamestnanaca() {
        int pocetPred = zamestnanecDao.getZamestnanci().size();

        PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        List<Prevadzka> prevadzky = prevadzkaDao.getPrevadzky();
        Long idPrevadzky = prevadzky.get(prevadzky.size() - 1).getId();

        zamestnanecDao.pridajZamestnanca(new Zamestnanec("TEST", "TEST", idPrevadzky, new Date(System.currentTimeMillis()), 0.0));

        int pocetPo = zamestnanecDao.getZamestnanci().size();

        List<Zamestnanec> zamestnanci = zamestnanecDao.getZamestnanci();
        Long idZamestnanec = zamestnanci.get(zamestnanci.size() - 1).getId();
        zamestnanecDao.odoberZamestnanca(idZamestnanec);
        prevadzkaDao.delete(idPrevadzky);

        assertEquals(pocetPred + 1, pocetPo);
    }

    /**
     * Test of nacitajZamestnanca method, of class ZamestnanecDaoImpl.
     */
    @Test
    public void testNacitajZamestnanca() {
        PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        List<Prevadzka> prevadzky = prevadzkaDao.getPrevadzky();
        Long idPrevadzky = prevadzky.get(prevadzky.size() - 1).getId();

        zamestnanecDao.pridajZamestnanca(new Zamestnanec("TEST", "TEST", idPrevadzky, new Date(System.currentTimeMillis()), 0.0));
        List<Zamestnanec> zamestnanci = zamestnanecDao.getZamestnanci();
        Long idZamestnanec = zamestnanci.get(zamestnanci.size() - 1).getId();

        Zamestnanec z = zamestnanecDao.nacitajZamestnanca(idZamestnanec);

        zamestnanecDao.odoberZamestnanca(idZamestnanec);
        prevadzkaDao.delete(idPrevadzky);

        assertTrue(z != null && z.getMeno().equals("TEST") && z.getPriezvisko().equals("TEST") && z.getPrevadzkaId().equals(idPrevadzky) && z.getPlatBrutto() == 0.0);
    }

    /**
     * Test of getZamestnanci method, of class ZamestnanecDaoImpl.
     */
    @Test
    public void testNacitajVsetkychZamestnancov() {
        List<Zamestnanec> zamestnanci = zamestnanecDao.getZamestnanci();
        assertTrue(zamestnanci != null);
    }

    // TODO
//    /**
//     * Test of upravZamestnanca method, of class ZamestnanecDaoImpl.
//     */
//    @Test
//    public void testUpravZamestnanca() {
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of odoberZamestnanca method, of class ZamestnanecDaoImpl.
     */
    @Test
    public void testOdoberZamestnanca() {
        PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        List<Prevadzka> prevadzky = prevadzkaDao.getPrevadzky();
        Long idPrevadzky = prevadzky.get(prevadzky.size() - 1).getId();

        zamestnanecDao.pridajZamestnanca(new Zamestnanec("TEST", "TEST", idPrevadzky, new Date(System.currentTimeMillis()), 0.0));

        List<Zamestnanec> zamestnanci = zamestnanecDao.getZamestnanci();
        Long idZamestnanec = zamestnanci.get(zamestnanci.size() - 1).getId();
        int pocetPred = zamestnanci.size();

        zamestnanecDao.odoberZamestnanca(idZamestnanec);
        int pocetPo = zamestnanecDao.getZamestnanci().size();

        prevadzkaDao.delete(idPrevadzky);

        assertEquals(pocetPred - 1, pocetPo);
    }

}
