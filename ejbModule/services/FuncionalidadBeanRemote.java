package services;

import java.util.List;

import javax.ejb.Remote;

import models.Funcionalidad;


@Remote(FuncionalidadBeanRemote.class)
public interface FuncionalidadBeanRemote {

	
	void crear (Funcionalidad funcionalidad) throws Exception ;
	
	void modificar (Funcionalidad funcionalidad) throws Exception;	
	
	void eliminar (Long id) throws Exception;
	
	List<Funcionalidad> obtenerTodos();

	List<Funcionalidad> obtenerTodos(String filtro);
	
	
}
