package com.json_java;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attributes {
	
	private String brand;
	

	private String parent_product_name;
	
	@JsonProperty("unit of measure")
    private String unit_of_measure;
	
    private Integer quantity;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getParent_product_name() {
		return parent_product_name;
	}
	public void setParent_product_name(String parent_product_name) {
		this.parent_product_name = parent_product_name;
	}
	public String getUnit_of_measure() {
		return unit_of_measure;
	}
	public void setUnit_of_measure(String unit_of_measure) {
		this.unit_of_measure = unit_of_measure;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Attributes [brand=" + brand + ", parent_product_name=" + parent_product_name + ", unit of measure="
				+ unit_of_measure + ", quantity=" + quantity + "]";
	}
	
	
}
