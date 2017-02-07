package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import sk.upjs.ics.paz1c.obchodnaSiet.entity.Nastavenia;

public interface NastaveniaDao {

    void pridajUpravNastavenia(Nastavenia nastavenia);

    Nastavenia nacitajNastavenia(Long id);

}
