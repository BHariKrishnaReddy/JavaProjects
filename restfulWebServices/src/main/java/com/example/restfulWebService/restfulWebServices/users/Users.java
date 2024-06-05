package com.example.restfulWebService.restfulWebServices.users;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class Users {
	
	protected Users() {}
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private  List<Post> posts; //one user can post many things so this field is 1 to many
 	
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}
	
	
}
