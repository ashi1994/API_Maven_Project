package com.json_java;

public class Criteria {
//	"fieldName":"name", 
//	"operation":"EQUALS", 
//	"value":"screenshot-1.png", 
//	"minValue":0, 
//	"maxValue":1 
	
	String name; 
	String operation;
	String value; 
	int minValue; 
	int maxValue;
	
	
	public Criteria() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getMinValue() {
		return minValue;
	}
	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	
	
	public Criteria(String name, String operation, String value, int minValue, int maxValue) {
		this.name = name;
		this.operation = operation;
		this.value = value;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	@Override
	public String toString() {
		return "Criteria [name=" + name + ", operation=" + operation + ", value=" + value + ", minValue=" + minValue
				+ ", maxValue=" + maxValue + "]";
	}
	
	


}
