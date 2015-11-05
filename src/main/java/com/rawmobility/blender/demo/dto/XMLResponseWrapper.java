package com.rawmobility.blender.demo.dto;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.rawmobility.blender.demo.dto.AuthenticationResponse.AuthenticationResponseCode;

@XmlRootElement(name = "xaresponse")
@XmlSeeAlso({ BatchMessageMultiBody.class, BatchMessageSingleBody.class, ExceptionResponse.class, AuthenticationResponse.class, AuthenticationSession.class })
public class XMLResponseWrapper {

	protected AuthenticationResponse authentication;
	private Object body;
	private AuthenticationSession session;

	public XMLResponseWrapper() {
		this.authentication = new AuthenticationResponse(AuthenticationResponseCode.OK);
	}

	public XMLResponseWrapper(AuthenticationResponseCode responseCode) {

		this.authentication = new AuthenticationResponse(responseCode);
	}

	public XMLResponseWrapper(AuthenticationResponseCode responseCode, String body) {
		this.setBody(body);
		this.authentication = new AuthenticationResponse(responseCode);
	}

	public XMLResponseWrapper(AuthenticationResponseCode responseCode, Object body) {
		this.body = body;
		this.authentication = new AuthenticationResponse(responseCode);
	}

	public void setAuthentication(AuthenticationResponse authentication) {
		this.authentication = authentication;
	}

	public void setAuthentication(AuthenticationResponseCode code) {
		this.authentication = new AuthenticationResponse(code);
	}

	public AuthenticationResponse getAuthentication() {
		return authentication;
	}

	public boolean isAuthenticated() {
		return (authentication.getCode() == AuthenticationResponseCode.OK.value);
	}

	public XMLResponseWrapper setBody(Object body) {
		this.body = body;
		return this;
	}

	public void setBody(String body) {
		System.out.println("Body: " + body);
		this.body = body;
		/*
		 * ByteArrayInputStream bs = new ByteArrayInputStream(body.getBytes());
		 * DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		 * DocumentBuilder db; try { db = dbf.newDocumentBuilder(); Document doc
		 * = db.parse(bs); doc.getDocumentElement().normalize(); this.body =
		 * doc.getFirstChild(); } catch (Exception e) { e.printStackTrace();
		 * return this.setBody(new ExceptionResponse(e)); } return this;
		 */
	}

	@XmlAnyElement(lax = true)
	public Object getBody() {
		return body;
	}


}
