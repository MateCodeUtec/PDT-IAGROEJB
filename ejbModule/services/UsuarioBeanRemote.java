package services;

import java.util.List;

import javax.ejb.Remote;

import models.Usuario;

@Remote
public interface UsuarioBeanRemote {

	void crear(Usuario usuario) throws Exception;

	void actualizar(Usuario usuario) throws Exception;

	void borrar(Long id) throws Exception;

	List<Usuario> obtenerTodos();

	List<Usuario> obtenerTodos(String filtro);
	
	Usuario getUsuario(String usuario) throws Exception;
	
	boolean validarLogin(Usuario objUsuario, String usuario, String pass);

}
