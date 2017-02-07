package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Dodavatel;

public class ProduktDaoImplTest {

    private final ProduktDao produktDao;
    private static final long EXISTING_DODAVATEL = 33L;

    public ProduktDaoImplTest() {
        produktDao = DaoFactory.INSTANCE.getProduktDao();
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
     * Test of save method, of class ProduktDaoImpl.
     */
    @Test
    public void testPridajProdukt() {
        int pocetPred = produktDao.getProdukty().size();
        produktDao.save(new Produkt("TEST", 0, 0, 33L));
        int pocetPo = produktDao.getProdukty().size();

        List<Produkt> list = produktDao.getProdukty();
        Long id = list.get(list.size() - 1).getId();
        produktDao.delete(id);

        assertEquals(pocetPred + 1, pocetPo);
    }

    /**
     * Test of getById method, of class ProduktDaoImpl.
     */
    @Test
    public void testNacitajProdukt() {
        produktDao.save(new Produkt("TEST", 0, 0, 33L));
        List<Produkt> list = produktDao.getProdukty();
        Long id = list.get(list.size() - 1).getId();

        Produkt produkt = produktDao.getById(id);

        produktDao.delete(id);

        assertTrue(produkt != null && produkt.getNazov().equals("TEST") && produkt.getNakupnaCena() == 0.0 && produkt.getPredajnaCena() == 0.0);
    }

    /**
     * Test of getProdukty method, of class ProduktDaoImpl.
     */
    @Test
    public void testNacitajVsetkyProdukty() {
        List<Produkt> nacitanyList = produktDao.getProdukty();
        assertTrue(nacitanyList != null);
    }

    // TODO
//    /**
//     * Test of edit method, of class ProduktDaoImpl.
//     */
//    @Test
//    public void testUpravProdukt() {
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of delete method, of class ProduktDaoImpl.
     */
    @Test
    public void testOdoberProdukt() {
        produktDao.save(new Produkt("TEST", 0, 0, 33L));
        int pocetPred = produktDao.getProdukty().size();

        List<Produkt> list = produktDao.getProdukty();
        Long id = list.get(list.size() - 1).getId();
        produktDao.delete(id);

        int pocetPo = produktDao.getProdukty().size();

        assertTrue(pocetPred - 1 == pocetPo);
    }

    /**
     * Test of vycisliZisk method, of class ProduktDaoImpl.
     */
    @Test
    public void testVycisliZisk() {
        produktDao.save(new Produkt("TEST", 0, 0, 33L));

        List<Produkt> list = produktDao.getProdukty();
        Long id = list.get(list.size() - 1).getId();

        double zisk = produktDao.vycisliZisk(id);

        produktDao.delete(id);

        assertTrue(zisk == 0.0);
    }

    @Test
    public void getByDodavatel() {
        Dodavatel dodavatel = new Dodavatel();
        dodavatel.setId(EXISTING_DODAVATEL);
        List<Produkt> list = produktDao.getByDodavatel(dodavatel);

        if (list != null && list.isEmpty()) {
            assertEquals(true, true);
        } else {
            assertEquals(list.get(0).getDodavatel_id(), dodavatel.getId());
        }
    }

}
