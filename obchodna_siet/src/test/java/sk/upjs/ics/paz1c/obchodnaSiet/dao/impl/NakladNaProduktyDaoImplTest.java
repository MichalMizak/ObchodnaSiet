package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.NakladNaProduktyDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrijemDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktNaPredajniDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.NakladNaProdukty;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.NakladNaProdukty
        ;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.ProduktNaPredajni;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class NakladNaProduktyDaoImplTest {

    private final NakladNaProduktyDao prijemDao;

    private static final Long EXISTING_PRODUKT_ID = 115L;
    private static final Long EXISTING_PREVADZKA_ID = 266L;

    public NakladNaProduktyDaoImplTest() {
        prijemDao = DaoFactory.INSTANCE.getNakladNaProduktyDao();
    }

    /**
     * Test of save method, of class PrijemDaoImpl.
     */
    @Test
    public void testPridajPrijem() {
        int pocetPred = prijemDao.getPrijmy().size();

        ProduktNaPredajniDao produktNaPredajniDao = DaoFactory.INSTANCE.getProduktNaPredajniDao();
        produktNaPredajniDao.saveOrEdit(new ProduktNaPredajni(EXISTING_PRODUKT_ID, EXISTING_PREVADZKA_ID, 0, 0));
        ProduktNaPredajni produkt = produktNaPredajniDao.getById(EXISTING_PRODUKT_ID, EXISTING_PREVADZKA_ID);

        prijemDao.save(new NakladNaProdukty
        (null, "TEST",
                new Date(System.currentTimeMillis()), produkt.getProduktId(),
                produkt.getPrevadzkaId(), 0, 0));

        int pocetPo = prijemDao.getPrijmy().size();

        List<NakladNaProdukty
                > prijmy = prijemDao.getPrijmy();
        NakladNaProdukty
                prijem = prijmy.get(prijmy.size() - 1);
        prijemDao.delete(prijem);
        produktNaPredajniDao.delete(EXISTING_PRODUKT_ID, EXISTING_PREVADZKA_ID);

        assertEquals(pocetPred + 1, pocetPo);
    }

    /**
     * Test of getById method, of class PrijemDaoImpl.
     */
    @Test
    public void testNacitajPrijem() {
        ProduktNaPredajniDao produktNaPredajniDao = DaoFactory.INSTANCE.getProduktNaPredajniDao();
        produktNaPredajniDao.saveOrEdit(new ProduktNaPredajni(EXISTING_PRODUKT_ID, EXISTING_PREVADZKA_ID, 0, 0));
        ProduktNaPredajni produkt = produktNaPredajniDao.getById(EXISTING_PRODUKT_ID, EXISTING_PREVADZKA_ID);

        prijemDao.save(new NakladNaProdukty
        (null, "TEST",
                new Date(System.currentTimeMillis()), produkt.getProduktId(),
                produkt.getPrevadzkaId(), 0, 0));

        List<NakladNaProdukty
                > prijmy = prijemDao.getPrijmy();
        NakladNaProdukty
                prijemToDelete = prijmy.get(prijmy.size() - 1);

        NakladNaProdukty
                prijem = prijemDao.getById(prijemToDelete.getId());

        prijemDao.delete(prijemToDelete);
        produktNaPredajniDao.delete(EXISTING_PRODUKT_ID, EXISTING_PREVADZKA_ID);

        assertTrue(prijem != null);
        assertTrue(Objects.equals(prijem.getPrevadzkaId(), produkt.getPrevadzkaId()));
        assertTrue(prijem.getPopis().equals("TEST"));
    }

    /**
     * Test of getPrijmy method, of class PrijemDaoImpl.
     */
    @Test
    public void testNacitajVsetkyPrijmy() {
        List<NakladNaProdukty
                > prijmy = prijemDao.getPrijmy();
        assertTrue(prijmy != null);
    }

    // TODO
//    /**
//     * Test of edit method, of class PrijemDaoImpl.
//     */
//    @Test
//    public void testUpravPrijem() {
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of delete method, of class PrijemDaoImpl.
     */
    @Test
    public void testOdoberPrijem() {

        ProduktNaPredajniDao produktNaPredajniDao = DaoFactory.INSTANCE.getProduktNaPredajniDao();
        produktNaPredajniDao.saveOrEdit(new ProduktNaPredajni(EXISTING_PRODUKT_ID, EXISTING_PREVADZKA_ID, 0, 0));
        ProduktNaPredajni produkt = produktNaPredajniDao.getById(EXISTING_PRODUKT_ID, EXISTING_PREVADZKA_ID);

        prijemDao.save(new NakladNaProdukty
        (null, "TEST",
                new Date(System.currentTimeMillis()), produkt.getProduktId(),
                produkt.getPrevadzkaId(), 0, 0));

        List<NakladNaProdukty
                > prijmy = prijemDao.getPrijmy();
        NakladNaProdukty
                prijem = prijmy.get(prijmy.size() - 1);
        int pocetPred = prijmy.size();

        prijemDao.delete(prijem);
        produktNaPredajniDao.delete(EXISTING_PRODUKT_ID, EXISTING_PREVADZKA_ID);

        int pocetPo = prijemDao.getPrijmy().size();

        assertTrue(pocetPred - 1 == pocetPo);
    }

}
