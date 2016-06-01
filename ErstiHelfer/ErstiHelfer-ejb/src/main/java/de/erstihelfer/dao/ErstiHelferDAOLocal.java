package de.erstihelfer.dao;

import java.util.Date;

import javax.ejb.Local;

import de.erstihelfer.entities.Appointment;
import de.erstihelfer.entities.User;

/**
 * 
 * @author Amayda Dominguez
 * Interface für das Persistenzmanagement, hier sind die abstrakte Methoden, die die Session Bean implementiert, bei Technologiewechsel 
 * muss nur die DAO-Implementierung ausgetauscht werden
 * 
 * 
 * **/
@Local
public interface ErstiHelferDAOLocal {

	public Appointment findAppointmentByStarttime(Date starttime);
	public User createUser(String username, int group);
	public User findUserByName(String username);
	public int createSession(User user);
	public void closeSession(int id);
	
}
