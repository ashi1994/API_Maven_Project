package com.json_java;

public class Postpayload {

	private String name;
	private String job;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Postpayload(String name, String job) {
		this.name = name;
		this.job = job;
	}
	

}
