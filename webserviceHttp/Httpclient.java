package com.webserviceHttp;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;

public class Httpclient {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/1";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		System.out.println("=========anusfsdfdfsd==ffff======");

		HttpResponse response = client.execute(request);

		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK");

	}
}
