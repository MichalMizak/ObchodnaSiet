package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Naklad;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prijem;
import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.NakladDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrijemDao;

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

    /**
     * Test of vycisliZisk method, of class PrevadzkaDaoImpl.
     */
    //@Test
    // NOT FUNCTIONAL
    public void testVycisliZisk() {
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        List<Prevadzka> list = prevadzkaDao.getPrevadzky();
        Long id = list.get(list.size() - 1).getId();

        NakladDao nakladDao = DaoFactory.INSTANCE.getNakladDao();
        PrijemDao prijemDao = DaoFactory.INSTANCE.getPrijemDao();
        nakladDao.pridajNaklad(new Naklad(id, "TEST", new Date(System.currentTimeMillis()), 0));
        //prijemDao.save(new Prijem(id, "TEST", new Date(System.currentTimeMillis()), 0L));
//        prijemDao.save(new Prijem(null, "TEST",
//                new Date(System.currentTimeMillis()), produkt.getProduktId(),
//                produkt.getPrevadzkaId(), 0, 0));
        double ocakavanyZisk = 0;

        double vycislenyZisk = prevadzkaDao.vycisliZisk(id);

        List<Naklad> naklady = nakladDao.nacitajVsetkyNaklady();
        Long idNaklad = naklady.get(naklady.size() - 1).getId();
        nakladDao.odoberNaklad(idNaklad);
        List<Prijem> prijmy = prijemDao.nacitajVsetkyPrijmy();
        Prijem prijem = prijmy.get(prijmy.size() - 1);
        prijemDao.delete(prijem);
        prevadzkaDao.delete(id);

        assertTrue(ocakavanyZisk == vycislenyZisk);

    }

}
