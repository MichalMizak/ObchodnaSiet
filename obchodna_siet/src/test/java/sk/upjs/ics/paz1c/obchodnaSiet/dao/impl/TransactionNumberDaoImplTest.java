package sk.upjs.ics.paz1c.obchodnaSiet.dao.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.DatabaseSequence;

/**
 *
 * @author Mikey
 */
public class TransactionNumberDaoImplTest {

    /**
     * Test of getNextTransactionNumberFromSequence method, of class
     * TransactionNumberDaoImpl.
     */
    @Test
    public void testGetNextTransactionNumberFromSequence() {
        System.out.println("getNextTransactionNumberFromSequence");
        TransactionNumberDaoImpl instance = new TransactionNumberDaoImpl();
        Long expResult = null;
        Long result = instance.getNextTransactionNumberFromSequence(DatabaseSequence.dodavatel_sequence);
        assertNotEquals(expResult, result);
    }
}
