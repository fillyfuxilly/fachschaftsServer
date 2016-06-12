package de.erstihelfer.dto;
/**
 * 
 * @author Amayda Dominguez
 *
 */
public class UserTO {

	private String username;
	private int groupNr;
	private int id;

	public UserTO() {
	}

	public UserTO(String username) {

		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setGroupNr(int groupNr) {
		this.groupNr = groupNr;
	}

	public String getUsername() {
		return username;
	}

	public int getGroupNr() {
		return groupNr;
	}
}
