package com.testcaseszycus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.common.RestCalls;
import com.constants.StatusCode;
import com.core.BaseAssertion;
import com.core.URL;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class Fiter_API {
	private static Logger log = LogManager.getLogger(Fiter_API.class.getName());
	Response response;
	
	@Test(description="This test case will ",priority=1)
	  public void getFilterAPI() {
		  log.info("Starting posting of data");
		  String URI=URL.getEndPoint("/einvoice/soa-services/restapi/invoice/filter/","8a9494b6-5e3208ee-015e-328e3d3e-00a2");
		  //String createIssuePayLaod = PayloadGenerator.generatePayLoadString("TestCreate.json");
		  Header h1=new Header("x-zycus-userId","57fb9986-58a8-4d4e-8848-2ab2346307bd");
		  Header h2=new Header("x-zycus-trackingNumber","457");
		  Header h3=new Header("x-zycus-tenantId","9010062a-f20c-4ad0-af0e-e3384c234f21");
		  List<Header> li=new ArrayList<Header>();
		  li.add(h1);
		  li.add(h2);
		  li.add(h3);
		  response = RestCalls.GETRequestWithHeader(URI, li);
		  System.out.println(response.asString());
		  System.out.println(response.jsonPath().get("businessEntity.entityData.filterId"));
		  BaseAssertion.verifyStatusCode(response, StatusCode.RESPONE_STATUS_CODE_200_OK);
		  BaseAssertion.verifyStringContainsInResponse(response, "8a9494b6-5e3208ee-015e-328e3d3e-00a2");

  }
}
