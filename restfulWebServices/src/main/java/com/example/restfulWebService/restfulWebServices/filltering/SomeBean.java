package com.example.restfulWebService.restfulWebServices.filltering;

import com.fasterxml.jackson.annotation.JsonFilter;

// use @JsonIgnore mostly y if field name changes you should in many places
//static filter field wise or can use @JsonIgnoreProperties("field2") on top the class

@JsonFilter("someBeanFIlter2") //dynamic filter check controller for code
public class SomeBean {
	
	private String field1;
	
	
	private String field2;
	private String field3;
	
	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3; 
	}

	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}

}