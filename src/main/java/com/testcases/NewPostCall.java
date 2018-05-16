package com.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.common.RESTCalls;
import com.core.BaseAssertion;
import com.core.PayloadGenerator;
import com.core.URL;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


public class NewPostCall {
	private static Logger log = LogManager.getLogger(NewPostCall.class.getName());
	Response response;
  @Test
  public void f() {
	    log.info("Starting getting tha data");
		String URI = URL.getEndPoint("/api/users?page=2");
		response=RESTCalls.GETRequest(URI);
		BaseAssertion.verifyStatusCode(response, 200);
		//System.out.println(System.getProperty("user.dir"));
  }
  
  @Test
  public void g() {
	  log.info("Starting posting of data");
	  String URI=URL.getEndPoint("/api/users");
	  String createIssuePayLaod = PayloadGenerator.generatePayLoadString("Postpayload.json");
	  response = RESTCalls.POSTRequest(URI,createIssuePayLaod);
	  BaseAssertion.verifyStatusCode(response, 201);
  }
}
