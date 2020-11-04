package services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import models.TipoParametro;

@Stateless
@LocalBean
public class TipoParametroBean implements TipoParametroBeanRemote {

	EntityManager em;

	public TipoParametroBean() {
	}

	@Override
	public void crear(TipoParametro tipoParametro) throws Exception {

		try {

			em.persist(tipoParametro);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo crear el tipo de parametro");
		}
	}

	@Override
	public void actualizar(TipoParametro tipoParametro) throws Exception {
		try {

			em.merge(tipoParametro);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo actualizar el tipo de parametro");
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			TipoParametro tipoParametro = em.find(TipoParametro.class, id);
			em.remove(tipoParametro);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo borrar el tipo de parametro");
		}

	}

	@Override
	public List<TipoParametro> obtenerTodos() {

		TypedQuery<TipoParametro> query = em.createQuery("SELECT tp FROM TipoParametro tp", TipoParametro.class);

		return query.getResultList();
	}

	@Override
	public List<TipoParametro> obtenerTodos(String filtro) {

		TypedQuery<TipoParametro> query = em
				.createQuery("SELECT tp FROM TipoParametro tp WHERE tp.nombre LIKE :nombre ", TipoParametro.class)
				.setParameter("nombre", filtro);

		return query.getResultList();

	}

}
