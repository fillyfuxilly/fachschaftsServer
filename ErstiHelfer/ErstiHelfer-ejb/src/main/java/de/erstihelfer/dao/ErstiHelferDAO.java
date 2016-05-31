package de.erstihelfer.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * 
 * @author Amayda Dominguez
 * DAO-Session Bean für das Persistenzmanagement
 * 
 * **/
@Stateless
public class ErstiHelferDAO {
	
/**
 * EntityManager-Aufrufe
 */
	@PersistenceContext
	private EntityManager em;
	
	
}
