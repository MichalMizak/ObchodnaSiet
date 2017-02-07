package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.DodavatelDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Dodavatel;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Dodavatel;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class DodavatelTableModel extends AbstractTableModel {

    private static final String[] COLUMN_TITLES = {"Názov", "Sídlo", "Kontakt", "Podiel na ponuke"};

    private static final int COLUMN_COUNT = COLUMN_TITLES.length;

    private List<Dodavatel> dodavatelia;

    private PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();

    public DodavatelTableModel(List<Dodavatel> dodavatelia) {
        this.dodavatelia = dodavatelia;
    }

    @Override
    public int getRowCount() {
        return dodavatelia == null ? 0 : dodavatelia.size();
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
        Dodavatel dodavatel = dodavatelia.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return dodavatel.getNazov();
            case 1:
                return dodavatel.getSidlo();
            case 2:
                return dodavatel.getKontakt();
            case 3:
                DodavatelDao dodavatelDao = DaoFactory.INSTANCE.getDodavatelDao();
                return dodavatelDao.podielNaPonukeTrhu(dodavatel);
            default:
                return null;
        }
    }

    public void refresh(List<Dodavatel> dodavatelia) {
        this.dodavatelia = dodavatelia;
        fireTableDataChanged();
    }

    public Dodavatel getItemAt(int selectedRow) {
        return dodavatelia.get(selectedRow);
    }
}
