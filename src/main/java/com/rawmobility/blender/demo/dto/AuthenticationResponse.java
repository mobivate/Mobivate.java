package com.rawmobility.blender.demo.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "authentication")
public class AuthenticationResponse {
	private String text;
	private int code;

	public AuthenticationResponse() {

	}

	public AuthenticationResponse(AuthenticationResponseCode code) {
		this(code, code.toString());
	}

	public AuthenticationResponse(int code, String text) {
		this.setCode(code);
		this.setText(text);
	}

	public AuthenticationResponse(AuthenticationResponseCode code, String text) {
		this(code.getValue(), text);
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setCode(AuthenticationResponseCode code) {
		this.code = code.getValue();
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public enum AuthenticationResponseCode {
		OK(0), INVALIDLOGIN(1), DISABLED(2), ERROR(3);

		int value;

		AuthenticationResponseCode(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

}
