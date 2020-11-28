package services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import models.ActividadCampo;

@Stateless
@LocalBean
public class ActividadCampoBean implements ActividadCampoBeanRemote {

	@PersistenceContext
	EntityManager em;

	public ActividadCampoBean() {
	}

	@Override
	public ActividadCampo crear(ActividadCampo actividadCampo) throws Exception {

		try {

			em.persist(actividadCampo);
			em.flush();
			return actividadCampo;
		} catch (PersistenceException e) {
			throw new Exception("No se pudo crear el ActividadCampo");
		}
	}

	@Override
	public void actualizar(ActividadCampo actividadCampo) throws Exception {
		try {

			em.merge(actividadCampo);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo actualizar el ActividadCampo");
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			ActividadCampo actividadCampo = em.find(ActividadCampo.class, id);
			em.remove(actividadCampo);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo borrar el ActividadCampo");
		}

	}

	@Override
	public List<ActividadCampo> obtenerTodos() {

		TypedQuery<ActividadCampo> query = em.createQuery("SELECT e FROM ActividadCampo e", ActividadCampo.class);

		return query.getResultList();
	}

	@Override
	public List<ActividadCampo> obtenerTodos(String filtro) {

		TypedQuery<ActividadCampo> query = em
				.createQuery("SELECT e FROM ActividadCampo e WHERE e.nombre LIKE :nombre ", ActividadCampo.class)
				.setParameter("nombre", filtro);

		return query.getResultList();

	}

	@Override
	public ActividadCampo getActividadById(Long id) {
		ActividadCampo actividadCampo = em.find(ActividadCampo.class, id);
		return actividadCampo;
	}

}