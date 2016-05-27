package com.github.fhm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Termin implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;
	private Date timestamp;
	private int anzahl;
	
	
	public Termin(){}
	
	
	public int getId() {
		return id;
	}
	
}
