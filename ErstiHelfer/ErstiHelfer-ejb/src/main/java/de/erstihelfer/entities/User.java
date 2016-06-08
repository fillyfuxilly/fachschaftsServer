package de.erstihelfer.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Amayda Dominguez
 * @author Malte Evers
 *
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	// private static int lastID = 0;
	@Id
	@GeneratedValue
	private int id;

	@Column(unique = true, nullable = false)
	private String username;

	private int groupNr;
	private boolean isAdmin;

	@ManyToMany(mappedBy = "users")
	private Collection<Appointment> appointments;

	public User() {
	}

	public User(String username, int groupNr) {

		// this.id = ++lastID;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
