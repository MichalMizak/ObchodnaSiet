package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.StatnyPoplatokDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.StatnyPoplatok;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class StatnyPoplatokDaoImplTest {
    
    StatnyPoplatokDao statnyPoplatokDao = DaoFactory.INSTANCE.getStatnyPoplatokDao();
    
    public StatnyPoplatokDaoImplTest() {
    }
    
    /**
     * Test of saveOrEdit method, of class StatnyPoplatokDaoImpl.
     */
    @Test
    public void testAll() {
        System.out.println("saveOrEdit");
        StatnyPoplatok statnyPoplatok = new StatnyPoplatok(null, "TEST", 0);
        
        statnyPoplatokDao.saveOrEdit(statnyPoplatok);
        
        StatnyPoplatok statnyPoplatok2 = statnyPoplatokDao.getById(statnyPoplatok.getId());
        
        assertEquals(statnyPoplatok.getKrajina(), statnyPoplatok2.getKrajina());
        assertFalse(statnyPoplatokDao.getItems().isEmpty());
        statnyPoplatokDao.delete(statnyPoplatok.getId());
    }

    
}
