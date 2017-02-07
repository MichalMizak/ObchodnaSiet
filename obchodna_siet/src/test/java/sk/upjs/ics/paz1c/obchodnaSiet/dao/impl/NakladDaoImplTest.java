package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.NakladDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Naklad;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NakladDaoImplTest {

    private final NakladDao nakladDao;

    public NakladDaoImplTest() {
        nakladDao = DaoFactory.INSTANCE.getNakladDao();
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
     * Test of pridajNaklad method, of class NakladDaoImpl.
     */
    @Test
    public void testPridajNaklad() {
        int pocetPred = nakladDao.nacitajVsetkyNaklady().size();

        PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        List<Prevadzka> prevadzky = prevadzkaDao.getPrevadzky();
        Long idPrevadzky = prevadzky.get(prevadzky.size() - 1).getId();

        nakladDao.pridajNaklad(new Naklad(idPrevadzky, "TEST", new Date(System.currentTimeMillis()), 0.0));

        int pocetPo = nakladDao.nacitajVsetkyNaklady().size();

        List<Naklad> naklady = nakladDao.nacitajVsetkyNaklady();
        Long idNaklad = naklady.get(naklady.size() - 1).getId();
        nakladDao.odoberNaklad(idNaklad);
        prevadzkaDao.delete(idPrevadzky);

        assertEquals(pocetPred + 1, pocetPo);
    }

    /**
     * Test of nacitajNaklad method, of class NakladDaoImpl.
     */
    @Test
    public void testNacitajNaklad() {
        PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        List<Prevadzka> prevadzky = prevadzkaDao.getPrevadzky();
        Long idPrevadzky = prevadzky.get(prevadzky.size() - 1).getId();

        nakladDao.pridajNaklad(new Naklad(idPrevadzky, "TEST", new Date(System.currentTimeMillis()), 0.0));

        List<Naklad> naklady = nakladDao.nacitajVsetkyNaklady();
        Long idNaklad = naklady.get(naklady.size() - 1).getId();

        Naklad naklad = nakladDao.nacitajNaklad(idNaklad);

        nakladDao.odoberNaklad(idNaklad);
        prevadzkaDao.delete(idPrevadzky);

        assertTrue(naklad != null && Objects.equals(naklad.getPrevadzkaId(), idPrevadzky) && naklad.getPopis().equals("TEST") && naklad.getSuma() == 0.0);
    }

    /**
     * Test of nacitajVsetkyNaklady method, of class NakladDaoImpl.
     */
    @Test
    public void testNacitajVsetkyNaklady() {
        List<Naklad> naklady = nakladDao.nacitajVsetkyNaklady();
        assertTrue(naklady != null);
    }

    // TODO
//    /**
//     * Test of upravNaklad method, of class NakladDaoImpl.
//     */
//    @Test
//    public void testUpravNaklad() {
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of odoberNaklad method, of class NakladDaoImpl.
     */
    @Test
    public void testOdoberNaklad() {
        PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        List<Prevadzka> prevadzky = prevadzkaDao.getPrevadzky();
        Long idPrevadzky = prevadzky.get(prevadzky.size() - 1).getId();

        nakladDao.pridajNaklad(new Naklad(idPrevadzky, "TEST", new Date(System.currentTimeMillis()), 0));

        List<Naklad> naklady = nakladDao.nacitajVsetkyNaklady();
        Long idNaklad = naklady.get(naklady.size() - 1).getId();
        int pocetPred = naklady.size();

        nakladDao.odoberNaklad(idNaklad);
        int pocetPo = nakladDao.nacitajVsetkyNaklady().size();

        prevadzkaDao.delete(idPrevadzky);

        assertTrue(pocetPred - 1 == pocetPo);
    }

}
