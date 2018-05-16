package com.testcases;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class SimpleGetTest {
 
	@Test(description="This test case for validate the get resource")
	public void GetWeatherDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://reqres.in/";
 
		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
 
		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		//Response response = httpRequest.request(Method.GET, "/api/users?page=2");
		Response response = httpRequest.get("/api/users?page=2");
		//Response response = httpRequest.request(Method.POST, "/api/users");
 
		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		
		System.out.println("Response Body is =>  " + responseBody);
        System.out.println("Status code is =>  " + response.getStatusCode());
		System.out.println("Status Line is =>  "  +(response.getStatusLine()));
		System.out.println("Content type is => "+(response.contentType()));
		
		List<String> ls=response.jsonPath().getList("id");
		System.out.println("ID "+ls);
	
		
		/*
		response.getBody();
		response.getHeaders();
		String statusline=response.getStatusLine();//First part is Http protocol (HTTP/1.1). Second is Status Code (200). Third is the Status message (OK).
		int scode=response.getStatusCode();//it will give status code
		
		//Validate Response Status Code using Rest-Assured
		assertEquals(scode, 200);
		//Validating Response Status Line using Rest-Assured
		assertEquals(statusline, "HTTP/1.1 200 OK");
 
 */
	}
 
}