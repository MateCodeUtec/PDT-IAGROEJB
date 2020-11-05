package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Formulario;
import models.Parametro;

/**
 * Session Bean implementation class ParametroBean
 */
@Stateless
@LocalBean
public class ParametroBean implements ParametroBeanRemote {

	@PersistenceContext
	EntityManager em;

	public ParametroBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Parametro parametro) throws Exception {

		try {
			Parametro p = new Parametro();

			em.persist(p);

			em.flush();

		} catch (Exception e) {

			System.out.println("No se pudo crear el parametro");
		}

	}

	@Override
	public void actualizar(Parametro parametro) throws Exception {

		try {

			em.merge(parametro);

			em.flush();

		} catch (Exception e) {

			System.out.println("No se pudo actualizar el parametro");
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			Parametro p = em.find(Parametro.class, id);

			em.remove(p);

			em.flush();

		} catch (Exception e) {

			System.out.println("No se pudo eliminar el parametro");
		}

	}

	@Override
	public void asignarFormulario(Long idParametro, Long idFormulario) {

		try {

			Parametro p = em.find(Parametro.class, idParametro);

			p.setFormulario(em.find(Formulario.class, idFormulario));

			em.flush();

		} catch (Exception e) {

			System.out.println("No se pudo asignar el formulario al parametro");
		}

	}

	@Override
	public List<Parametro> obtenerTodos() {

		TypedQuery<Parametro> query = em.createQuery("SELECT p FROM PARAMETRO p", Parametro.class);
		return query.getResultList();
	}

	@Override
	public List<Parametro> obtenerTodos(String filtro) {

		TypedQuery<Parametro> query = em.createQuery("SELECT p FROM PARAMETRO p WHERE p.TipoParametro = TipoParametro",
				Parametro.class);
		return query.getResultList();
	}

}
