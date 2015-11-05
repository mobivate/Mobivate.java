package com.rawmobility.blender.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "batchsingle")
@XmlSeeAlso({ BatchRecipientSingleBody.class })
public class BatchMessageSingleBody extends BatchMessage {

	// Whether to filter duplicates
	private boolean filterDuplicaets = true;

	private List<BatchRecipientSingleBody> recipients;

	public BatchMessageSingleBody() {
		recipients = new ArrayList<BatchRecipientSingleBody>();
	}

	@XmlElementWrapper(name = "recipients")
	@XmlElements({ @XmlElement(name = "recipient", type = BatchRecipientSingleBody.class) })
	public List<BatchRecipientSingleBody> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<BatchRecipientSingleBody> recipients) {
		this.recipients = recipients;
	}

	public boolean isFilterDuplicaets() {
		return filterDuplicaets;
	}

	public void setFilterDuplicaets(boolean filterDuplicaets) {
		this.filterDuplicaets = filterDuplicaets;
	}

	public void addRecipient(BatchMessageRecipientType type, String recipient) {
		BatchRecipientSingleBody rec = new BatchRecipientSingleBody(type, recipient);
		recipients.add(rec);
	}

	public void addMSISDN(String msisdn) {
		BatchRecipientSingleBody rec = new BatchRecipientSingleBody(BatchMessageRecipientType.MSISDN, msisdn);
		recipients.add(rec);
	}

	public void addMailingList(String mailingListId) {
		BatchRecipientSingleBody rec = new BatchRecipientSingleBody(BatchMessageRecipientType.MAILINGLIST,
				mailingListId);
		recipients.add(rec);
	}

	public void addContact(String contactId) {
		BatchRecipientSingleBody rec = new BatchRecipientSingleBody(BatchMessageRecipientType.CONTACT, contactId);
		recipients.add(rec);
	}

}
