package com.testcases.reqres;

import com.core.ToolBox;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringSubstitutor;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Test123 {

    public void test() {
        String url = "abcd.com";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        HashMap mp = new HashMap();
        mp.put("channel", "retailbank");
        requestSpecification.headers(mp);
        requestSpecification.queryParam("customettid", "abhfgjj");
        Response response = requestSpecification.request(Method.GET, url);
        System.out.println(response.getBody().asString());
        System.out.println(response.statusCode());
    }

    public void test12() throws Exception {
        String url = "abcd.com/v1/{customettid}/gygyy";
        String body = Parameterize(body("dhuduhudu"),new String[]{"sgsgs","hshu","iiii","uuu"});
        RequestSpecification requestSpecification = RestAssured.given().body(body);
        requestSpecification.contentType(ContentType.JSON);
        HashMap mp = new HashMap();
        mp.put("channel", "retailbank");
        requestSpecification.headers(mp);
        requestSpecification.param("customettid", "abhfgjj");
        Response response = requestSpecification.request(Method.POST, url);
        System.out.println(response.getBody().asString());
        System.out.println(response.statusCode());
    }

    public static String Parameterize(String PayloadRawString, String[] StringParameters) throws Exception {
        Map<String, String> valuesMap = new HashMap<String, String>();
        int paramnumber = 0;
        for (String param : StringParameters) {
            valuesMap.put(Integer.toString(paramnumber), param);
            paramnumber++;
        }
        String templateString = PayloadRawString;
        StringSubstitutor sub = new StringSubstitutor(valuesMap);
        String resolvedString = sub.replace(templateString);
        return resolvedString;
    }

    public String body(String filepath) throws Exception {
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(filepath));
        return IOUtils.toString(reader);
    }
}