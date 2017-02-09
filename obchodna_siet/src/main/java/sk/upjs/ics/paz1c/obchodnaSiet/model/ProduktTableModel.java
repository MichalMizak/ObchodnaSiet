package sk.upjs.ics.paz1c.obchodnaSiet.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.DodavatelDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ZamestnanecDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Dodavatel;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.ProduktNaPredajni;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class ProduktTableModel extends AbstractTableModel {

    private static final String[] COLUMN_TITLES_PRODUKT = {"Názov", "Nákupná cena", "Predajná cena", "Dodávateľ"};
    private static final int COLUMN_COUNT_PRODUKT = COLUMN_TITLES_PRODUKT.length;

    private static final String[] COLUMN_TITLES_PRODUKT_NA_PREDAJNI = {"Kusy", "Zlava"};
    private static final int COLUMN_COUNT_PRODUKT_NA_PREDAJNI = COLUMN_TITLES_PRODUKT_NA_PREDAJNI.length;

    private List<Produkt> produkty;
    private List<ProduktNaPredajni> pnps;

    private ZamestnanecDao zamestnanecDao = DaoFactory.INSTANCE.getZamestnanecDao();
    private DodavatelDao dodavatelDao = DaoFactory.INSTANCE.getDodavatelDao();
    private ProduktDao produktDao = DaoFactory.INSTANCE.getProduktDao();

    public ProduktTableModel(List<Produkt> produkty, List<ProduktNaPredajni> pnps) {
        this.produkty = produkty;
        this.pnps = pnps;
    }

    @Override
    public int getRowCount() {
        if (produkty == null) {
            if (pnps == null) {
                return 0;
            }
            return pnps.size();
        }
        return produkty.size();
    }

    @Override
    public int getColumnCount() {
        if (pnps == null) {
            return COLUMN_COUNT_PRODUKT;
        } else {
            return COLUMN_COUNT_PRODUKT + COLUMN_COUNT_PRODUKT_NA_PREDAJNI;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex < COLUMN_COUNT_PRODUKT) {
            return COLUMN_TITLES_PRODUKT[columnIndex];
        } else {
            return COLUMN_TITLES_PRODUKT_NA_PREDAJNI[columnIndex - COLUMN_COUNT_PRODUKT];
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Produkt produkt;
        ProduktNaPredajni pnp = null;
        if (produkty == null) {
            pnp = pnps.get(rowIndex);
            produkt = produktDao.getById(pnp.getProduktId());
        } else {
            produkt = produkty.get(rowIndex);
        }
        
        if (produkt == null) {
            return null;
        }
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
            case 4:
                return pnp == null ? "" : pnp.getKusy();
            case 5:
                return pnp == null ? "" : pnp.getZlava(); 
            default:
                return null;
        }
    }

    public void refresh(List<Produkt> produkty, List<ProduktNaPredajni> pnps) {
        this.produkty = produkty;
        this.pnps = pnps;

        fireTableStructureChanged();
        fireTableDataChanged();
    }

    public Produkt getItemAt(int selectedRow) {
        return produkty.get(selectedRow);
    }
}
