package de.erstihelfer.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import de.erstihelfer.entities.Appointment;
import de.erstihelfer.entities.ErstiHelferSession;
import de.erstihelfer.entities.User;

/**
 * 
 * @author Amayda Dominguez Interface für das Persistenzmanagement, hier sind
 *         die abstrakte Methoden, die die Session Bean implementiert, bei
 *         Technologiewechsel muss nur die DAO-Implementierung ausgetauscht
 *         werden
 * 
 * 
 **/
@Local
public interface ErstiHelferDAOLocal {

	public String getServerStatus();

	public User createUser(String username, int group);
	public ErstiHelferSession findSessionById(int id);

    public User findUserByName(String username);
    public void createAppointment(Appointment appointment);
    //Laut Systementwurf getAppointment(Date timestamp, int count, int GroupNr). wurde aber geändert
    public List<Appointment> getAppointment(Date timestamp, int count, User user);
	public int createSession(User user);
	public void closeSession(int id);

}
