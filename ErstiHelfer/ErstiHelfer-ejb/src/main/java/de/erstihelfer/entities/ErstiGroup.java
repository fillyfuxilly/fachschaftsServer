package de.erstihelfer.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Amayda Dominguez
 * @author Malte Evers
 * 
 *         Die Erstis werden Gruppen mit einer Gruppennummer zugewiesen
 */
@Entity
public class ErstiGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	//private static int lastID = 0;
	@Id @GeneratedValue
	private int groupNr;

	/*@OneToMany
	Set<User> users = new HashSet<User>();*/

	@ManyToMany
	private Collection<Appointment> appointments;

	public ErstiGroup() {
	}

	public ErstiGroup(int groupNr) {
		this.groupNr = groupNr;
	}

	public int getGroupNr() {
		return groupNr;
	}

	public void setGroupNr(int groupNr) {
		this.groupNr = groupNr;
	}

}
