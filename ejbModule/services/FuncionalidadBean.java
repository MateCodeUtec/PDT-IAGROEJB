package services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import models.Funcionalidad;

@Stateless
@LocalBean
public class FuncionalidadBean implements FuncionalidadBeanRemote {

	EntityManager em;

	public FuncionalidadBean() {
	}

	@Override
	public void crear(Funcionalidad funcionalidad) throws Exception {

		try {

			em.persist(funcionalidad);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo crear la funcionalidad");
		}
	}

	@Override
	public void actualizar(Funcionalidad funcionalidad) throws Exception {
		try {

			em.merge(funcionalidad);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo actualizar la Funcionalidad");
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			Funcionalidad funcionalidad = em.find(Funcionalidad.class, id);
			em.remove(funcionalidad);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo borrar la funcionalidad");
		}

	}

	@Override
	public List<Funcionalidad> obtenerTodos() {

		TypedQuery<Funcionalidad> query = em.createQuery("SELECT f FROM Funcionalidad f", Funcionalidad.class);

		return query.getResultList();
	}

	@Override
	public List<Funcionalidad> obtenerTodos(String filtro) {

		TypedQuery<Funcionalidad> query = em
				.createQuery("SELECT u FROM Funcionalidad u WHERE u.nombre LIKE :nombre ", Funcionalidad.class)
				.setParameter("nombre", filtro);

		return query.getResultList();

	}
}
