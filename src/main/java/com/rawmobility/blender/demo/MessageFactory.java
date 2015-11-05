package com.rawmobility.blender.demo;

import com.rawmobility.blender.demo.dto.BatchMessageMultiBody;
import com.rawmobility.blender.demo.dto.BatchMessageSingleBody;

public class MessageFactory {

	public static BatchMessageSingleBody createBatchSingleBody(String originator, String body, String routeId) {
		BatchMessageSingleBody batch = new BatchMessageSingleBody();
		batch.setOriginator(originator);
		batch.setBody(body);
		batch.setRouteId(routeId);
		return batch;
	}

	public static BatchMessageMultiBody createBatchMultiBody() {
		BatchMessageMultiBody batch = new BatchMessageMultiBody();
		return batch;
	}
	public static BatchMessageMultiBody createBatchMultiBody(String defaultOriginator, String defaultBody, String defaultRouteId) {
		BatchMessageMultiBody batch = new BatchMessageMultiBody();
		batch.setOriginator(defaultOriginator);
		batch.setBody(defaultBody);
		batch.setRouteId(defaultRouteId);
		return batch;
	}
}
