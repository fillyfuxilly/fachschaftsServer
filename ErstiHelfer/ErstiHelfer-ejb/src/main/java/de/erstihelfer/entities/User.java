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
 *
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private int id;
	
	@Column(unique=true, nullable=false)
	private String username;

	private int groupNr;
	
	@ManyToMany
	@JoinTable(name = "GROUP_APPOINTMENT", joinColumns = {@JoinColumn(name = "GROUPNR", referencedColumnName= "GROUPNR")},
    inverseJoinColumns = {@JoinColumn(name = "APPOINTMENT_ID", referencedColumnName= "ID")})
	List<Appointment> appointments= new ArrayList<Appointment>();

	public User(){}
	public User(String username, int groupNr){
		
	
		this.username = username;
	    this.groupNr = groupNr;
		
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
}
