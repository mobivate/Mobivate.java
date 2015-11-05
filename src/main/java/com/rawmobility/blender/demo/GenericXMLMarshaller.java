package com.rawmobility.blender.demo;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@SuppressWarnings("rawtypes")
public class GenericXMLMarshaller<T> {

	Class _class;
	JAXBContext jaxbContext;
	Marshaller marshaller;
	Unmarshaller unmarshaller;

	public GenericXMLMarshaller(Class _class) throws JAXBException {
		this._class = _class;
		this.jaxbContext = JAXBContext.newInstance(_class);
		this.marshaller = jaxbContext.createMarshaller();
		this.unmarshaller = jaxbContext.createUnmarshaller();
	}

	public synchronized String marshal(T object) throws JAXBException {
		StringWriter sw = new StringWriter();
		marshaller.marshal(object, sw);
		return sw.toString();
	}

	@SuppressWarnings("unchecked")
	public synchronized T unmarshal(String xml) throws JAXBException {
		ByteArrayInputStream xmlContentBytes = new ByteArrayInputStream(xml.getBytes());
		try {
			return (T) unmarshaller.unmarshal(xmlContentBytes);
		} catch (JAXBException e) {
			System.out.println("Unable to unmarshal:\n" + xml);
			throw e;
		}
	}

}
