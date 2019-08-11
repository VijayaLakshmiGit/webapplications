package com.webserviceHttp;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webserviceutility.ServiceUtility;
import com.webserviceutility.XmlParserUtil;

public class GetTestCases extends ServiceUtility {
	@Test
	public void TestWithSuccessData() throws ClientProtocolException, IOException, JAXBException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/49";
		HttpResponse response = getrequest(url);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK");

		String responsestr = EntityUtils.toString(response.getEntity());

		Assert.assertTrue(responsestr.contains("<ID>"));
		Assert.assertTrue(responsestr.contains("<FIRSTNAME>George</FIRSTNAME>"));
		Assert.assertTrue(responsestr.contains("<CITY>Olten</CITY>"));
		System.out.println("=========anu========");

		Customer c = XmlParserUtil.xmltojavaobject(responsestr);
		System.out.println(c);
		System.out.println(c.getFirstname());
		Assert.assertEquals(c.getCity(), "Olten");

	}

	// @Test
	public void TestWithNonDigitData() throws ClientProtocolException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/@";
		HttpResponse response = getrequest(url);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 404);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "Not Found");

	}

	// @Test
	public void TestWithBlankData() throws ClientProtocolException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/1";
		HttpResponse response = getrequest(url);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK");

	}

	// @Test
	public void TestWithNonExcistedDataData() throws ClientProtocolException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/100";
		HttpResponse response = getrequest(url);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 404);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "Not Found");

	}

	// @Test
	public void TestWithString() throws ClientProtocolException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/ANU";
		HttpResponse response = getrequest(url);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 404);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "Not Found");

	}

}
