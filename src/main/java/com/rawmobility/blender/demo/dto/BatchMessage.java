package com.rawmobility.blender.demo.dto;

import com.rawmobility.blender.demo.DateAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class BatchMessage {
	
	private String id;

	private String creatingUserId;
	
	// Message body
	private String body;

	// Message originator
	private String originator;

	// Route (specific)
	private String routeId;

	// When to deliver/process message(s)
	private Date deliverySchedule;

	// Which timezone to deliver/process message(s)
	private String deliveryTimeZone;

	// When to process recipients
	private boolean processOnDelivery = false;

	// Whether to filter optouts
	private boolean filterOptouts = true;

	// Whether to filter optouts
	private boolean detailedResponse = true;
	
	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getDeliverySchedule() {
		return deliverySchedule;
	}

	public void setDeliverySchedule(Date deliverySchedule) {
		this.deliverySchedule = deliverySchedule;
	}

	public String getDeliveryTimeZone() {
		return deliveryTimeZone;
	}

	public void setDeliveryTimeZone(String deliveryTimeZone) {
		this.deliveryTimeZone = deliveryTimeZone;
	}

	public boolean isProcessOnDelivery() {
		return processOnDelivery;
	}

	public void setProcessOnDelivery(boolean processOnDelivery) {
		this.processOnDelivery = processOnDelivery;
	}



	@XmlElement
	public String getDeliveryScheduleDestinationTime() {
		if (deliveryTimeZone != null && deliverySchedule != null) {
			TimeZone tz = TimeZone.getTimeZone(this.deliveryTimeZone);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
			sdf.setTimeZone(tz);
			return sdf.format(this.deliverySchedule);
		}
		return null;
	}

	public boolean isFilterOptouts() {
		return filterOptouts;
	}

	public void setFilterOptouts(boolean filterOptouts) {
		this.filterOptouts = filterOptouts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isDetailedResponse() {
		return detailedResponse;
	}

	public void setDetailedResponse(boolean detailedResponse) {
		this.detailedResponse = detailedResponse;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	

	public String getOriginator() {
		return originator;
	}

	public void setOriginator(String originator) {
		this.originator = originator;
	}

	public String getCreatingUserId() {
		return creatingUserId;
	}

	public void setCreatingUserId(String creatingUserId) {
		this.creatingUserId = creatingUserId;
	}
}
