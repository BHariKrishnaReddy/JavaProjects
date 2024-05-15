package com.example.lab;

public class Course {

	
	private int id;
	private String name;
	private String author;
	
	public Course(int i, String name, String author) {
		super();
		this.id = i;
		this.name = name;
		this.author = author;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
	
	
}
