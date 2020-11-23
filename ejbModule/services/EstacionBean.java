package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import models.Departamento;
import models.Estacion;

/**
 * Session Bean implementation class EstacionBean
 */
@Stateless
public class EstacionBean implements EstacionBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public EstacionBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void crear(Estacion estacion) {
		try{
			em.persist(estacion);
			em.flush();
		}catch(PersistenceException e){
			throw new PersistenceException("No se pudo crear la estacion");
		}
		
	}
    
    @Override
	public void actualizar(Estacion estacion) throws Exception {
		try {

			em.merge(estacion);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo actualizar el estacion");
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			Estacion estacion = em.find(Estacion.class, id);
			em.remove(estacion);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo borrar el Estacion");
		}

	}

	@Override
	public List<Estacion> obtenerTodos() {

		TypedQuery<Estacion> query = em.createQuery("SELECT e FROM Estacion e", Estacion.class);

		return query.getResultList();
	}

	@Override
	public List<Estacion> obtenerTodos(String filtro) {

		TypedQuery<Estacion> query = em
				.createQuery("SELECT e FROM Estacion e WHERE e.nombre LIKE :nombre ", Estacion.class)
				.setParameter("nombre", filtro);

		return query.getResultList();

	}

}
