package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import sk.upjs.ics.paz1c.obchodnaSiet.entity.MesacnyNaklad;
import java.util.List;

public interface MesacnyNakladDao {

    void pridajNaklad(MesacnyNaklad naklad);

    MesacnyNaklad nacitajNaklad(Long id);

    List<MesacnyNaklad> nacitajVsetkyNaklady();

    void upravNaklad(Long id);

    void odoberNaklad(Long id);
    
}
