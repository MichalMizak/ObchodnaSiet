package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import java.util.List;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.NakladNaProdukty;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.ProduktNaPredajni;

/**
 *
 * @author Mikey
 */
public interface NakladNaProduktyDao {
    void save(NakladNaProdukty prijem);

    NakladNaProdukty getById(Long id);

    List<NakladNaProdukty> getPrijmy();

    List<NakladNaProdukty> getPrijmyByPrevadzka(Long prevadzkaId);
    
    void edit(NakladNaProdukty prijem);

    void delete(NakladNaProdukty prijem);

    double getSuma(NakladNaProdukty prijem);
    
    double getSuma(Long prevadzkaId);
    
    NakladNaProdukty createNaklad(ProduktNaPredajni pnp);
}
