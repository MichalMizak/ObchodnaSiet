package sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces;

import java.util.List;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.StatnyPoplatok;

/**
 *
 * @author Mikey
 */
public interface StatnyPoplatokDao {
    
    StatnyPoplatok getById(Long id);
    
    List<StatnyPoplatok> getItems();
    
    void saveOrEdit(StatnyPoplatok statnyPoplatok);
    
    void delete(Long id);
}
