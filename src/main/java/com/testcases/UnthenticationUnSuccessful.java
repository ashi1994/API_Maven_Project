package com.testcases;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class UnthenticationUnSuccessful {
 

	@Test(description="This test case valiadate the unsuceessful attempt")
	public void validateUnsuccessful()
	{   
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", "peter@klavenrrr");
		
		// Add a header stating the Request body is a JSON
				httpRequest.header("Content-Type", "application/json");

				// Add the Json to the body of the request
				httpRequest.body(requestParams.toJSONString());

				// Post the request and check the response
				Response response = httpRequest.post("/api/register");

		         int statusCode = response.getStatusCode();
		 
		     	System.out.println("The status code recieved: " + statusCode);
		      
		     	System.out.println("Response body: " + response.body().asString());
		     	
		     	assertEquals(statusCode, 201,"Something wrong looks like");
			
	}
 
}