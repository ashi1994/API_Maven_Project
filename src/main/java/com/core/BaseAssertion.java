package com.core;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.core.TestUtils;

import io.restassured.response.Response;

public class BaseAssertion {
	private static Logger log = LogManager.getLogger(TestUtils.class.getName());
	
	public static void verifyTrue(boolean flag){
		Assert.assertTrue(flag);
	}
	
	public static void verifyFalse(boolean flag){
		Assert.assertFalse(flag);
	}

	public static void verifyStatusCode(Response response, int code){
		Assert.assertEquals(TestUtils.getStatusCode(response), code);
	}
	
	public static void verifyStatusMessage(Response response, String status){
		Assert.assertEquals(TestUtils.getStatusMessage(response), status);
	}
	public static void verifyResponseFormat(Response response,String format){
		Assert.assertEquals(TestUtils.getResponceFormat(response), format);
	}
	
	/**
	 * This method will check whether the given String is present or not in Response body
	 * @param response
	 * @param expectedMatch
	 */
	
	public static void verifyStringContainsInResponse(Response response,String expectedMatch){
		Assert.assertTrue(TestUtils.getResposeString(response).contains(expectedMatch));
	}
}
