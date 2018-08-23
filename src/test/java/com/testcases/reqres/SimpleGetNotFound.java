package com.testcases.reqres;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class SimpleGetNotFound {
 
	@Test(enabled=true,description="This test case not found the resource")
	public void GetWeatherDetails(){
		
		RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/api/users/23");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
        System.out.println("Status code is =>  " + response.getStatusCode());
		System.out.println("Status Line is =>  "  +(response.getStatusLine()));
	
		

	}
	

 
}