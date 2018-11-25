package com.json_java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Finalclass {

	
	public static void main(String s[]) throws Exception {
		
		Attributes attributes = new Attributes();
		
		Bar_code bar = new Bar_code();
		
		
		Meta meta = new Meta();
		
		String mainPojo = "{\"attributes\":{\"brand\":\"kevins\",\"parent_product_name\":\"Test SPIN Create for Different UOM\", "
				+ "\"unit of measure\":\"L\",\"quantity\":10},\"bar_code\":{\"valid\":true,\"id\":\"543210\",\"type\":\"UPC\"},"
				+ "\"category_id\":\"638627ghdgkhja\",\"meta\":{\"created_by\":\"ashiwani\"}}\n" + 
				"";
		
		
		//MainPojo mainPojo = new MainPojo(attributes, bar, "638627ghdgkhja", meta);
		
		//System.out.println(mainPojo);
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
		MainPojo main = objectMapper.readValue(mainPojo, MainPojo.class);
		
	//	System.out.println(objectMapper.writeValueAsString(main));
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
}
