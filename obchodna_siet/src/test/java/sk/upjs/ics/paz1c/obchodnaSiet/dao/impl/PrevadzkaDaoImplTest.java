package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrevadzkaDaoImplTest {

    private final PrevadzkaDao prevadzkaDao;

    public PrevadzkaDaoImplTest() {
        prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
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
     * Test of saveOrEdit method, of class PrevadzkaDaoImpl.
     */
    @Test
    public void testPridajPrevadzku() {
        int pocetPred = prevadzkaDao.getPrevadzky().size();
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        int pocetPo = prevadzkaDao.getPrevadzky().size();

        List<Prevadzka> list = prevadzkaDao.getPrevadzky();
        Long id = list.get(list.size() - 1).getId();
        prevadzkaDao.delete(id);

        assertEquals(pocetPred + 1, pocetPo);
    }

    /**
     * Test of getById method, of class PrevadzkaDaoImpl.
     */
    @Test
    public void testNacitajPrevadzku() {
        PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        List<Prevadzka> prevadzky = prevadzkaDao.getPrevadzky();
        Long idPrevadzky = prevadzky.get(prevadzky.size() - 1).getId();

        Prevadzka prevadzka = prevadzkaDao.getById(idPrevadzky);

        prevadzkaDao.delete(idPrevadzky);

        assertTrue(prevadzka != null && prevadzka.getNazov().equals("TEST") && prevadzka.getAdresa().equals("TEST") && prevadzka.getOtvaracieHodiny().equals("TEST"));
    }

    /**
     * Test of nacitajVsetkyPrevadzky method, of class PrevadzkaDaoImpl.
     */
    @Test
    public void testNacitajVsetkyPrevadzky() {
        List<Prevadzka> zoznamPrevadzok = prevadzkaDao.getPrevadzky();
        assertFalse(zoznamPrevadzok == null);
    }

    // TODO
//    /**
//     * Test of upravPrevadzku method, of class PrevadzkaDaoImpl.
//     */
//    @Test
//    public void testUpravPrevadzku() {
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of delete method, of class PrevadzkaDaoImpl.
     */
    @Test
    public void testOdoberPrevadzku() {
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        int pocetPred = prevadzkaDao.getPrevadzky().size();

        List<Prevadzka> list = prevadzkaDao.getPrevadzky();
        Long id = list.get(list.size() - 1).getId();
        prevadzkaDao.delete(id);

        int pocetPo = prevadzkaDao.getPrevadzky().size();

        assertTrue(pocetPred - 1 == pocetPo);
    }
}
