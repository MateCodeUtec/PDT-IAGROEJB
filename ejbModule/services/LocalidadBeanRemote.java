package services;

import java.util.List;

import javax.ejb.Remote;

import models.Localidad;

@Remote
public interface LocalidadBeanRemote {
	
	void crear(Localidad localidad) throws Exception;

	void actualizar(Localidad localidad) throws Exception;

	void borrar(Long id) throws Exception;
	
	Localidad getLocalidadById(Long id);

	List<Localidad> obtenerTodos();

	List<Localidad> obtenerTodos(String filtro);

}
