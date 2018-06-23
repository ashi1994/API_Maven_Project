package com.testcases;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class SimpleDelete {
 
	@Test(description="This test case for validate delete resource")
	public void validateDelete()
	{   
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.delete("/api/users/2");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
        System.out.println("Status code is =>  " + response.getStatusCode());
		System.out.println("Status Line is =>  "  +(response.getStatusLine()));
		assertEquals(response.getStatusCode(), 204);
	}
 
}