package com.rawmobility.blender.demo.dto;

public enum BatchMessageRecipientType {
	CONTACT(0), MAILINGLIST(1), MSISDN(2);

	private final int type;

	BatchMessageRecipientType(int type) {
		this.type = type;
	}

}