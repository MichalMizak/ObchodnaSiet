package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import sk.upjs.ics.paz1c.obchodnaSiet.entity.Naklad;
import java.util.List;

public interface NakladDao {

    void pridajNaklad(Naklad naklad);

    Naklad nacitajNaklad(Long id);

    List<Naklad> nacitajVsetkyNaklady();

    void upravNaklad(Long id);

    void odoberNaklad(Long id);
    
}
