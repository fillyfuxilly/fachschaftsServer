package de.erstihelfer.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Amayda Dominguez Der User kann ein Fachschaftsmitglieder oder ein
 *         Erstsemester sein
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	/**
	 * Die Erstsemetern werden sich mit der Gruppennummer und username anmelden.
	 */
	@Column(unique = true, nullable = false)
	private String username;

	@ManyToOne
	private ErstiGroup group;

	public User() {
	}

	public User(String username, int groupNr) {
		this.username = username;
		this.group = new ErstiGroup(groupNr);
	}

	public String getUsername() {
		return username;
	}

	public int getId() {
		return id;
	}

	public void setId(int userId) {
		this.id = userId;
	}

	public ErstiGroup getGroup() {
		return group;
	}

	public void setGroup(ErstiGroup group) {
		this.group = group;
	}
}
