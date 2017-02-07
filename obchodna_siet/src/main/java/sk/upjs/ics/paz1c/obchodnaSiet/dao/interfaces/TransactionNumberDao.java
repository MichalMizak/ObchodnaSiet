package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.DatabaseSequence;

/**
 *
 * @author Mikey
 */
public interface TransactionNumberDao {
    public Long getNextTransactionNumberFromSequence(DatabaseSequence sequence);
}
