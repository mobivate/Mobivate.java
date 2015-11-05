package com.rawmobility.blender.demo;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.rawmobility.blender.demo.dto.AuthenticationSession;
import com.rawmobility.blender.demo.dto.XMLResponseWrapper;

public class BaseXmlApi {

	int maxRetries = 3;

	final String url;
	final String username;
	final String password;
	String session;

	HttpClient httpClient;
	GenericXMLMarshaller<XMLResponseWrapper> responseMarshaller;

	public BaseXmlApi(String apiUrl, String username, String password) {
		if (!apiUrl.endsWith("/"))
			apiUrl += "/";

		this.url = apiUrl;
		this.username = username;
		this.password = password;

		this.initHttpClient();
	}

	private void initHttpClient() {
		httpClient = new HttpClient();
		httpClient.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler(maxRetries, true));

	}

	protected GenericXMLMarshaller<XMLResponseWrapper> getResponseMarshaller() throws JAXBException {
		if (responseMarshaller == null) {
			responseMarshaller = new GenericXMLMarshaller<XMLResponseWrapper>(XMLResponseWrapper.class);
		}

		return responseMarshaller;
	}

	public boolean isAuthenticated() {
		return (this.session != null);
	}

	protected String getUrl(String part) {
		return this.url + session + part;
	}

	public boolean login() {
		this.session = null;
		String loginUrl = this.url + "login/" + username + "/" + password;

		HttpMethod method = new GetMethod(loginUrl);

		XMLResponseWrapper response;
		try {
			int statusCode = httpClient.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
				return false;
			}

			String xml = method.getResponseBodyAsString();

			response = getResponseMarshaller().unmarshal(xml);
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		} finally {
			method.releaseConnection();
		}
		if (!response.isAuthenticated()) {
			System.err.println("Authentication failed: " + response.getAuthentication().getText());
			return false;
		}

		AuthenticationSession s = (AuthenticationSession) response.getBody();
		session = s.getSessionId();
		System.out.println("Logged in: (" + username + "/" + password + ") " + session);
		return true;
	}

	protected XMLResponseWrapper httpPost(String urlPart, String xml) throws IOException, JAXBException {
		String url = getUrl(urlPart);		
		PostMethod method = new PostMethod(url);
		method.setParameter("xml", xml);

//		System.out.println("POST request: " + url + "\n" + xml);

		long timerStart = System.nanoTime();
		int statusCode = httpClient.executeMethod(method);
		String took = String.format("%.5g", (Float.valueOf(System.nanoTime() - timerStart) / 1000000000));

		if (statusCode != HttpStatus.SC_OK) {
			throw new IOException("HTTP Post Failed: " + method.getStatusLine());
		}

		String xmlResponse = method.getResponseBodyAsString();
//		System.out.println("POST response (" + took + ") :\n" + xml);
		try {
			return getResponseMarshaller().unmarshal(xmlResponse);
		} catch (JAXBException e) {
			System.out.println("Unable to parse response: " + xmlResponse);
			throw e;
		}
	}
}
