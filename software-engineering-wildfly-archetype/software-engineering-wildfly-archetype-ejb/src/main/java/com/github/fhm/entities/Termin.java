package com.github.fhm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Termin implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;
	private Date timestamp;

	
	@ManyToOne
	private User besitzer;
	
	public Termin(){}
	
	public Termin(User besitzer){
		this.besitzer=besitzer;
		
		
	}
	
	
	public int getId() {
		return id;
	}
	
}
