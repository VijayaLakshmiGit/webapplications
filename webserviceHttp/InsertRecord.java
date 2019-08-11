package com.webserviceHttp;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webserviceutility.ReadExcelData_util;
import com.webserviceutility.ServiceUtility;

public class InsertRecord extends ServiceUtility {
	@DataProvider(name = "dp")
	public Object[][] postdatareadexcel() throws Exception {
		ReadExcelData_util data = new ReadExcelData_util();
		return data.ReadExcelData("D:/eclipse work space/webserviceHttp/Excelsheets/httpexceldata.xlsx",
				"httpexceldata.xlsx", "httppostdata");

	}

	@Test(dataProvider = "dp")
	public void InsertData(String id, String firstname, String lastname, String street, String city)
			throws ClientProtocolException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER";

		String postmessage = "<CUSTOMER> " + "<ID>" + id + "</ID>" + "<FIRSTNAME>" + firstname + "</FIRSTNAME>"
				+ "<LASTNAME>" + lastname + "</LASTNAME>\r\n" + "<STREET>" + street + "</STREET>" + "<CITY>" + city
				+ "</CITY>" + "</CUSTOMER>";
		System.out.println("=================");
		System.out.println(postmessage);
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost postrequest = new HttpPost(url);
		StringEntity stringentity = new StringEntity(postmessage);
		postrequest.setEntity(stringentity);
		HttpResponse response = client.execute(postrequest);
		// Assert.assertEquals(response.getStatusLine().getStatusCode(), 201);
		// Assert.assertEquals(response.getStatusLine().getReasonPhrase(),
		// "Created");
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getStatusLine().getReasonPhrase());

	}

	// @Test
	public void puttest() throws Exception, IOException {
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
