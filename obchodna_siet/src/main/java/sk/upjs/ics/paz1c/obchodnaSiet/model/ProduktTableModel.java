package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.DodavatelDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrevadzkaDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ZamestnanecDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Dodavatel;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class ProduktTableModel extends AbstractTableModel {

    private static final String[] COLUMN_TITLES = {"Názov", "Nákupná cena", "Predajná cena", "Dodávateľ"};

    private static final int COLUMN_COUNT = COLUMN_TITLES.length;

    private List<Produkt> produkty;

    private ZamestnanecDao zamestnanecDao = DaoFactory.INSTANCE.getZamestnanecDao();
    private PrevadzkaDao prevadzkaDao = DaoFactory.INSTANCE.getPrevadzkaDao();
    private DodavatelDao dodavatelDao = DaoFactory.INSTANCE.getDodavatelDao();

    public ProduktTableModel(List<Produkt> produkty) {
        this.produkty = produkty;
    }

    @Override
    public int getRowCount() {

        return produkty == null ? 0 : produkty.size();
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
        Produkt produkt = produkty.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return produkt.getNazov();
            case 1:
                return produkt.getNakupnaCena();
            case 2:
                return produkt.getPredajnaCena();
            case 3:
                Dodavatel dodavatel = dodavatelDao.getById(produkt.getDodavatel_id());
                if (dodavatel == null) {
                    return "";
                }
                return dodavatel.toString();
            default:
                return null;
        }
    }

    public void refresh(List<Produkt> produkty) {
        this.produkty = produkty;

        fireTableDataChanged();
    }

    public Produkt getItemAt(int selectedRow) {
        return produkty.get(selectedRow);
    }
}
