package com.rawmobility.blender.demo.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ExceptionResponse {
	private String description;
	private String source;
	private int code = ErrorCode.GENERIC.value;

	public ExceptionResponse() {

	}

	public ExceptionResponse(Exception e) {
		this.description = ((e.getMessage() == null) ? e.toString() : e
				.getMessage());
		this.source = e.getClass().getSimpleName();
	}

	public ExceptionResponse(Exception e, ErrorCode code) {
		this(e);
		this.code = code.value;
	}

	public ExceptionResponse(String description, String source) {
		this.description = description;
		this.source = source;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return source;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public enum ErrorCode {
		GENERIC(1), VALIDATION(2), NO_PERMISSION(3), STALE_UPDATE(4), INSUFFICIENT_CREDIT(20);

		int value;

		ErrorCode(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static final ErrorCode valueOf(int t)
				throws IllegalArgumentException {
			for (ErrorCode code : values()) {
				if (code.value == t) {
					return code;
				}
			}
			throw new IllegalArgumentException(
					"No enum const ErrorCode with value " + t);
		}
	}

}
