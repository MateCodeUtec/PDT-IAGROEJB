package services;

import java.util.List;

import javax.ejb.Remote;

import models.Metodo;

@Remote
public interface MetodoBeanRemote {

	Metodo crear(Metodo metodo) throws Exception;

	void actualizar(Metodo metodo) throws Exception;

	void borrar(Long id) throws Exception;
	
	Metodo getMetodoById(Long id);

	List<Metodo> obtenerTodos();

	List<Metodo> obtenerTodos(String filtro);

}
