package services;

import java.util.List;

import javax.ejb.Remote;

import models.TipoParametro;

@Remote
public interface TipoParametroBeanRemote {

	TipoParametro crear(TipoParametro tipoParametro) throws Exception;

	void actualizar(TipoParametro tipoParametro) throws Exception;

	void borrar(Long id) throws Exception;

	List<TipoParametro> obtenerTodos();

	List<TipoParametro> obtenerTodos(String filtro);

}
