package de.erstihelfer.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import de.erstihelfer.entities.Appointment;
import de.erstihelfer.entities.ErstiHelferSession;
import de.erstihelfer.entities.User;

/**
 * 
 * @author Amayda Dominguez 
 * @author Malte Evers
 * 
 * Interface für das Persistenzmanagement, hier sind
 *         die abstrakte Methoden, die die Session Bean implementiert, bei
 *         Technologiewechsel muss nur die DAO-Implementierung ausgetauscht
 *         werden
 * 
 * 
 **/
@Local
public interface ErstiHelferDAOLocal {

	public String getServerStatus();

	public void addGroupToAppointment(int groupNr, int appointmentID);
	public void createAppointment(Appointment appointment);
	public List<Appointment> getAppointments(Date timestamp, int count, int groupNr);
	public Appointment findAppointmentByTitle(String title);
	public User createUser(String username, int group);
	public ErstiHelferSession findSessionById(int id);
     
    public User findUserByName(String username);
	public int createSession(User user);
	public void closeSession(int id);
	public User update(User user);
}
