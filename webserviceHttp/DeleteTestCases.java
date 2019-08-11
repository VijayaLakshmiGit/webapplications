package com.webserviceHttp;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webserviceutility.ServiceUtility;

public class DeleteTestCases extends ServiceUtility {
	@Test
	public void deleteData() throws ClientProtocolException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/120";
		HttpResponse response = deleterequest(url);
		printresponse(response);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK");

	}

	@Test
	public void deleteNonexistedvData() throws ClientProtocolException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/120";
		HttpResponse response = deleterequest(url);
		printresponse(response);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 404);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "Not Found");

	}

}
