package de.erstihelfer.dto;

import de.erstihelfer.dto.UserTO;

public class UserLoginResponse {
	private static final long serialVersionUID = -3173158310918408228L;

	private int sessionId;
	private UserTO user;
	
	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public UserTO getUser() {
		return this.user;
	}

	public void setUser(UserTO user) {
		this.user = user;
	}

}


