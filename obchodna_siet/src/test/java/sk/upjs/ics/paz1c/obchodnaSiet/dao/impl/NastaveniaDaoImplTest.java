package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.NastaveniaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Nastavenia;

public class NastaveniaDaoImplTest {

    private final NastaveniaDao nastaveniaDao;

    public NastaveniaDaoImplTest() {
        nastaveniaDao = DaoFactory.INSTANCE.getNastaveniaDao();
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
     * Test of pridajUpravNastavenia method, of class NastaveniaDaoImpl.
     */
    @Test
    public void testPridajUpravNastavenia() {
        // len upravenie nastaveni je mozne

        Nastavenia nastavenia = nastaveniaDao.nacitajNastavenia(1L);
        String povodnyNazov = nastavenia.getNazovObchodnejSiete();
        String povodnaMena = nastavenia.getMena();

        nastaveniaDao.pridajUpravNastavenia(new Nastavenia("TEST", "TEST"));
        Nastavenia noveNastavenia = nastaveniaDao.nacitajNastavenia(1L);
        String novyNazov = noveNastavenia.getNazovObchodnejSiete();
        String novaMena = noveNastavenia.getMena();

        // vratenie do povodneho stavu
        nastaveniaDao.pridajUpravNastavenia(new Nastavenia(povodnyNazov, povodnaMena));

        assertTrue(!povodnyNazov.equals(novyNazov) && !povodnaMena.equals(novaMena));
    }

    /**
     * Test of nacitajNastavenia method, of class NastaveniaDaoImpl.
     */
    @Test
    public void testNacitajNastavenia() {
        Nastavenia nastavenia = nastaveniaDao.nacitajNastavenia(1L);
        assertTrue(nastavenia != null);
    }

}
