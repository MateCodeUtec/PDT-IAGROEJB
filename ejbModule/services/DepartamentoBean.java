package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import models.Departamento;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless
@LocalBean
public class DepartamentoBean implements DepartamentoBeanRemote {

    /**
     * Default constructor. 
     */
    public DepartamentoBean() {
        // TODO Auto-generated constructor stub
    }

    EntityManager em;

	@Override
	public void crear(Departamento departamento) throws Exception {

		try {

			em.persist(departamento);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo crear el departamento");
		}
	}

	@Override
	public void actualizar(Departamento departamento) throws Exception {
		try {

			em.merge(departamento);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo actualizar el departamento");
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			Departamento departamento = em.find(Departamento.class, id);
			em.remove(departamento);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo borrar el Departamento");
		}

	}

	@Override
	public List<Departamento> obtenerTodos() {

		TypedQuery<Departamento> query = em.createQuery("SELECT e FROM Departamento e", Departamento.class);

		return query.getResultList();
	}

	@Override
	public List<Departamento> obtenerTodos(String filtro) {

		TypedQuery<Departamento> query = em
				.createQuery("SELECT e FROM Departamento e WHERE e.nombre LIKE :nombre ", Departamento.class)
				.setParameter("nombre", filtro);

		return query.getResultList();

	}

}
