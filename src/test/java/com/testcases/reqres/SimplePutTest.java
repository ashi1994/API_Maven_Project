package com.testcases.reqres;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class SimplePutTest {
 
	@Test(description="This test case for validate put configuration")
	public void validateDelete()
	{   
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject js=new JSONObject();
		js.put("name","ashiwani");
		js.put("job", "It");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(js.toJSONString());
		//PUT to create and update existing resources and it will give same result if you call multiple time(i.e idempotent)
		Response response = httpRequest.put("/api/users/2");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
        System.out.println("Status code is =>  " + response.getStatusCode());
		System.out.println("Status Line is =>  "  +(response.getStatusLine()));
		assertEquals(response.getStatusCode(), 200);
	}
 
}