package com.rawmobility.blender.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "batchmulti")
@XmlSeeAlso({ BatchRecipientMultiBody.class })
public class BatchMessageMultiBody extends BatchMessage {

	private List<BatchRecipientMultiBody> recipients;

	public BatchMessageMultiBody() {
		recipients = new ArrayList<BatchRecipientMultiBody>();
	}

	@XmlElementWrapper(name = "recipients")
	@XmlElements({ @XmlElement(name = "recipient", type = BatchRecipientMultiBody.class) })
	public List<BatchRecipientMultiBody> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<BatchRecipientMultiBody> recipients) {
		this.recipients = recipients;

	}

	public void addRecipient(String originator, String recipient, String body, String reference, String routeId) {

		if ((originator == null) && (this.getOriginator() == null))
			throw new IllegalArgumentException("You must set the Originator on either the Batch or the Recipient");

		if (recipient == null)
			throw new IllegalArgumentException("You must set the Recipient number");

		if ((body == null) && (this.getBody() == null))
			throw new IllegalArgumentException("You must set the Body on either the Batch or the Recipient");

		if ((routeId == null) && (this.getRouteId() == null))
			throw new IllegalArgumentException("You must set the Route ID on either the Batch or the Recipient");

		BatchRecipientMultiBody rec = new BatchRecipientMultiBody(originator, recipient, body, reference, routeId);

		recipients.add(rec);
	}

	public void addRecipient(String originator, String recipient, String body, String reference) {
		addRecipient(originator, recipient, body, reference, null);
	}

	public void addRecipient(String recipient, String body, String reference) {
		addRecipient(null, recipient, body, reference, null);
	}

	public void addRecipient(String recipient, String body) {
		addRecipient(null, recipient, body, null, null);
	}

}
