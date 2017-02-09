
package sk.upjs.ics.paz1c.obchodnaSiet.model;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.ObjectFactory;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrijemDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ZamestnanecDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class PrevadzkyTableModel extends AbstractTableModel {

    private static final String[] COLUMN_TITLES = {"Názov", "Adresa", "Počet zamestnancov",
        "Celkový zisk", "Otváracie hodiny"};

    private static final int COLUMN_COUNT = COLUMN_TITLES.length;

    private List<Prevadzka> prevadzky;

    private ZamestnanecDao zamestnanecDao = DaoFactory.INSTANCE.getZamestnanecDao();
    private PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
    private PrijemDao prijemDao = DaoFactory.INSTANCE.getPrijemDao();

    public PrevadzkyTableModel(List<Prevadzka> prevadzky) {
        this.prevadzky = prevadzky;
    }

    @Override
    public int getRowCount() {

        return prevadzky == null ? 0 : prevadzky.size();
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
        Prevadzka prevadzka = prevadzky.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return prevadzka.getNazov();
            case 1:
                return prevadzka.getAdresa();
            case 2:
                return zamestnanecDao.getZamestnanciByPrevadzka(prevadzka.getId()).size();
            case 3:
                return prevadzkaDao.getZisk(prevadzka.getId());
            case 4:
                return prevadzka.getOtvaracieHodiny();
        }
        return null;
    }

    public void refresh(List<Prevadzka> prevadzky) {
        this.prevadzky = prevadzky;
        fireTableDataChanged();
    }

    public Prevadzka getItemAt(int selectedRow) {
        return prevadzky.get(selectedRow);
    }
}
