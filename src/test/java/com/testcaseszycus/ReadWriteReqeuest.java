package com.testcaseszycus;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.core.PayloadGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.json_java.POJORead2;
import com.json_java.Postpayload;


public class ReadWriteReqeuest {
	@DataProvider(name="dp")
	public Object[][] getData(){
		return new Object[][]{ {"apple","large","White",100},{"mango","medium","Yellow",111},{"guava","small","Grren",111}};
	}
	
	@Test
	public void read1() {
		  String createIssuePayLaod = PayloadGenerator.generatePayLoadString("CheckAllmethod.json");
		  System.out.println(createIssuePayLaod);
		  String fruitname= JsonPath.read(createIssuePayLaod,"$.fruit").toString().replace("[","").replace("]","");
		  String size= JsonPath.read(createIssuePayLaod,"$.size").toString().replace("[","").replace("]","");
		  String color=JsonPath.read(createIssuePayLaod,"$.color").toString().replace("[","").replace("]","");
		  System.out.println(fruitname);
		  System.out.println(size);
		  System.out.println(color);
		
	}
	
	@Test(dataProvider="dp")
	public void write1(String fname,String fsize,String fcolor,int fprize) {
		  String createIssuePayLaod = PayloadGenerator.generatePayLoadString("CheckAllmethod.json");
		  JSONObject js=new JSONObject(createIssuePayLaod);
		  js.put("fruit", fname);
		  js.put("size", fsize);
		  js.put("color", fcolor);
		  String finalJson = ((Object) js).toString();
		  System.out.println(finalJson);
		
	}
	
	@Test(dataProvider="dp")
	public void writepojo(String fname,String fsize,String fcolor,int fprize) throws JsonProcessingException, ParseException {
		 ObjectMapper mapper =new ObjectMapper();//jackson-databind jar
		 POJORead2 ph=new POJORead2(fname, fcolor, fsize,fprize);
		 POJORead2 ph1=new POJORead2(fname, fcolor, fsize,null);//if you want pass null,and not also no need to print in response use
		  String s1=mapper.writeValueAsString(ph);
		  String s2=mapper.writeValueAsString(ph1);
		 // JSONParser parser = new JSONParser(); 
		  JSONObject json = new JSONObject(s1);
		  JSONObject json1 = new JSONObject(s2);


		System.out.println(json);
		System.out.println(json1);
		//  System.out.println(s1);
		
	}
		@Test
		public void read() throws IOException {
		String payload=new String(Files.readAllBytes(Paths.get("/Users/ashiwani.ranjan/git/API_Automation_Framework/payload/test")));
		JSONObject existingPreferenceObject = new JSONObject(payload);
	    JSONObject jsonChildObject = (JSONObject) existingPreferenceObject.get("criteriaGroup");
	    JSONArray result = jsonChildObject.getJSONArray("criteriaGroup");
	    JSONObject result1 = result.getJSONObject(0);
	    System.out.println("jsonChildObject --> : " +jsonChildObject);
		 
		
	}
	
//    @Test
//    public void connect() throws Exception{
//        MongoClient mongo = new MongoClient( "3.0.20.228" , 27018 );
//        DB db = mongo.getDB("test");
//        System.out.print(db.getCollectionNames());
//    }

}
