package services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import models.Formulario;

@Stateless
@LocalBean
public class FormularioBean implements FormularioBeanRemote {

	@PersistenceContext
	EntityManager em;

	public FormularioBean() {
	}

	@Override
	public void crear(Formulario formulario) throws Exception {

		try {

			em.persist(formulario);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo crear el formulario");
		}
	}

	@Override
	public void actualizar(Formulario usuario) throws Exception {
		try {

			em.merge(usuario);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo actualizar el formulario");
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			Formulario formulario = em.find(Formulario.class, id);
			em.remove(formulario);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo borrar el usuario");
		}

	}

	@Override
	public List<Formulario> obtenerTodos() {

		TypedQuery<Formulario> query = em.createQuery("SELECT u FROM Usuario u", Formulario.class);

		return query.getResultList();
	}

	@Override
	public List<Formulario> obtenerTodos(String filtro) {

		TypedQuery<Formulario> query = em
				.createQuery("SELECT u FROM Formulario f WHERE f.nombre LIKE :nombre ", Formulario.class)
				.setParameter("nombre", filtro);

		return query.getResultList();

	}
}
