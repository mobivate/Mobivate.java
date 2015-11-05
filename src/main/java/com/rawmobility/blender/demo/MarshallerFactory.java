package com.rawmobility.blender.demo;

import javax.xml.bind.JAXBException;

import com.rawmobility.blender.demo.dto.BatchMessageMultiBody;
import com.rawmobility.blender.demo.dto.BatchMessageSingleBody;
import com.rawmobility.blender.demo.dto.BatchRecipientMultiBody;

public class MarshallerFactory {

	private static GenericXMLMarshaller<BatchMessageMultiBody> marshallerMulti;
	private static GenericXMLMarshaller<BatchMessageSingleBody> marshallerSingle;
	private static GenericXMLMarshaller<BatchRecipientMultiBody> marshallerRecipient;

	private MarshallerFactory() {

	}

	public static GenericXMLMarshaller<BatchMessageMultiBody> getMarshallerBatchMultiBody() throws JAXBException {
		//if (marshallerMulti == null)
			marshallerMulti = new GenericXMLMarshaller<BatchMessageMultiBody>(BatchMessageMultiBody.class);

		return marshallerMulti;
	}

	public static GenericXMLMarshaller<BatchMessageSingleBody> getMarshallerBatchSingleBody() throws JAXBException {
		//if (marshallerSingle == null)
			marshallerSingle = new GenericXMLMarshaller<BatchMessageSingleBody>(BatchMessageSingleBody.class);

		return marshallerSingle;
	}
	
	public static GenericXMLMarshaller<BatchRecipientMultiBody> getMarshallerBatchRecipient() throws JAXBException {
		//if (marshallerRecipient == null)
			marshallerRecipient = new GenericXMLMarshaller<BatchRecipientMultiBody>(BatchRecipientMultiBody.class);

		return marshallerRecipient;
	}

	public static String marshal(BatchMessageMultiBody batch) throws JAXBException {
		return getMarshallerBatchMultiBody().marshal(batch);
	}

	public static String marshal(BatchMessageSingleBody batch) throws JAXBException {
		return getMarshallerBatchSingleBody().marshal(batch);
	}

	public static BatchMessageMultiBody unmarshalMulti(String xml) throws JAXBException {
		return getMarshallerBatchMultiBody().unmarshal(xml);
	}

	public static BatchMessageSingleBody unmarshalSingle(String xml) throws JAXBException {
		return getMarshallerBatchSingleBody().unmarshal(xml);
	}
	
	public static String marshal(BatchRecipientMultiBody recipient) throws JAXBException {
		return getMarshallerBatchRecipient().marshal(recipient);
	}

	public static BatchRecipientMultiBody unmarshalRecipient(String xml) throws JAXBException {
		return getMarshallerBatchRecipient().unmarshal(xml);
	}


}
