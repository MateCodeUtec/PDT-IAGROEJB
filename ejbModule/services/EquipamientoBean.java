package services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import models.Equipamiento;

@Stateless
@LocalBean
public class EquipamientoBean implements EquipamientoBeanRemote {

	@PersistenceContext
	EntityManager em;

	public EquipamientoBean() {
	}

	@Override
	public Equipamiento crear(Equipamiento equipamiento) throws Exception {

		try {

			em.persist(equipamiento);
			em.flush();
			return equipamiento;
		} catch (PersistenceException e) {
			throw new Exception("No se pudo crear el equipamiento");
		}
	}

	@Override
	public void actualizar(Equipamiento equipamiento) throws Exception {
		try {

			em.merge(equipamiento);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo actualizar el equipamiento");
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			Equipamiento equipamiento = em.find(Equipamiento.class, id);
			em.remove(equipamiento);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo borrar el equipamiento");
		}

	}

	@Override
	public List<Equipamiento> obtenerTodos() {

		TypedQuery<Equipamiento> query = em.createQuery("SELECT e FROM Equipamiento e", Equipamiento.class);

		return query.getResultList();
	}

	@Override
	public List<Equipamiento> obtenerTodos(String filtro) {

		TypedQuery<Equipamiento> query = em
				.createQuery("SELECT e FROM Equipamiento e WHERE e.nombre LIKE :nombre ", Equipamiento.class)
				.setParameter("nombre", filtro);

		return query.getResultList();

	}

	@Override
	public Equipamiento getEquipamientoById(Long id) {
		Equipamiento equipamiento = em.find(Equipamiento.class, id);
		return equipamiento;
	}

}
