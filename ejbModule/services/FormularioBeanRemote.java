package services;

import java.util.List;

import javax.ejb.Remote;

import models.Formulario;

@Remote
public interface FormularioBeanRemote {

	void crear(Formulario formulario) throws Exception;

	void actualizar(Formulario formulario) throws Exception;

	void borrar(Long id) throws Exception;
	
	void desactivar(Long id) throws Exception;
	
	Formulario getFormularioById(Long id);
	
	Formulario getFormulario(String nombre);

	List<Formulario> obtenerTodos();

	List<Formulario> obtenerTodos(String filtro);

}
