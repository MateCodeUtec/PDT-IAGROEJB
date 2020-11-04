package services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import models.Rol;

@Stateless
@LocalBean
public class RolBean implements RolBeanRemote {

	EntityManager em;

	public RolBean() {
	}

	@Override
	public void crear(Rol rol) throws Exception {

		try {

			em.persist(rol);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo crear el rol");
		}
	}

	@Override
	public void actualizar(Rol rol) throws Exception {
		try {

			em.merge(rol);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo actualizar el rol");
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			Rol rol = em.find(Rol.class, id);
			em.remove(rol);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo borrar el rol");
		}

	}

	@Override
	public List<Rol> obtenerTodos() {

		TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r", Rol.class);

		return query.getResultList();
	}

	@Override
	public List<Rol> obtenerTodos(String filtro) {

		TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r WHERE r.nombre LIKE :nombre ", Rol.class)
				.setParameter("nombre", filtro);

		return query.getResultList();

	}

}
