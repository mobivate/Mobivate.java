package com.rawmobility.blender.demo;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.rawmobility.blender.demo.dto.BatchMessageMultiBody;
import com.rawmobility.blender.demo.dto.BatchMessageSingleBody;
import com.rawmobility.blender.demo.dto.BatchRecipientMultiBody;
import com.rawmobility.blender.demo.dto.XMLResponseWrapper;

public class BulkXmlApi extends BaseXmlApi {

	public static final String XMLAPI_URL = "https://app.mobivatebulksms.com/bulksms/xmlapi";

	public BulkXmlApi(String username, String password) {
		super(XMLAPI_URL, username, password);
	}

	public XMLResponseWrapper sendBatch(BatchMessageSingleBody batch) throws JAXBException, IOException {
		String xml = MarshallerFactory.marshal(batch);

		XMLResponseWrapper xmlResponse = httpPost(URLConstants.SENDSMS_BATCH, xml);
		return xmlResponse;

	}

	public XMLResponseWrapper sendBatch(BatchMessageMultiBody batch) throws JAXBException, IOException {
		String xml = MarshallerFactory.marshal(batch);

		XMLResponseWrapper xmlResponse = httpPost(URLConstants.SENDSMS_BATCH, xml);
		return xmlResponse;

	}

	public XMLResponseWrapper sendSingle(String originator, String recipient, String body, String routeId,
			String reference) throws JAXBException, IOException {
		BatchRecipientMultiBody batchRec = new BatchRecipientMultiBody();
		batchRec.setOriginator(originator);
		batchRec.setRecipient(recipient);
		batchRec.setBody(body);
		batchRec.setReference(reference);
		batchRec.setRouteId(routeId);

		String xml = MarshallerFactory.marshal(batchRec);

		XMLResponseWrapper xmlResponse = httpPost(URLConstants.SENDSMS_SINGLE, xml);
		return xmlResponse;

	}
}
