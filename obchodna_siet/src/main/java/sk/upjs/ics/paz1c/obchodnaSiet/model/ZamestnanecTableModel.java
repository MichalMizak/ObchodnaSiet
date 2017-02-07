package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ZamestnanecDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Zamestnanec;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class ZamestnanecTableModel extends AbstractTableModel {

    private static final String[] COLUMN_TITLES = {"Meno", "Priezvisko", "Prevádzka", "Mzda v hrubom"};

    private static final int COLUMN_COUNT = COLUMN_TITLES.length;
    
    private static final String NEPRIRADENY_MESSAGE = "Nepriradený";

    private List<Zamestnanec> zamestnanci;

    private PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();

    public ZamestnanecTableModel(List<Zamestnanec> zamestnanec) {
        this.zamestnanci = zamestnanec;
    }

    @Override
    public int getRowCount() {
        return zamestnanci == null ? 0 : zamestnanci.size();
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
        Zamestnanec zamestnanec = zamestnanci.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return zamestnanec.getMeno();
            case 1:
                return zamestnanec.getPriezvisko();
            case 2:
                Prevadzka prevadzka = prevadzkaDao.getById(zamestnanec.getPrevadzkaId());
                if (prevadzka != null) {
                    return prevadzka.getNazov();
                } else {
                    return NEPRIRADENY_MESSAGE;
                }
            case 3:
                return zamestnanec.getPlatBrutto();
            default:
                return null;
        }
    }

    public void refresh(List<Zamestnanec> zamestnanci) {
        this.zamestnanci = zamestnanci;
        fireTableDataChanged();
    }

    public Zamestnanec getItemAt(int selectedRow) {
        return zamestnanci.get(selectedRow);
    }
}
