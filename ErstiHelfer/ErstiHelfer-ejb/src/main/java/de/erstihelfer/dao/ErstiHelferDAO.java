package de.erstihelfer.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.erstihelfer.entities.Appointment;
import de.erstihelfer.entities.ErstiHelferSession;
import de.erstihelfer.entities.User;




/**
 * 
 * @author Amayda Dominguez
 * DAO-Session Bean für das Persistenzmanagement
 * 
 * **/
@Stateless
public class ErstiHelferDAO implements ErstiHelferDAOLocal {
	
/**
 * EntityManager-Aufrufe
 */
	@PersistenceContext
	private EntityManager em;
	
	public Appointment findApointment(Date starttime){
		return em.find(Appointment.class, starttime);
		
	}
	
	public User findUserByName(String username) {
    	List results = em.createQuery("SELECT c FROM User u WHERE u.username LIKE :usName")
    	                 .setParameter("usName", username)
    	                 .getResultList();
    	if (results.size()==1) {
    	    return (User) results.get(0);
    	}
    	else {
    		return null;
    	}
    }
	  public void closeSession(int id) {
		  ErstiHelferSession session = em.find(ErstiHelferSession.class, id);
	    	if (session != null) {
	    		em.remove(session);
	    	}
	    }
	  public int createSession(User user) {
		  ErstiHelferSession newSession = new ErstiHelferSession(user);
	        em.persist(newSession);
	        return newSession.getId();
	    }
	  public User createUser(String username,  int groupNr){
		  if(findUserByName(username) == null) {
				User user = new User(username, groupNr);
				em.persist(user);	
				return user;
			}
			else {
				//Return null, if username already exists.
				return null;
			}
		}
		  
		  
	  }

