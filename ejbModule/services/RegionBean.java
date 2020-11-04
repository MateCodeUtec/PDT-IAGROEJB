package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import models.Departamento;
import models.Region;

/**
 * Session Bean implementation class RegionBean
 */
@Stateless
@LocalBean
public class RegionBean implements RegionBeanRemote {

    public RegionBean() {}
    
    EntityManager em;

   	@Override
   	public void crear(Region region) throws Exception {

   		try {

   			em.persist(region);
   			em.flush();

   		} catch (PersistenceException e) {
   			throw new Exception("No se pudo crear el Region");
   		}
   	}

   	@Override
   	public void actualizar(Region region) throws Exception {
   		try {

   			em.merge(region);
   			em.flush();

   		} catch (PersistenceException e) {
   			throw new Exception("No se pudo actualizar el Region");
   		}

   	}

   	@Override
   	public void borrar(Long id) throws Exception {

   		try {

   			Region region = em.find(Region.class, id);
   			em.remove(region);
   			em.flush();

   		} catch (PersistenceException e) {
   			throw new Exception("No se pudo borrar el Region");
   		}

   	}

   	@Override
   	public List<Region> obtenerTodos() {

   		TypedQuery<Region> query = em.createQuery("SELECT e FROM Region e", Region.class);

   		return query.getResultList();
   	}

   	@Override
   	public List<Region> obtenerTodos(String filtro) {

   		TypedQuery<Region> query = em
   				.createQuery("SELECT e FROM Region e WHERE e.nombre LIKE :nombre ", Region.class)
   				.setParameter("nombre", filtro);

   		return query.getResultList();

   	}

}
