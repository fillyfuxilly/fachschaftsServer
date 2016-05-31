package de.erstihelfer.dao;

import java.util.Date;

import javax.ejb.Local;

import de.erstihelfer.entities.Appointment;
import de.erstihelfer.entities.User;


@Local
public interface ErstiHelferDAOLocal {

	public Appointment findApointment(Date starttime);
	public User createUser(String username, String password, int group);
	public User findUserByName(String username);
	public int createSession(User user);
	public void closeSession(int id);
	
}
