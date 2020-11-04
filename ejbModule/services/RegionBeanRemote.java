package services;

import java.util.List;

import javax.ejb.Remote;

import models.Region;


@Remote
public interface RegionBeanRemote {
	
	void crear(Region region) throws Exception;

	void actualizar(Region region) throws Exception;

	void borrar(Long id) throws Exception;

	List<Region> obtenerTodos();

	List<Region> obtenerTodos(String filtro);

}
