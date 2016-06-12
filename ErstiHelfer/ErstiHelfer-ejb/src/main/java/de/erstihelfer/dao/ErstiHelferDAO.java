package de.erstihelfer.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.erstihelfer.entities.Appointment;
import de.erstihelfer.entities.ErstiHelferSession;
import de.erstihelfer.entities.User;
import de.erstihelfer.dao.ErstiHelferDAOLocal;

/**
 * 
 * @author Amayda Dominguez DAO-Session Bean für das Persistenzmanagement
 *         Session Bean Implementation
 * 
 **/
@Stateless
public class ErstiHelferDAO implements ErstiHelferDAOLocal {

	/**
	 * EntityManager-Aufrufe
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * Die Methode findet gibt die Termine zurück nach dem Namen
	 *
	 * @see ErstihelferDAOLocal#findSessionById(int)
	 */
	public ErstiHelferSession findSessionById(int id) {
		return em.find(ErstiHelferSession.class, id);
	}

	/**
	 * Die Methode findet gibt die Termine zurück nach dem Namen
	 *
	 * @see ErstihelferDAOLocal#createSession(int)
	 */

	/**
	 * Die Methode findet gibt die Termine zurück nach dem Namen
	 *
	 * @see ErstihelferDAOLocal#closeSession(int)
	 */

	public void closeSession(int id) {
		ErstiHelferSession session = em.find(ErstiHelferSession.class, id);
		if (session != null) {
			em.remove(session);
		}
	}

	/**
	 * Die Methode findet gibt die Termine zurück nach dem Namen
	 *
	 * @see ErstihelferDAOLocal#findUserByName(int)
	 */

	public User findUserByName(String username) {
		List results = em.createQuery("SELECT u FROM User u WHERE u.username LIKE :usName")
				.setParameter("usName", username).getResultList();
		if (results.size() == 1) {
			return (User) results.get(0);
		} else {
			return null;
		}
	}

	public int createSession(User user) {
		ErstiHelferSession newSession = new ErstiHelferSession(user);
		em.persist(newSession);
		return newSession.getId();
	}

	//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public User createUser(String username, int groupNr) {
		if (findUserByName(username) == null)
		 {
		User user = new User(username, groupNr);
		em.persist(user);
		
		return user; }
	  else { 
		// Return null, if username already exists.
		return null; } }

	/*
	 * public List<Appointment> getAppointment(Date timestamp, int count, int
	 * groupNr) { // TODO: SELECT-Query List results = em.createQuery(
	 * "SELECT * FROM appointment a WHERE a.starttime >= GETDATE()  LIKE :appoint"
	 * ) .setParameter("appoint", timestamp).getResultList(); if (results.size()
	 * == 1) { return (List<Appointment>) results; } else { return null; } }
	 * 
	 */

	/**
	 * Die Methode findet gibt die Termine zurück nach dem Namen
	 *
	 * @see ErstihelferDAOLocal#createUse(int)
	 */
	

	/**
	-	 * Mit dieser Methode können die Erstis die Gruppennummer ändern
		 *  	 
	-	 * @see ErstihelferDAOLocal#changeGroup(int)
		 * 
	 	 **/
		
	public User update(User user){
		
		   return  em.merge(user);
     	
	       
    }
	

	
	@Override
	public String getServerStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
