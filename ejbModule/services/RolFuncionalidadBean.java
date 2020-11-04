package services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import models.RolFuncionalidad;

@Stateless
@LocalBean
public class RolFuncionalidadBean implements RolFuncionalidadBeanRemote {

	public RolFuncionalidadBean() {
	}

	EntityManager em;

	@Override
	public void crear(RolFuncionalidad rolFuncionalidad) throws Exception {

		try {

			em.persist(rolFuncionalidad);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo crear el Rol - Funcionalidad");
		}
	}

	@Override
	public void actualizar(RolFuncionalidad rolFuncionalidad) throws Exception {
		try {

			em.merge(rolFuncionalidad);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo actualizar el Rol - Funcionalidad");
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			RolFuncionalidad rolFuncionalidad = em.find(RolFuncionalidad.class, id);
			em.remove(rolFuncionalidad);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo borrar el Rol - Funcionalidad");
		}

	}

	@Override
	public List<RolFuncionalidad> obtenerTodos() {

		TypedQuery<RolFuncionalidad> query = em.createQuery("SELECT rf FROM RolFuncionalidad rf",
				RolFuncionalidad.class);

		return query.getResultList();
	}

	@Override
	public List<RolFuncionalidad> obtenerTodos(String filtro) {

		TypedQuery<RolFuncionalidad> query = em
				.createQuery("SELECT rf FROM RolFuncionalidad rf WHERE rf.nombre LIKE :nombre ", RolFuncionalidad.class)
				.setParameter("nombre", filtro);

		return query.getResultList();

	}

}
