package com.core;


import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class JSONReader {
	static Object object=null;
	
	private static Logger log = LogManager.getLogger(JSONReader.class.getName());
	public static Object parseReader(String filename){
		log.info("Inside pasreJSON function");
		JSONParser parser = new JSONParser();
		String filePath = System.getProperty("user.dir")+"\\payload\\"+filename;
		try {
			object = parser.parse(new FileReader(filePath));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
		
	}
	
}
