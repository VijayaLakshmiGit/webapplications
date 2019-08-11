package com.webserviceHttp;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webserviceutility.ServiceUtility;
import com.webserviceutility.XmlParserUtil;

public class PostRequestTest extends ServiceUtility {
	// @Test
	public void postwithcorrectdata() throws ClientProtocolException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/";
		String postmessage = "<CUSTOMER> " + "<FIRSTNAME>anil</FIRSTNAME>" + "<LASTNAME>Snyder</LASTNAME>\r\n"
				+ "<ID>222" + "</ID>" + "<STREET>2732 BakerBlvd.</STREET>" + "<CITY>sacramento</CITY>" + "</CUSTOMER>";
		System.out.println("%%%%%%%%%%%" + postmessage);
		HttpResponse response = postrequest(url, postmessage);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 201);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "Created");
		printresponse(response);
	}

	// @Test
	public void postwithexisteddata() throws ClientProtocolException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER";
		String postmessage = "<CUSTOMER> " + "<ID>112</ID>" + "<FIRSTNAME>Howard</FIRSTNAME>"
				+ "<LASTNAME>Snyder</LASTNAME>\r\n" + "<STREET>2732 Baker Blvd.</STREET>" + "<CITY>sacramento</CITY>"
				+ "</CUSTOMER>";
		HttpResponse response = postrequest(url, postmessage);
		// Assert.assertEquals(response.getStatusLine().getStatusCode(), 500);
		// Assert.assertEquals(response.getStatusLine().getReasonPhrase(),
		// "Internal Server Error");
		printresponse(response);
	}

	@Test
	public void postwithparser() throws JAXBException, ClientProtocolException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/";
		Customer customer2 = new Customer();
		customer2.setId(52);
		customer2.setFirstname("jane");
		customer2.setLastname("watson");
		customer2.setStreet("stevenson");
		customer2.setCity("fremont");
		System.out.println("=======+++++++++========");

		String xmlstr = XmlParserUtil.javaobjecttoxml(customer2);
		HttpResponse response = postrequest(url, xmlstr);

		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getStatusLine().getReasonPhrase());

		Assert.assertEquals(response.getStatusLine().getStatusCode(), 201);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "Created");

	}
}
