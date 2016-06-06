package de.erstihelfer.dto;

public class UserTO {

	private String username;
	private int groupNr;
	
	public UserTO(){}
	public UserTO(String username){
		
		this.username=username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setGroupNr (int groupNr) {
		this.groupNr = groupNr;}
	
}
