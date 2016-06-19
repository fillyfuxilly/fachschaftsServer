package de.erstihelfer.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Amayda Dominguez
 * @author Malte Evers
 *
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	/**
	 * Eindeutige Username mit dem man sich anmelden kann
	 */
	@Column(unique = true, nullable = false)
	private String username;

	/**
	 * Zu welcher Gruppe man gehört. Man kann sich mit dem username und
	 * Gruppennummer anmelden
	 */
	private int groupNr;

	@ManyToMany
	 @JoinTable(name = "GROUP_APPOINTMENT", joinColumns = {
		@JoinColumn(name = "GROUPNR") }, inverseJoinColumns = {
					@JoinColumn(name = "APPOINTMENT_ID") })
	List<Appointment> appointments = new ArrayList<Appointment>();

	public User() {
	}

	/**
	 * 
	 * @param username
	 * @param groupNr
	 */
	public User(String username, int groupNr) {

		this.username = username;
		this.groupNr = groupNr;
	}

	/**
	 * 
	 * @return Liste aller Termine für den User
	 */
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void addAppointment(Appointment a) {
		if (!getAppointments().contains(a)) {
			getAppointments().add(a);
		}
		if (!a.getUsers().contains(this)) {
			a.getUsers().add(this);
		}
	}

	public String getUsername() {
		return username;
	}

	public int getGroupNr() {
		return groupNr;
	}

	public int getId() {
		return id;
	}

	public void setId(int userId) {
		this.id = userId;
	}

	public void setGroup(int groupNr) {
		this.groupNr = groupNr;
	}
}
