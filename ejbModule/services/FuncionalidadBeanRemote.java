package services;

import java.util.List;

import javax.ejb.Remote;

import models.Funcionalidad;

@Remote
public interface FuncionalidadBeanRemote {

	void crear(Funcionalidad funcionalidad) throws Exception;

	void actualizar(Funcionalidad funcionalidad) throws Exception;

	void borrar(Long id) throws Exception;

	List<Funcionalidad> obtenerTodos();

	List<Funcionalidad> obtenerTodos(String filtro);

}
