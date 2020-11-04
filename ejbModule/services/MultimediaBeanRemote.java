package services;

import java.util.List;

import javax.ejb.Remote;

import models.Multimedia;

@Remote(MultimediaBeanRemote.class)
public interface MultimediaBeanRemote {

	void crear(Multimedia multimedia) throws Exception;

	void actualizar(Multimedia multimedia) throws Exception;

	void borrar(Long id) throws Exception;
	
	void asignarReporte (Long idMultimedia, Long idReporte) throws Exception;

	List<Multimedia> obtenerTodos();

	List<Multimedia> obtenerTodos(String filtro);
	
}
