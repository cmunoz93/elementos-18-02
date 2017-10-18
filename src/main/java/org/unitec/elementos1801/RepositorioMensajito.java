
package org.unitec.elementos1801;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioMensajito extends CrudRepository<Mensajito, Integer>{
    List<Mensajito> findByTitulo(String titulo);
}
