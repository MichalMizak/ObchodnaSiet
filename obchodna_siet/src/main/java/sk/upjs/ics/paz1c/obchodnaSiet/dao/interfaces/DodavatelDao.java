package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import java.util.List;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Dodavatel;

/**
 *
 * @author Mikey
 */
public interface DodavatelDao {

    List<Dodavatel> getDodavatelia();

    Dodavatel getById(Long id);

    void saveOrEdit(Dodavatel dodavatel);

    void delete(Dodavatel dodavatel);
    
    double podielNaPonukeTrhu(Dodavatel dodavatel);
}
