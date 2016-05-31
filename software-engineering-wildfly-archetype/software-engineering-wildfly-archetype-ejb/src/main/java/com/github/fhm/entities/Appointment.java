package com.github.fhm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
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


	public Appointment() {
	}

	public Appointment(String title, String location, Date startTime, String description) {
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

	public User getBesitzer() {
		return besitzer;
	}

	public void setBesitzer(User besitzer) {
		this.besitzer = besitzer;
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