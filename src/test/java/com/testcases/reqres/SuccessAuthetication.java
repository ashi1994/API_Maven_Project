package com.testcases.reqres;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.common.RestCalls;
import com.core.BaseAssertion;
import com.core.PayloadGenerator;
import com.core.URL;
import io.restassured.response.Response;

public class SuccessAuthetication {
	private static Logger log = LogManager.getLogger(SuccessAuthetication.class.getName());
	Response response;
	
	 @Test(description="this test case for post request with correct credential and verify is it creating token or not")
	  public void successFul() {
		  log.info("Starting posting of data");
		  String URI=URL.getEndPoint("/api/register");
		  String createIssuePayLaod = PayloadGenerator.generatePayLoadString("Correctauthetication.json");
		  response = RestCalls.POSTRequest(URI,createIssuePayLaod);
		  System.out.println(response.asString());
		  BaseAssertion.verifyStatusCode(response, 201);
		  BaseAssertion.verifyStringContainsInResponse(response, "token");
	  }
	 
	 
	 @Test(description="this test case for post request with incorrect credential and verify is it sending error message or not")
	  public void unSuccessFul() {
		  log.info("Starting posting of data");
		  String URI=URL.getEndPoint("/api/register");
		  String createIssuePayLaod = PayloadGenerator.generatePayLoadString("InCorrectauthetication.json");
		  response = RestCalls.POSTRequest(URI,createIssuePayLaod);
		  System.out.println(response.asString());
		  BaseAssertion.verifyStatusCode(response, 400);
		  BaseAssertion.verifyStringContainsInResponse(response, "Missing");
	  }

}
