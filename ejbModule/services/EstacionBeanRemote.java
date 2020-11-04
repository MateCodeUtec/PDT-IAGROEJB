package services;

import javax.ejb.Remote;

import models.Estacion;

@Remote
public interface EstacionBeanRemote {
	
	void crear(Estacion estacion);

}
