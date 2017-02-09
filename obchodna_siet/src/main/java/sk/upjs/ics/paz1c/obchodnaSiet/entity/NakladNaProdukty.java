package sk.upjs.ics.paz1c.obchodnaSiet.entity;

import java.sql.Date;

/**
 *
 * @author Mikey
 */
public class NakladNaProdukty extends PrijemZProdukty {

    public NakladNaProdukty() {
    }

    public NakladNaProdukty(Long id, String popis, Date datum, Long produktId, Long prevadzkaId, double zlava, int kusy) {
        super(id, popis, datum, produktId, prevadzkaId, zlava, kusy);
    }

    public NakladNaProdukty(PrijemZProdukty prijem) {
        super(prijem.getId(), prijem.getPopis(), prijem.getDatum(), prijem.getProduktId(),
                prijem.getPrevadzkaId(), prijem.getZlava(), prijem.getKusy());
        setSuma(prijem.getSuma());
    }

}
