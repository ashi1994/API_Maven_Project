package com.base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseClassAPI {
	public void setUp(){
	RestAssured.baseURI="https://reqres.in/";
	RequestSpecification httpRequest = RestAssured.given();
	
	}
}
