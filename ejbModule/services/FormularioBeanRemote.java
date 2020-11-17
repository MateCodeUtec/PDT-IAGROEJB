package services;

import java.util.List;

import javax.ejb.Remote;

import models.Formulario;

@Remote
public interface FormularioBeanRemote {

	void crear(Formulario formulario) throws Exception;

	void actualizar(Formulario usuario) throws Exception;

	void borrar(Long id) throws Exception;
	
	Formulario getFormulario(String nombre);

	List<Formulario> obtenerTodos();

	List<Formulario> obtenerTodos(String filtro);

}
