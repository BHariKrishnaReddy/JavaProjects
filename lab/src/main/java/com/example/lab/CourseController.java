package com.example.lab;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@RequestMapping("/course")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
				new Course(1,"Course 1","Autor 1"),
				new Course(2,"Course 2","Autor 2")
				);
				
	}

	
	
}
