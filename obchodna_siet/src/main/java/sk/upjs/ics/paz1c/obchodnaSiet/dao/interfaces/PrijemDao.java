package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import sk.upjs.ics.paz1c.obchodnaSiet.entity.PrijemZProdukty;
import java.util.List;

public interface PrijemDao {

    void save(PrijemZProdukty prijem);

    PrijemZProdukty getById(Long id);

    List<PrijemZProdukty> getPrijmy();

    List<PrijemZProdukty> getPrijmyByPrevadzka(Long prevadzkaId);
    
    void edit(PrijemZProdukty prijem);

    void delete(PrijemZProdukty prijem);

    double getSuma(PrijemZProdukty prijem);
    
    double getSuma(Long prevadzkaId);
}
