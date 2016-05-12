package com.github.fhm.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private static int lastID = 0;
	@Id @GeneratedValue
	private int id;
	
	@Column(unique=true, nullable=false)
	private String userName;
	
	private String password;
	
	
	public User(String userName, String password){
		
		this.id = ++lastID;
		this.userName = userName;
		this.password = password;		
		
	}
	public String getUserName() {
		return userName;
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
