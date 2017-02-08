package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;
import java.util.List;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Dodavatel;

public interface ProduktDao {

    void save(Produkt produkt);

    Produkt getById(Long id);

    List<Produkt> getProdukty();

    void edit(Produkt produkt);

    void delete(Long id);

    double vycisliZisk(Long id);

    public List<Produkt> getByDodavatel(Dodavatel dodavatel);
}
