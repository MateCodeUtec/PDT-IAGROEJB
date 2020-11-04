package services;

import java.util.List;

import javax.ejb.Remote;

import models.Rol;

@Remote
public interface RolBeanRemote {

	void crear(Rol rol) throws Exception;

	void actualizar(Rol rol) throws Exception;

	void borrar(Long id) throws Exception;

	List<Rol> obtenerTodos();

	List<Rol> obtenerTodos(String filtro);

}
