package com.testcases.reqres;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class SimplePostTest {
 
	@Test(description="This test case for validate post call")
	public void GetWeatherDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://reqres.in/";
 
		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		// Post the request and check the response
				
 
		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		//Response response = httpRequest.request(Method.POST, "/api/users");
 
//		// Now let us print the body of the message to see what response
//		// we have recieved from the server
//		String responseBody = response.getBody().asString();
//		System.out.println("Response Body is =>  " + responseBody);
//		int scode=response.getStatusCode();
//		System.out.println("Status code is =>  " + scode);
//		
//		/*
//		response.getBody();
//		response.getHeaders();
//		String statusline=response.getStatusLine();//First part is Http protocol (HTTP/1.1). Second is Status Code (200). Third is the Status message (OK).
//		int scode=response.getStatusCode();//it will give status code
//		
//		//Validate Response Status Code using Rest-Assured
//		assertEquals(scode, 200);
//		//Validating Response Status Line using Rest-Assured
//		assertEquals(statusline, "HTTP/1.1 200 OK");
		JSONObject requestParams = new JSONObject();
		requestParams.put("job", "leader"); 
		requestParams.put("name", "ashi");
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		httpRequest.body(requestParams.toJSONString());

		// Post the request and check the response
		Response response = httpRequest.post("/api/users/2");
		Response response1 = httpRequest.post("/api/users/2");

         int statusCode = response.getStatusCode();
         int statusCode1 = response1.getStatusCode();
       
     	System.out.println("The status code recieved: " + statusCode);
      
     	System.out.println("Response body: " + response.body().asString());
     	System.out.println("Response body: " + response1.body().asString());
     	assertEquals(statusCode, 201,"something wrong");		
	}
 
}