package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import java.util.List;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktNaPredajniDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.ProduktNaPredajni;

public class ProduktNaPredajniDaoImplTest {

    private final ProduktNaPredajniDao produktNaPredajniDao;

    public ProduktNaPredajniDaoImplTest() {
        produktNaPredajniDao = DaoFactory.INSTANCE.getProduktNaPredajniDao();
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
     * Test of saveOrEdit method, of class
 ProduktNaPredajniDaoImpl.
     */
    @Test
    public void testPridajProduktNaPredajnu() {
        int pocetPred = produktNaPredajniDao.getProduktyNaPredajni().size();

        ProduktDao produktDao = DaoFactory.INSTANCE.getProduktDao();
        produktDao.save(new Produkt("TEST", 0, 0, 1L));
        List<Produkt> produkty = produktDao.getProdukty();
        Long idProduktu = produkty.get(produkty.size() - 1).getId();

        PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        List<Prevadzka> prevadzky = prevadzkaDao.getPrevadzky();
        Long idPrevadzky = prevadzky.get(prevadzky.size() - 1).getId();

        produktNaPredajniDao.saveOrEdit(new ProduktNaPredajni(idProduktu, idPrevadzky, 0, 0));

        int pocetPo = produktNaPredajniDao.getProduktyNaPredajni().size();

        produktNaPredajniDao.delete(idProduktu, idPrevadzky);
        produktDao.delete(idProduktu);
        prevadzkaDao.delete(idPrevadzky);

        assertEquals(pocetPred + 1, pocetPo);
    }

    /**
     * Test of getById method, of class
 ProduktNaPredajniDaoImpl.
     */
    @Test
    public void testNacitajProduktNaPredajni() {
        ProduktDao produktDao = DaoFactory.INSTANCE.getProduktDao();
        produktDao.save(new Produkt("TEST", 0, 0, 1L));
        List<Produkt> produkty = produktDao.getProdukty();
        Long idProduktu = produkty.get(produkty.size() - 1).getId();

        PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        List<Prevadzka> prevadzky = prevadzkaDao.getPrevadzky();
        Long idPrevadzky = prevadzky.get(prevadzky.size() - 1).getId();

        produktNaPredajniDao.saveOrEdit(new ProduktNaPredajni(idProduktu, idPrevadzky, 0, 0));

        List<ProduktNaPredajni> produktyNaPredajni = produktNaPredajniDao.getProduktyNaPredajni();
        ProduktNaPredajni pnp = produktNaPredajniDao.getById(idProduktu, idPrevadzky);
        double zlava = pnp.getZlava();
        int kusy = pnp.getKusy();

        produktNaPredajniDao.delete(idProduktu, idPrevadzky);
        produktDao.delete(idProduktu);
        prevadzkaDao.delete(idPrevadzky);

        assertTrue(pnp != null && 0.0 == zlava && 0 == kusy);
    }

    /**
     * Test of getProduktyNaPredajni method, of class
 ProduktNaPredajniDaoImpl.
     */
    @Test
    public void testNacitajVsetkyProduktyNaPredajniach() {
        List<ProduktNaPredajni> produktyNaPredajni = produktNaPredajniDao.getProduktyNaPredajni();
        assertTrue(produktyNaPredajni != null);
    }

    // TODO
//    /**
//     * Test of upravProduktNaPredajni method, of class ProduktNaPredajniDaoImpl.
//     */
//    @Test
//    public void testUpravProduktNaPredajni() {
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of delete method, of class ProduktNaPredajniDaoImpl.
     */
    @Test
    public void testOdoberProduktZPredajne() {
        ProduktDao produktDao = DaoFactory.INSTANCE.getProduktDao();
        produktDao.save(new Produkt("TEST", 0, 0, 1L));
        List<Produkt> produkty = produktDao.getProdukty();
        Long idProduktu = produkty.get(produkty.size() - 1).getId();

        PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
        prevadzkaDao.saveOrEdit(new Prevadzka("TEST", "TEST", "TEST"));
        List<Prevadzka> prevadzky = prevadzkaDao.getPrevadzky();
        Long idPrevadzky = prevadzky.get(prevadzky.size() - 1).getId();

        produktNaPredajniDao.saveOrEdit(new ProduktNaPredajni(idProduktu, idPrevadzky, 0, 0));

        int pocetPred = produktNaPredajniDao.getProduktyNaPredajni().size();

        produktNaPredajniDao.delete(idProduktu, idPrevadzky);

        int pocetPo = produktNaPredajniDao.getProduktyNaPredajni().size();

        produktDao.delete(idProduktu);
        prevadzkaDao.delete(idPrevadzky);

        assertEquals(pocetPred - 1, pocetPo);
    }

}
