package es.caib.dir3caib.persistence.ejb;

import es.caib.dir3caib.persistence.model.CatLocalidad;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.jboss.ejb3.annotation.SecurityDomain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;

/**
 * Created by Fundació BIT.
 *
 * @author earrivi
 * @author anadal (Eliminar PKs multiples)
 * Date: 10/10/13
 */
@Stateless(name = "CatLocalidadEJB")
@SecurityDomain("seycon")
@RolesAllowed("DIR_ADMIN")
public class CatLocalidadBean extends BaseEjbJPA<CatLocalidad, Long> implements CatLocalidadLocal{

    protected final Logger log = Logger.getLogger(getClass());

    @PersistenceContext
    private EntityManager em;

    @Override
    public CatLocalidad findById(Long id) throws Exception {

        return em.find(CatLocalidad.class, id);
    }
    
    
    
    public CatLocalidad findByPKs(Long codigoLocalidad, Long codigoProvincia,
         String codigoEntidadGeografica) throws Exception {
    
      
      Query q = em.createQuery("Select catLocalidad from CatLocalidad as catLocalidad "
          + "WHERE catLocalidad.codigoLocalidad = :codigoLocalidad "
          + " AND provincia.codigoProvincia = :codigoProvincia"
          + " AND entidadGeografica.codigoEntidadGeografica = :codigoEntidadGeografica ");
      
      q.setParameter("codigoLocalidad", codigoLocalidad);
      q.setParameter("codigoProvincia", codigoProvincia);
      q.setParameter("codigoEntidadGeografica", codigoEntidadGeografica);
      
      try {
        return (CatLocalidad)q.getSingleResult();
      } catch(Throwable e) {
        return null;
      }
       
    }
    
    
    

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<CatLocalidad> getAll() throws Exception {

        return  em.createQuery("Select catLocalidad from CatLocalidad as catLocalidad order by catLocalidad.codigoLocalidad").getResultList();
    }

    @Override
    public Long getTotal() throws Exception {

        Query q = em.createQuery("Select count(catLocalidad.codigoLocalidad) from CatLocalidad as catLocalidad");

        return (Long) q.getSingleResult();
    }

    @Override
    public List<CatLocalidad> getPagination(int inicio) throws Exception {

        Query q = em.createQuery("Select catLocalidad from CatLocalidad as catLocalidad order by catLocalidad.codigoLocalidad");
        q.setFirstResult(inicio);
        q.setMaxResults(RESULTADOS_PAGINACION);

        return q.getResultList();
    }
    
    public void deleteAll() throws Exception {

        em.createQuery("delete from CatLocalidad").executeUpdate();
        
    }

    @Override
    public List<CatLocalidad> findByProvincia(Long codigoProvincia, String codigoEntidadGeografica) throws Exception {

        Query q;
        Map<String, Object> parametros = new HashMap<String, Object>();
        List<String> where = new ArrayList<String>();

        StringBuffer query = new StringBuffer("Select catLocalidad from CatLocalidad as catLocalidad ");

        where.add(" provincia.codigoProvincia = :codigoProvincia");
        parametros.put("codigoProvincia", codigoProvincia);
        if (codigoEntidadGeografica != null && codigoEntidadGeografica.length() > 0) {
            where.add(" provincia.codigoEntidadGeografica = :codigoEntidadGeografica");
            parametros.put("codigoEntidadGeografica", codigoEntidadGeografica);
        }
       
        String strWhere = " where ";
        for (String w:where){
            query.append(strWhere);
            query.append(w);
            strWhere = " and ";
        }
        
        q = em.createQuery(query.toString());
        
        for (Map.Entry<String, Object> param : parametros.entrySet()) {
            q.setParameter(param.getKey(), param.getValue());
        }
        
        List<CatLocalidad> resultado = new ArrayList<CatLocalidad>();
        
        for (Object obj:q.getResultList()){
            resultado.add((CatLocalidad) obj);
        }
        
        return resultado;
        
        
    }
}
