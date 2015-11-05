package com.rawmobility.blender.demo.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BatchRecipientSingleBody {

	private String id;
	private BatchMessageRecipientType type;
	private String recipient;

	public BatchRecipientSingleBody() {
	}

	public BatchRecipientSingleBody(BatchMessageRecipientType type, String recipient) {
		this.type = type;
		this.recipient = recipient;
	}

	public BatchMessageRecipientType getType() {
		return type;
	}

	public void setType(BatchMessageRecipientType type) {
		this.type = type;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
