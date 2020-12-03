package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import models.ActividadCampo;

@Remote
public interface ActividadCampoBeanRemote {

	ActividadCampo crear(ActividadCampo actividadCampo) throws Exception;

	void actualizar(ActividadCampo actividadCampo) throws Exception;

	void borrar(Long id) throws Exception;
	
	void desactivar(Long id);
	
	ActividadCampo getActividadById(Long id);
	
	List<ActividadCampo> obtenerTodos();

	List<ActividadCampo> obtenerTodos(String filtro);
	
	List<ActividadCampo> obtenerTodosRangoDeFechas(Date fechaInicio, Date fechaFin);

}
