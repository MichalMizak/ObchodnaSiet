package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import sk.upjs.ics.paz1c.obchodnaSiet.entity.ProduktNaPredajni;
import java.util.List;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prijem;

public interface ProduktNaPredajniDao {

    void saveOrEdit(ProduktNaPredajni produktNaPredajni);

    ProduktNaPredajni getById(Long produktId, Long prevadzkaId);

    List<ProduktNaPredajni> getProduktyNaPredajni();

    void delete(Long produktId, Long prevadzkaId);

    public List<ProduktNaPredajni> getByPrevadzka(Long id);
}
