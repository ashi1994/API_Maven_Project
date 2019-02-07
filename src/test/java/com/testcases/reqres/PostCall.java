package com.testcases.reqres;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.core.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.RestCalls;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json_java.Postpayload;

import io.restassured.response.Response;


public class PostCall {
	private static Logger log = LogManager.getLogger(PostCall.class.getName());
	Response response;
	JsonSchemaUtil util=new JsonSchemaUtil();
	
	
  @Test(description="This test case for get request")
  public void f() throws Exception {
	    log.info("Starting getting tha data");
		String URI = URL.getEndPoint("/api/users?page=2ttstt");
		response=RestCalls.GETRequest(URI);
		String resstring=response.asString();
		String jsonschema=new ToolBox().readFileAsString(System.getProperty("user.dir")+"/payload/JSONSchema/postcall.txt");
	    List<String> missingNodeList=util.validateServiceSchema(jsonschema,resstring);
	    Assert.assertTrue(missingNodeList.isEmpty(),missingNodeList + " Nodes Are Missing Or Not Matching ");
	    boolean isEmpty=util.hasEmptyNodes(resstring);
	    System.out.println("Contain empty nodes => " + isEmpty);
	    Assert.assertEquals( false,isEmpty,"Found Empty Nodes in Response");

		System.out.println(response.getBody().asString());
		System.out.println(response.asString());
		BaseAssertion.verifyStatusCode(response, 200);
		System.out.println(response.contentType());
		//System.out.println(System.getProperty("user.dir"));
  }
  
  @Test(description="This test case for post request")
  public void g() throws JsonGenerationException, JsonMappingException, IOException {
	  log.info("Starting posting of data");
	  String URI=URL.getEndPoint("/api/users");
	  ObjectMapper mapper =new ObjectMapper();//jackson-databind jar
	  Postpayload pr=new Postpayload("ashiwani1","Engineer");
	  mapper.writeValue(new File(System.getProperty("user.dir")+"/payload/Postpayload.json"), pr);
	  String s1=mapper.writeValueAsString(pr);
	  System.out.println(s1);
	  String createIssuePayLaod = PayloadGenerator.generatePayLoadString("Postpayload.json");
	  response = RestCalls.POSTRequest(URI,createIssuePayLaod);
	  System.out.println(response.asString());
	  BaseAssertion.verifyStatusCode(response, 201);
  }
}
