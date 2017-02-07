package sk.upjs.ics.paz1c.obchodnaSiet.dao.backupable;

import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.TableName;

/**
 *
 * @author Mikey
 */
public class Backupable {

    private TableName tableName;

    protected final void setTableName(TableName tableName) {
        this.tableName = tableName;
    }

    protected final TableName getTableName() {
        return tableName;
    }
}
