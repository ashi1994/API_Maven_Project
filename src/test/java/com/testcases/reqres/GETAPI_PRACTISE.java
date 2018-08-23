package com.testcases.reqres;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.common.RestCalls;
import com.core.BaseAssertion;
import com.core.PayloadGenerator;
import com.core.URL;

import io.restassured.response.Response;

public class GETAPI_PRACTISE {
	private static Logger log = LogManager.getLogger(GETAPI_PRACTISE.class.getName());
	Response response;
	  @Test(description="This test case for get request")
	  public void getSucess() {
		    log.info("Starting getting tha data");
			String URI = URL.getEndPoint("/api/users?page=2");
			response=RestCalls.GETRequest(URI);
			System.out.println(response.getBody().asString());
			System.out.println(response.asString());
			BaseAssertion.verifyStatusCode(response, 200);
			System.out.println(response.contentType());
			//System.out.println(System.getProperty("user.dir"));
	  }
	  
	  @Test(description="this test case for get but user found")
	  public void getNotSucess() {
		  log.info("Starting getting of data");
		  String URI=URL.getEndPoint("/api/users/23");
		  response=RestCalls.GETRequest(URI);
		  System.out.println(response.getBody().asString());
		  System.out.println(response.asString());
		  BaseAssertion.verifyStatusCode(response, 404);
	  }
	  
	  @Test(description="this test case for get with LIST resource")
	  public void getSucessReturnList() {
		  log.info("Starting getting of data");
		  String URI=URL.getEndPoint("/api/unknown");
		  response=RestCalls.GETRequest(URI);
		  System.out.println(response.getBody().asString());
		  System.out.println(response.asString());
		  BaseAssertion.verifyStatusCode(response, 200);
		  System.out.println(response.jsonPath().getList("data"));//for taking list which you want
		  System.out.println(response.jsonPath().get("data.name"));//for take a particular Values from response
	  }
	}


