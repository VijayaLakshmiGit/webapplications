package com.webserviceHttp;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webserviceutility.JsonParserUtil;
import com.webserviceutility.ServiceUtility;

public class JsondataPostcall {
	@Test
	public void postData() throws IOException {
		String url = "https://reqres.in/api/users/";
		User user = new User();
		Data data = new Data();
		data.setId(13);
		data.setFirst_name("anastasia");
		data.setLast_name("tiffany");
		data.setEmail("anastasia.tiffany@reqres.in");
		data.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
		user.setData(data);

		String jsonstr = JsonParserUtil.ObjecttojsonUser(user);
		HttpResponse response = ServiceUtility.postrequest(url, jsonstr);
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getStatusLine().getReasonPhrase());

		Assert.assertEquals(response.getStatusLine().getStatusCode(), 201);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "Created");

	}

}
