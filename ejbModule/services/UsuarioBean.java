package services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import models.Usuario;

@Stateless
@LocalBean
public class UsuarioBean implements UsuarioBeanRemote {
	
	@PersistenceContext
	EntityManager em;

	public UsuarioBean() {}

	@Override
	public void crear(Usuario usuario) throws Exception {

		try {
			em.persist(usuario);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void actualizar(Usuario usuario) throws Exception {
		try {

			em.merge(usuario);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo actualizar el usuario-->"+e.getMessage());
		}

	}

	@Override
	public void borrar(Long id) throws Exception {

		try {

			Usuario usuario = em.find(Usuario.class, id);
			em.remove(usuario);
			em.flush();

		} catch (PersistenceException e) {
			throw new Exception("No se pudo borrar el usuario-->"+e.getMessage());
		}

	}

	@Override
	public List<Usuario> obtenerTodos() {

		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);

		return query.getResultList();
	}

	@Override
	public List<Usuario> obtenerTodos(String filtro) {

		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre LIKE :nombre ", Usuario.class)
				.setParameter("nombre", filtro);

		return query.getResultList();

	}

	@Override
	public Usuario getUsuario(String usuario) throws Exception {
		
		TypedQuery<Usuario> query = em.createQuery("SELECT u from Usuario u WHERE u.usuario = :usuario ", Usuario.class)
				.setParameter("usuario", usuario);
		return query.getSingleResult();
	}

	@Override
	public boolean validarLogin(Usuario objUsuario, String usuario, String pass) {
		
		if (objUsuario.getUsuario().equals(usuario)) {
			
			return objUsuario.getContrasenia().equals(pass);
			
		}

		return false;
	}

}
