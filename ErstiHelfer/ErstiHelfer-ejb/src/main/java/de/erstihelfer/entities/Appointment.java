package de.erstihelfer.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author Amayda Dominguez
 * @author Malte Evers
 * 
 *         Termine der O-Woche. Erstsemester sollen erfahren, wann und wo sie
 *         als nächstes hinlaufen müssen
 */
@Entity
public class Appointment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue // (strategy=GenerationType.IDENTITY)Auto_increment
	private int id;
	private String title;
	// Wo findet der Termin statt?
	private String location;
	// Wann trifft man sich?
	private Date startTime;
	// genauere Beschreibung
	private String description;
	// timestamp für Erstellung des Termins
	private Date createdAt;

	@ManyToMany // TODO
	@JoinTable(name = "GROUP_APPOINTMENT", joinColumns = {
			@JoinColumn(name = "APPOINTMENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "GROUPNR", referencedColumnName = "GROUPNR") })
	Set<User> users = new HashSet<User>();

	public Appointment() {
	}

	public Appointment(String title, String location, Date startTime, String description) {
		this.title = title;
		this.location = location;
		this.startTime = startTime;
		this.description = description;
		this.createdAt = new Date(); // now
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getTitel() {
		return title;
	}

	public void setTitel(String titel) {
		this.title = titel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStarttime() {
		return startTime;
	}

	public void setStarttime(Date startTime) {
		this.startTime = startTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCreateAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreateAt() {
		return createdAt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}