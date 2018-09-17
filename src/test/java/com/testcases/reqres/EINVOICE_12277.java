package com.testcases.reqres;

import java.io.File;

import org.testng.annotations.Test;

import com.core.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json_java.Criteria;
import com.json_java.CriteriaGroup;
import com.json_java.FilterAPI;
import com.json_java.Pagination;
import com.json_java.ParentCriteria;

public class EINVOICE_12277 {
	
	@Test
	public void test1() throws Exception {
	String url=URL.getEndPoint("/einvoice/soa-services/restapi/attachment/filter");
	
	Criteria criteria = new Criteria("name", "EQUALS", "screenshot-1.png", 0,1);
	
	CriteriaGroup criteriaGroupObject = new CriteriaGroup();
	criteriaGroupObject.setCriteria(criteria);
	criteriaGroupObject.setLogicalOperator("OR");
	Pagination paginationObject = new Pagination(10, 11, 12);
	ParentCriteria criteriaGroup = new ParentCriteria("AND", criteriaGroupObject);
	
	  
	FilterAPI fp=new FilterAPI("abcd","sw","su", paginationObject,criteriaGroup);
//	System.out.println(fp.toString());
	
    ObjectMapper mapper =new ObjectMapper();//jackson-databind jar
     mapper.writeValue(new File(System.getProperty("user.dir")+"/payload/Search_Attachments_API.json"), fp);
	  String finalJson=mapper.writeValueAsString(fp);
	  System.out.println(finalJson);
//	  String createIssuePayLaod = PayloadGenerator.generatePayLoadString("Search_Attachments_API.json");
//	  Header h1= new Header("x-zycus-userId", "1dcacee3-ecea-4583-8872-b2351647dc3c");
//	  Header h2 = new Header("x-zycus-tenantId", "def68304-7e50-463c-95f5-7af9dcb4e600");
//	  List<Header> li=new ArrayList<Header>();
//	  li.add(h1);
//	  li.add(h2);
//	  Response res=RestCalls.POSTRequestWithHeader(url, createIssuePayLaod, li);
//	  System.out.println(res.asString());
//	  System.out.println();
//	  BaseAssertion.verifyStringContainsInResponse(res, "processingErrors");
//	  System.out.println(res.jsonPath().get("processingErrors"));
//	  System.out.println(res.jsonPath().get("pagination.totalRecords"));
	  
	}

}
