package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import models.Localidad;

/**
 * Session Bean implementation class LocalidadBean
 */
@Stateless
@LocalBean
public class LocalidadBean implements LocalidadBeanRemote {

    /**
     * Default constructor. 
     */
    public LocalidadBean() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext
	EntityManager em;

	@Override
	public void crear(Localidad localidad) throws Exception {

		try {

			em.persist(localidad);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo crear el localidad");
		}
	}

	@Override
	public void actualizar(Localidad localidad) throws Exception {
		try {

			em.merge(localidad);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo actualizar el localidad");
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			Localidad localidad = em.find(Localidad.class, id);
			em.remove(localidad);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo borrar el Localidad");
		}

	}

	@Override
	public List<Localidad> obtenerTodos() {

		TypedQuery<Localidad> query = em.createQuery("SELECT e FROM Localidad e", Localidad.class);

		return query.getResultList();
	}

	@Override
	public List<Localidad> obtenerTodos(String filtro) {

		TypedQuery<Localidad> query = em
				.createQuery("SELECT e FROM Localidad e WHERE e.nombre LIKE :nombre ", Localidad.class)
				.setParameter("nombre", filtro);

		return query.getResultList();

	}

	@Override
	public Localidad getLocalidadById(Long id) {

		Localidad localidad = em.find(Localidad.class, id);
		return localidad;
	}

}

