package com.json_java;

public class MainPojo {
	private Attributes attributes;
	private Bar_code bar_code;
	private String category_id;
	private Meta meta;
	
	
	public MainPojo() {
		
	}
	
	public MainPojo(Attributes attributes, Bar_code bar_code, String category_id, Meta meta) {
		super();
		this.attributes = attributes;
		this.bar_code = bar_code;
		this.category_id = category_id;
		this.meta = meta;
	}
	
	
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public Bar_code getBar_code() {
		return bar_code;
	}
	public void setBar_code(Bar_code bar_code) {
		this.bar_code = bar_code;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}


	@Override
	public String toString() {
		return "{" + attributes + ", bar_code=" + bar_code + ", category_id=" + category_id
				+ ", meta=" + meta + "}";
	}
	
	
	
	

}
