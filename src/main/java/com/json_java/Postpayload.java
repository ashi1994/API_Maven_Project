package com.json_java;

public class Postpayload {
	
		 private String name;
		 private String job;


		 // Getter Methods 

		 public String getName() 
		 {
		  return name;//morpheus
		 }

		 public String getJob() 
		 {
		  return job;//leader
		 }

		 // Setter Methods 

		 public void setName(String name) {
		  this.name = name;
		 }

		 public void setJob(String job) {
		  this.job = job;
		 }
		 
		 public Postpayload(String name,String job) {
			 this.name=name;
			 this.job=job;
		 }
		}
