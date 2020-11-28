package services;

import java.util.List;

import javax.ejb.Remote;

import models.Departamento;

@Remote
public interface DepartamentoBeanRemote {
	
	void crear(Departamento departamento) throws Exception;

	void actualizar(Departamento departamento) throws Exception;

	void borrar(Long id) throws Exception;
	
	Departamento getDepartamentoById(Long id);

	List<Departamento> obtenerTodos();

	List<Departamento> obtenerTodos(String filtro);

}
