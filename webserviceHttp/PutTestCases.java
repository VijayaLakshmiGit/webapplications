package com.webserviceHttp;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.webserviceutility.ServiceUtility;

public class PutTestCases extends ServiceUtility {
	@Test
	public void testwithexisteddata() throws ClientProtocolException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/10";
		String putmessage = "<CUSTOMER> " + "<ID>10</ID>" + "<FIRSTNAME>anusha</FIRSTNAME>"
				+ "<LASTNAME>Snyder</LASTNAME>\r\n" + "<STREET>4291 stevenson blvd</STREET>" + "<CITY>fremont</CITY>"
				+ "</CUSTOMER>";
		HttpResponse response = putrequest(url, putmessage);
		System.out.println(response.toString());
		// Assert.assertEquals(response.getStatusLine().getStatusCode(), 201);
		// Assert.assertEquals(response.getStatusLine().getReasonPhrase(),
		// "Created");
		printresponse(response);
	}
}
