package com.example.restfulWebService.restfulWebServices.users;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Users {
	
	private int id;
	
	@Size(min =2 , message="Name should be atleast 2 chars")
	@JsonProperty("User_name")
	private String name;
	
	@Past(message="It should be in past")
	private LocalDate birthday;
	
	public Users(int id, String name, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}
	
}
