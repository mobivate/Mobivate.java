package com.rawmobility.blender.demo.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "session")
public class AuthenticationSession  {

	
	private String sessionId;

	public AuthenticationSession() {
	}

	public AuthenticationSession(String sessionId) {
		this.setSessionId(sessionId);
	
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@XmlValue
	public String getSessionId() {
		return sessionId;
	}

}
