package com.webserviceHttp;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webserviceutility.ServiceUtility;

public class JsondataGetcall extends ServiceUtility {
	@Test
	public void testWithSuccessData() throws ClientProtocolException, IOException, JAXBException, JSONException {
		String url = "https://reqres.in/api/users/2";
		HttpResponse response = getrequest(url);
		System.out.println(response);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK");

		String responsestr = EntityUtils.toString(response.getEntity(), "UTF-8");
		System.out.println(responsestr);
		String actual = "{id:2,email:'janet.weaver@reqres.in'}";
		String actual1 = "{first_name:'Janet',last_name:'Weaver'}";
		JSONAssert.assertEquals("{id:2,email:'janet.weaver@reqres.in'}", actual, true);
		JSONAssert.assertEquals("{first_name:'Janet',last_name:'Weaver'}", actual1, true);

	}
}
