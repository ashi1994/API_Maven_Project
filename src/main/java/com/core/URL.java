package com.core;
import io.advantageous.boon.core.Str;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Random;

public class URL {

	private static Logger log = LogManager.getLogger(URL.class.getName());
	public static final String URL = TestUtils.getUrl();
	
	
	public static String getEndPoint(){
		log.info("Base URI : " + URL);
		return URL;
	}
	
	public static String getEndPoint(String resource){
		log.info("URI End Point : " + URL + resource);
		return URL + resource;
	}	
	
	public static String getEndPoint(String resource,String postparam){
		log.info("URI End Point with Post Param : " + URL + resource + postparam);
		return URL + resource + postparam;
	}

	public static String GetRandomPhone(String countryCode){
		return  countryCode+String.format("9%03d%03d%03d",
				(int) Math.floor(999*Math.random()),
				(int) Math.floor(999*Math.random()),
				(int) Math.floor(999*Math.random()));
	}

	@Test
	public void t(){
		System.out.println(GetRandomPhone("91"));
	}

}
