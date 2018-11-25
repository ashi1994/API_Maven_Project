package com.json_java;

public class Bar_code {

	private boolean valid;
    

	private String id;
    private String type;
    
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Bar_code {valid=" + valid + ", id=" + id + ", type=" + type + "}";
	}
    
    
	
}
