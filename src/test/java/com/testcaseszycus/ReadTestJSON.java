package com.testcaseszycus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class ReadTestJSON {
	
	@Test
	public void read() throws IOException {
	String payload=new String(Files.readAllBytes(Paths.get("/Users/ashiwani.ranjan/git/API_Automation_Framework/payload/test")));
	JSONObject existingPreferenceObject = new JSONObject(payload);
    JSONObject jsonChildObject = (JSONObject) existingPreferenceObject.get("criteriaGroup");
    JSONArray result = jsonChildObject.getJSONArray("criteriaGroup");
    JSONObject result1 = result.getJSONObject(0);
    System.out.println("jsonChildObject --> : " +jsonChildObject);
 

	}
}
