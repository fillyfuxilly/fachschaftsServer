package de.erstihelfer.entities;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
/**
 * 
 * @author Amayda Dominguez
 *
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private static int lastID = 0;
	@Id @GeneratedValue
	private int id;
	
	@Column(unique=true, nullable=false)
	private String username;

	
	private String name;
	
	private int groupNr;
	
	@MapKey
	private Map<Integer,Appointment> appointment;
	
	public User(){}
	public User(String username, int groupNr){
		
		this.id = ++lastID;
		this.username = username;
	    this.groupNr = groupNr;
		
	}
	public String getUserName() {
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
}
