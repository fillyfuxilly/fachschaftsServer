package de.erstihelfer.dto;
/**
 * 
 * @author Amayda Dominguez
 *
 */
public class UserTO extends DataTransferObject{
	
	private static final long serialVersionUID = -1044563636105941958L;
	
	private String username;
	private int groupNr;
	private int id;

	public UserTO() {
	}
/**
 * 
 * @param id
 * @param username
 * @param groupNr
 */
	public UserTO(int id, String username, int groupNr) {
        super();
        this.id=id;
		this.username = username;
		this.groupNr=groupNr;
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
