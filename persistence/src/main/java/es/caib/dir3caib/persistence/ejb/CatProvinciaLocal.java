package es.caib.dir3caib.persistence.ejb;

import es.caib.dir3caib.persistence.model.CatProvincia;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Fundació BIT.
 *
 * @author earrivi
 * Date: 10/10/13
 */
@Local
public interface CatProvinciaLocal extends BaseEjb<CatProvincia, Long> {

  public List<CatProvincia> getByComunidadAutonoma(Long idComunidadAutonoma) throws Exception;
  public void deleteAll() throws Exception;
}
