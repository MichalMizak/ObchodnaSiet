package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import sk.upjs.ics.paz1c.obchodnaSiet.entity.Zamestnanec;
import java.util.List;

public interface ZamestnanecDao {

    void pridajZamestnanca(Zamestnanec zamestnanec);

    Zamestnanec nacitajZamestnanca(Long id);

    List<Zamestnanec> getZamestnanci();

    List<Zamestnanec> getZamestnanciByPrevadzka(Long prevadzka_id);
    
    void upravZamestnanca(Zamestnanec zamestnanec);

    void odoberZamestnanca(Long id);

}
