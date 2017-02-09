package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.DodavatelDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Dodavatel;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class DodavatelDaoImplTest {

    private DodavatelDao instance = DaoFactory.INSTANCE.getDodavatelDao();

    /**
     * Test of getDodavatelia method, of class DodavatelDaoImpl.
     */
    @Test
    public void testGetDodavatelia() {
        System.out.println("getDodavatelia");
        List<Dodavatel> expResult = null;
        List<Dodavatel> result = instance.getDodavatelia();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getById method, of class DodavatelDaoImpl.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        
        Dodavatel expResult = null;
        Dodavatel result = instance.getById(0L);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveOrEdit method, of class DodavatelDaoImpl.
     */
    @Test
    public void testSaveOrEdit() {
        System.out.println("saveOrEdit");
        Dodavatel dodavatel = new Dodavatel(null, "Test", "Test", "Test");

        List<Dodavatel> before = instance.getDodavatelia();
        instance.saveOrEdit(dodavatel);
        List<Dodavatel> after = instance.getDodavatelia();
        instance.delete(dodavatel);
        assertEquals(before.size() + 1, after.size());
    }

    /**
     * Test of delete method, of class DodavatelDaoImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        List<Dodavatel> dodavatelia = instance.getDodavatelia();
        instance.delete(dodavatelia.get(dodavatelia.size() - 1));
        List<Dodavatel> result = instance.getDodavatelia();
        assertEquals(result.size(), dodavatelia.size() - 1);
    }

}
