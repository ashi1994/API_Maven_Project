package com.testcaseszycus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.common.RestCalls;

import com.core.PayloadGenerator;
import com.core.URL;
import io.restassured.response.Response;

public class SearchAPI {
	private static Logger log = LogManager.getLogger(SearchAPI.class.getName());
	Response response;

	@Test(description="This test case will search api ",priority=1)
	  public void getFilterAPI() {
		  String URI=URL.getEndPoint("/einvoice/rest/einvoice/invoice/searchInvoices");
		  String createIssuePayLaod = PayloadGenerator.generatePayLoadString("SearchAPI.json");
		  JSONObject js=new JSONObject("createIssuePayLaod");
		  System.out.println(js.getJSONArray("conditions"));
		  response = RestCalls.POSTRequestWithQueryParam(URI, createIssuePayLaod,"tenantId","50179423-93a1-4dd9-8062-5ba7b7f6cd3c");
		  System.out.println(response.asString());
	}
}
