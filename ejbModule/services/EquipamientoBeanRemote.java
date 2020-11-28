package services;

import java.util.List;

import javax.ejb.Remote;

import models.Equipamiento;

@Remote
public interface EquipamientoBeanRemote {

	Equipamiento crear(Equipamiento equipamiento) throws Exception;

	void actualizar(Equipamiento equipamiento) throws Exception;

	void borrar(Long id) throws Exception;
	
	Equipamiento getEquipamientoById(Long id);

	List<Equipamiento> obtenerTodos();

	List<Equipamiento> obtenerTodos(String filtro);

}
