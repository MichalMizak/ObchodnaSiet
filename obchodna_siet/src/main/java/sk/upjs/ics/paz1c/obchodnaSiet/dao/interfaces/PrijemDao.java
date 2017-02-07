package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prijem;
import java.util.List;

public interface PrijemDao {

    void save(Prijem prijem);

    Prijem getById(Long id);

    List<Prijem> nacitajVsetkyPrijmy();

    void edit(Long id);

    void delete(Prijem prijem);

    double getSuma(Prijem prijem);
}
