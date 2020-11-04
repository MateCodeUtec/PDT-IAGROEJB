package services;

import java.util.List;

import javax.ejb.Remote;

import models.RolFuncionalidad;

@Remote
public interface RolFuncionalidadBeanRemote {

	void crear(RolFuncionalidad rolFuncionalidad) throws Exception;

	void actualizar(RolFuncionalidad rolFuncionalidad) throws Exception;

	void borrar(Long id) throws Exception;

	List<RolFuncionalidad> obtenerTodos();

	List<RolFuncionalidad> obtenerTodos(String filtro);

}
