package services;

import java.util.List;

import javax.ejb.Remote;

import models.Metodo;

@Remote
public interface MetodoBeanRemote {

	void crear(Metodo metodo) throws Exception;

	void actualizar(Metodo metodo) throws Exception;

	void borrar(Long id) throws Exception;

	List<Metodo> obtenerTodos();

	List<Metodo> obtenerTodos(String filtro);

}
