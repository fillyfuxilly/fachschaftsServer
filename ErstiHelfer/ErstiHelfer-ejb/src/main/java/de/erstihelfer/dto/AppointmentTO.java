package de.erstihelfer.dto;

import java.util.Date;

/**
 * 
 * @author Amayda Dominguez
 * AppointmentTo ermöglichte es uns, den Client unabhängig vom POJO-Modell zu halten. Zwar könnten  wir  auch  die  Modellklassen direkt an den Client weitergeben, da sie
 *  normale Java-Klassen sind.
 */

public class AppointmentTO extends DataTransferObject{
	private static final long serialVersionUID = -1044563636105941958L;
	
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
	
	
	public AppointmentTO() {
	}

    //TODO: Appoinment Konstruktor
	
	/*public AppointmentTO() {
		super();
		this.id = id;
		
	}*/
	
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

	public Date getErstelltAm() {
		return createdAt;
	}
    
	public void setErstelltAm(Date createdAt) {
		this.createdAt=createdAt;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
