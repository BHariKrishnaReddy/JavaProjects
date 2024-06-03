package com.example.restfulWebService.restfulWebServices.users;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserRescourse {
	
	@Autowired
	private UserDaoService service;

	public UserRescourse(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<Users> retreviallUsers(){
		return service.findAll();
	}
//	
//	@GetMapping("/users/{id}")
//	public EntityModel<Users> retreviaUser(@PathVariable int id){
//		Users user = service.findOne(id);
//		if(user == null) 
//			throw new UserNotFoundException("The id you looked for" + id);
//		
//		EntityModel<Users> entityModel = EntityModel.of(user);
//		
//		WebMvcLinkBuilder link = (WebMvcLinkBuilder) WebMvcLinkBuilder.methodOn(this.getClass()).retreviallUsers();
//		
//		entityModel.add(link.withRel("all-users"));
//		
//		return entityModel;
//	}
	
	  
	@PostMapping("/users")
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
		Users savedUser = service.saveUser(user) ;
		URI location = ServletUriComponentsBuilder
									.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(savedUser.getId()).toUri() ;
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		service.deleteById(id);
	}
	
} 
