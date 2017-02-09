package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.NakladNaProduktyDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.NakladNaProdukty;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;


public class NakladNaProduktyTableModel extends AbstractTableModel {
    
    private static final String[] COLUMN_TITLES = {"Popis", "Suma", "Dátum", "Prevádzka", "Produkt"};

    private static final int COLUMN_COUNT = COLUMN_TITLES.length;

    private List<NakladNaProdukty> naklady;

    private NakladNaProduktyDao prijemDao = DaoFactory.INSTANCE.getNakladNaProduktyDao();
    private PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
    private ProduktDao produktDao = DaoFactory.INSTANCE.getProduktDao();

    public NakladNaProduktyTableModel(List<NakladNaProdukty> naklady) {
        this.naklady = naklady;
    }

    @Override
    public int getRowCount() {
        return naklady == null ? 0 : naklady.size();
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
        NakladNaProdukty prijem = naklady.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return prijem.getPopis();
            case 1:
                return prijem.getSuma();
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

    public void refresh(List<NakladNaProdukty> naklady) {
        this.naklady = naklady;
        fireTableDataChanged();
    }

    public NakladNaProdukty getItemAt(int selectedRow) {
        return naklady.get(selectedRow);
    }
}

