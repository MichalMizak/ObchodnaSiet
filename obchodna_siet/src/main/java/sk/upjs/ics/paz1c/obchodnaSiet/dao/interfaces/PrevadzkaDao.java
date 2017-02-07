package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import java.util.List;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;

public interface PrevadzkaDao {

    void saveOrEdit(Prevadzka prevadzka);

    Prevadzka getById(Long id);

    List<Prevadzka> getPrevadzky();

    void delete(Long id);

    double vycisliZisk(Long id);

}
