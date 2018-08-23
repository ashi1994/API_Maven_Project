package com.common;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestCalls {
	/*
	 * This call will be responsible to Fire requests
	 */

	private static Logger log = LogManager.getLogger(RestCalls.class.getName());

	public static Response GETRequest(String URI) {
		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(URI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response POSTRequest(String URI, String strJSON) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(URI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response POSTRequest(String URI, String strJSON, String sessionID) {
		log.info("Inside POST Request call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("cookie", "JSESSIONID=" + sessionID + "");
		Response response = requestSpecification.post(URI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response PUTRequest(String URI, String strJSON) {
		log.info("Inside PUT Request call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(URI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response DELETERequest(String URI, String strJSON) {
		log.info("Inside DELETE Request call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(URI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response GETRequestWithHeader(String URI, List<Header> header) {
		log.info("Inside GET Request call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Headers he = new Headers(header);
		requestSpecification.headers(he);
		Response response = requestSpecification.get(URI);
		log.debug(requestSpecification.log().all());
		return response;
//	    Header h1= new Header("x-zycus-userId", "*/*");
//	    Header h2 = new Header("x-zycus-tenantId", "en-US");
//	    Header h3 = new Header("x-zycus-trackingNumber", "Mozilla/5.0");
//	    List<Header> list = new ArrayList<Header>();
//	    list.add(h1);
//	    list.add(h2);
//	    list.add(h3);

	}

	public static Response POSTRequestWithHeader(String URI, String strJSON) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(URI);
		requestSpecification.header("x-zycus-tenantId", "811619a2-29e6-4aab-9874-3ca6271403af");
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response POSTRequestWithQueryParam(String URI, String strJSON,String key,String value) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.queryParam(key,value);
		Response response = requestSpecification.post(URI);
		log.debug(requestSpecification.log().all());
		return response;
	}

}
