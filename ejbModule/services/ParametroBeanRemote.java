package services;

import java.util.List;

import javax.ejb.Remote;

import models.Parametro;

@Remote(ParametroBeanRemote.class)
public interface ParametroBeanRemote {

	void crear(Parametro parametro) throws Exception;

	void actualizar(Parametro parametro) throws Exception;

	void borrar(Long id) throws Exception;

	void asignarFormulario(Long idParametro, Long idFormulario);

	List<Parametro> obtenerTodos();

	List<Parametro> obtenerTodos(String filtro);
}
