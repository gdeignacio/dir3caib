package es.caib.dir3caib.persistence.ejb;

import es.caib.dir3caib.persistence.model.CatAmbitoTerritorial;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Fundació BIT.
 *
 * @author earrivi
 * @author anadal (Eliminar PKs multiples)
 * Date: 10/10/13
 */
@Local
public interface CatAmbitoTerritorialLocal extends BaseEjb<CatAmbitoTerritorial, Long> {
  
  public void deleteAll() throws Exception;

  public List<CatAmbitoTerritorial> getByAdministracion(Long nivelAdministracion) throws Exception;
  
  public CatAmbitoTerritorial findByPKs(String codigoAmbito, Long codigoNivelAdministracion) throws Exception;
}
