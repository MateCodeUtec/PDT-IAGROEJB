package services;

import java.util.List;

import javax.ejb.Remote;

import models.Departamento;
import models.Estacion;

@Remote
public interface EstacionBeanRemote {
	
	void crear(Estacion estacion);
	
	void actualizar(Estacion estacion) throws Exception;

	void borrar(Long id) throws Exception;
	
	Estacion getEstacionById(Long id);

	List<Estacion> obtenerTodos();

	List<Estacion> obtenerTodos(String filtro);

}
