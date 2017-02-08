package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrijemDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prijem;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class PrijemTableModel extends AbstractTableModel {

    private static final String[] COLUMN_TITLES = {"Popis", "Suma", "Dátum", "Prevádzka", "Produkt"};

    private static final int COLUMN_COUNT = COLUMN_TITLES.length;

    private static final String NEPRIRADENY_MESSAGE = "Nepriradený";

    private List<Prijem> prijmy;

    private PrijemDao prijemDao = DaoFactory.INSTANCE.getPrijemDao();
    private PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
    private ProduktDao produktDao = DaoFactory.INSTANCE.getProduktDao();

    public PrijemTableModel(List<Prijem> prijmy) {
        this.prijmy = prijmy;
    }

    @Override
    public int getRowCount() {
        return prijmy == null ? 0 : prijmy.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMN_TITLES[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prijem prijem = prijmy.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return prijem.getPopis();
            case 1:
                return prijemDao.getSuma(prijem);
            case 2:
                return prijem.getDatum().toString();
            case 3:
                return prevadzkaDao.getById(prijem.getPrevadzkaId()).getNazov();
            case 4:    
                return produktDao.getById(prijem.getProduktId()).getNazov();
            default:
                return null;
        }
    }

    public void refresh(List<Prijem> prijmy) {
        this.prijmy = prijmy;
        fireTableDataChanged();
    }

    public Prijem getItemAt(int selectedRow) {
        return prijmy.get(selectedRow);
    }
}
