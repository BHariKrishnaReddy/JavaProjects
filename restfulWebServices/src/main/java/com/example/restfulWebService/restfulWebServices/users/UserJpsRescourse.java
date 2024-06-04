package com.example.restfulWebService.restfulWebServices.users;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restfulWebService.restfulWebServices.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpsRescourse {
	
	@Autowired
	private UserDaoService service;
	
	private UserRepository repository;

	public UserJpsRescourse(UserDaoService service,UserRepository repository) {
		this.service = service;
		this.repository=repository;
	}
	
	@GetMapping("/jpa/users")
	public List<Users> retreviallUsers(){
		return repository.findAll();
	}
//	
//	@GetMapping("/jpa/users/{id}")
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
	
	  
	@PostMapping("/jpa/cusers")
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
		Users savedUser = service.saveUser(user) ;
		URI location = ServletUriComponentsBuilder
									.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(savedUser.getId()).toUri() ;
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		service.deleteById(id);
	}
	
} 
