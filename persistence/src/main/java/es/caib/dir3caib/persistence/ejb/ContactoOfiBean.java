/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.caib.dir3caib.persistence.ejb;

import es.caib.dir3caib.persistence.model.ContactoOfi;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.jboss.ejb3.annotation.SecurityDomain;

/**
 *
 * @author mgonzalez
 */
@Stateless(name = "ContactoOfiEJB")
@SecurityDomain("seycon")
@RolesAllowed("DIR_ADMIN")
public class ContactoOfiBean extends BaseEjbJPA<ContactoOfi, Long> implements ContactoOfiLocal{

    protected final Logger log = Logger.getLogger(getClass());

    @PersistenceContext
    private EntityManager em;

    @Override
    public ContactoOfi findById(Long id) throws Exception {

        return em.find(ContactoOfi.class, id);
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<ContactoOfi> getAll() throws Exception {

        return  em.createQuery("Select contacto from ContactoOfi as contacto order by contacto.codContacto").getResultList();
    }

    @Override
    public Long getTotal() throws Exception {

        Query q = em.createQuery("Select count(contacto.codContacto) from ContactoOfi as contacto");

        return (Long) q.getSingleResult();
    }

    @Override
    public List<ContactoOfi> getPagination(int inicio) throws Exception {

        Query q = em.createQuery("Select contacto from ContactoOfi as contacto order by contacto.codContacto");
        q.setFirstResult(inicio);
        q.setMaxResults(RESULTADOS_PAGINACION);

        return q.getResultList();
    }
    

    public void deleteAll() throws Exception {

        em.createQuery("delete from ContactoOfi").executeUpdate();
        
    }
  
}
