package com.example.restfulWebService.restfulWebServices.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restfulWebService.restfulWebServices.jpa.PostRepositotry;
import com.example.restfulWebService.restfulWebServices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpsRescourse {
	
//	@Autowired
//	private UserDaoService service;
	
	private UserRepository repository;
	
	private PostRepositotry postRepositotry;

	public UserJpsRescourse(UserRepository repository,PostRepositotry postRepositotry) {
		this.postRepositotry = postRepositotry;
		this.repository=repository;
	}
	
	@GetMapping("/jpa/users")
	public List<Users> retreviallUsers(){
		return repository.findAll();
	}
//	
//	@GetMapping("/jpa/users/{id}")
//	public EntityModel<Users> retreviaUser(@PathVariable int id){
//		Optional<Users> user = repository.findById(id);
//		if(user.isEmpty()) 
//			throw new UserNotFoundException("The id you looked for" + id);
//		
//		EntityModel<Users> entityModel = EntityModel.of(user.get());
//		
//		WebMvcLinkBuilder link = linkTo(this.retreviallUsers());
//		
//		entityModel.add(link.withRel("all-users"));
//		
//		return entityModel;
//	}
	
	  
	@PostMapping("/jpa/cusers")
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
		Users savedUser = repository.save(user) ;
		URI location = ServletUriComponentsBuilder
									.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(savedUser.getId()).toUri() ;
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		repository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrivePostsForUsers(@PathVariable int id){
		
		Optional<Users> user = repository.findById(id);
		if(user.isEmpty()) 
			throw new UserNotFoundException("The id you looked for" + id);
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostsForUsers(@PathVariable int id,@Valid @RequestBody Post post){
		
		Optional<Users> user = repository.findById(id);
		if(user.isEmpty()) 
			throw new UserNotFoundException("The id you looked for" + id);
		post.setUser(user.get());
		Post savedPost = postRepositotry.save(post);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId()).toUri() ;
				return ResponseEntity.created(location).build();
	}
	
	
} 
