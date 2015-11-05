package com.rawmobility.blender.demo.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
public class BatchRecipientMultiBody {
	String id;
	String originator;
	String recipient;
	String body;
	String reference;
	String routeId;

	public BatchRecipientMultiBody() {

	}

	public BatchRecipientMultiBody(String originator, String recipient, String body, String reference, String routeId) {
		this.originator = originator;
		this.recipient = recipient;
		this.body = body;
		this.reference = reference;
		this.routeId = routeId;
	}

	public String getOriginator() {
		return originator;
	}

	public void setOriginator(String originator) {
		this.originator = originator;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

}
