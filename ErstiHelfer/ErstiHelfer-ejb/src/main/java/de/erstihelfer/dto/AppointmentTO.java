package de.erstihelfer.dto;

import java.util.Date;

/**
 * 
 * @author Amayda Dominguez
 * 
 *         AppointmentTo ermöglicht es uns, den Client unabhängig vom
 *         POJO-Modell zu halten. Zwar könnten wir auch die Modellklassen direkt
 *         an den Client weitergeben, da sie normale Java-Klassen sind.
 */

public class AppointmentTO extends DataTransferObject {
	private static final long serialVersionUID = -1044563636105941958L;

	private int id;
	/**
	 * Titel des Termins
	 */
	private String title;
	/**
	 * Wo findet der Termin statt?
	 */
	private String location;
	/**
	 * Wann trifft man sich?
	 */
	private Date startTime;
	/**
	 * genauere Beschreibung
	 */
	private String description;
	/**
	 * timestamp für Erstellung des Termins
	 */
	private Date createdAt;

	public AppointmentTO() {
	}

	// TODO: Appoinment Konstruktor
	/**
	 * 
	 * @param id
	 * @param title
	 * @param location
	 * @param startTime
	 * @param description
	 */
	public AppointmentTO(int id, String title, String location, Date startTime, String description) {
		super();
		this.id = id;

	}
	/**
	 * 
	 * @return title
	 */
	public String getTitel() {
		return title;
	}

	public void setTitel(String titel) {
		this.title = titel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String ort) {
		this.location = ort;
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

	public Date getCreateAt() {
		return createdAt;
	}

	public void setCreateAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
