package com.github.fhm.entities;

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

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private static int lastID = 0;
	@Id @GeneratedValue
	private int id;
	
	@Column(unique=true, nullable=false)
	private String username;
	
	private String password;
	
	private String name;
	
	private int groupNr;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="owner")
	@MapKey
<<<<<<< HEAD
	private Map<Integer,Appointment> termine;
=======
	private Map<Integer,Appointment> appointment;
>>>>>>> 56e5ec164fd87d69b521f5d008d7cfd92b1cf1a1
	
	public User(String username, String password){
		
		this.id = ++lastID;
		this.username = username;
		this.password = password;		
		
	}
	public String getUserName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getId() {
		return id;
	}

	public void setId(int customerId) {
		this.id = customerId;
	}
}
