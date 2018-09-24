package com.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class TestUtils {
	
	private static Logger log = LogManager.getLogger(TestUtils.class.getName());
	
	public static String getResposeString(Response response){
		log.info("Converting Response to String");
		String strResponse = response.getBody().asString();
		log.debug(strResponse);
		return strResponse;
	}
	
	public static JsonPath jsonParser(String response){
		log.info("Parsing String Response to JSON");
		JsonPath jsonResponse = new JsonPath(response);
		log.debug(jsonResponse);
		return jsonResponse;
	}
	

	public static XmlPath xmlParser(String response){
		log.info("Parsing String Response to XML");
		XmlPath xmlResponse = new XmlPath(response);
		log.debug(xmlResponse);
		return xmlResponse;
	}
	
	public static int getStatusCode(Response response){
		log.info("Getting Response Code");
		int statusCode = response.getStatusCode();
		log.info(statusCode);
		return statusCode;
	}
	
	public static String getStatusMessage(Response response){
		log.info("Getting Response Message");
		String responseMessage = response.getStatusLine();
		log.info(responseMessage);
		return responseMessage;
	}
	public static String getResponceFormat(Response response){
		log.info("Getting response format");
		String responseFormat = response.contentType();
		log.info(responseFormat);
		return responseFormat;
	}	
	
	public static String getUrl(){
		FileInputStream reader;
		Properties pr;
		String URL="";
		try {
			reader = new FileInputStream(System.getProperty("user.dir")+"/"+"src/test/resource/app.properties");
			pr=new Properties();
			pr.load(reader);
			URL=pr.getProperty("BaseUrl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return URL;
	}
	
	public static Properties getMessagePropery(){
		FileInputStream reader;
		Properties pr1 = null;
		try {
			reader = new FileInputStream(System.getProperty("user.dir")+"/"+"src/test/resource/mail.properties");
			pr1=new Properties();
			pr1.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pr1;
	}
	
		
	
}
