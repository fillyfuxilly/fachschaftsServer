package de.erstihelfer.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


/**
 * @author Amayda Dominguez
 * @author Malte Evers
 * 
 *         Termine der O-Woche. 
 *         Erstsemester sollen erfahren, wann und wo sie als nächstes hinlaufen müssen
 */
@Entity
public class Appointment implements Serializable {

	private static final long serialVersionUID = 1L;
	private static int lastID = 0;
	@Id @GeneratedValue
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

  @ManyToMany(mappedBy="appointments")
    Set<User> users=new HashSet<User>();
    
	public Appointment() {
	}

	public Appointment(String title, String location, Date startTime, String description) {
		this.id = ++lastID;
		this.title = title;
		this.location = location;
		this.startTime = startTime;
		this.description = description;
		this.createdAt = new Date(); // now
	}

	public String getTitel() {
		return title;
	}

	public void setTitel(String titel) {
		this.title = titel;
	}

	public String getOrt() {
		return location;
	}

	public void setOrt(String ort) {
		this.location = ort;
	}

	public Date getZeitpunkt() {
		return startTime;
	}

	public void setZeitpunkt(Date zeitpunkt) {
		this.startTime = zeitpunkt;
	}

	public String getBeschreibung() {
		return description;
	}

	public void setBeschreibung(String beschreibung) {
		this.description = beschreibung;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getErstelltAm() {
		return createdAt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}