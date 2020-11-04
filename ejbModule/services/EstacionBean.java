package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;


import models.Estacion;

/**
 * Session Bean implementation class EstacionBean
 */
@Stateless
public class EstacionBean implements EstacionBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public EstacionBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void crear(Estacion estacion) {
		try{
			em.persist(estacion);
			em.flush();
		}catch(PersistenceException e){
			throw new PersistenceException("No se pudo crear el area");
		}
		
	}

}
