package services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import models.Metodo;

@Stateless
@LocalBean
public class MetodoBean implements MetodoBeanRemote {

	EntityManager em;
   
    public MetodoBean() {}


	@Override
	public void crear(Metodo metodo) throws Exception {

		try {

			em.persist(metodo);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo crear el metodo");
		}
	}

	@Override
	public void actualizar(Metodo metodo) throws Exception {
		try {

			em.merge(metodo);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo actualizar el metodo");
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			Metodo metodo = em.find(Metodo.class, id);
			em.remove(metodo);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo borrar el metodo");
		}

	}

	@Override
	public List<Metodo> obtenerTodos() {

		TypedQuery<Metodo> query = em.createQuery("SELECT m FROM Metodo m", Metodo.class);

		return query.getResultList();
	}

	@Override
	public List<Metodo> obtenerTodos(String filtro) {

		TypedQuery<Metodo> query = em.createQuery("SELECT m FROM Metodo m WHERE m.nombre LIKE :nombre ", Metodo.class)
				.setParameter("nombre", filtro);

		return query.getResultList();
	}
}

