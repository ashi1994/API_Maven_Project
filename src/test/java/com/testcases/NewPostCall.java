package com.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.common.RESTCalls;
import com.core.BaseAssertion;
import com.core.PayloadGenerator;
import com.core.URL;
import io.restassured.response.Response;


public class NewPostCall {
	private static Logger log = LogManager.getLogger(NewPostCall.class.getName());
	Response response;
  @Test(description="This test case for get request")
  public void f() {
	    log.info("Starting getting tha data");
		String URI = URL.getEndPoint("/api/users?page=2ttstt");
		response=RESTCalls.GETRequest(URI);
		System.out.println(response.getBody().asString());
		System.out.println(response.asString());
		BaseAssertion.verifyStatusCode(response, 200);
		System.out.println(response.contentType());
		//System.out.println(System.getProperty("user.dir"));
  }
  
  @Test(description="this test case for post request")
  public void g() {
	  log.info("Starting posting of data");
	  String URI=URL.getEndPoint("/api/users");
	  String createIssuePayLaod = PayloadGenerator.generatePayLoadString("Postpayload.json");
	  response = RESTCalls.POSTRequest(URI,createIssuePayLaod);
	  System.out.println(response.asString());
	  BaseAssertion.verifyStatusCode(response, 201);
  }
}
