package com.pratyush.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
public class UserResource {

	
	
	@Autowired
	private UserDaoService service;
	
	//get / users
	@GetMapping("users")
	public List<User> getAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("users/{id}")
	public User getUser(@PathVariable int id){
		return service.findOne(id);
	}
	
	@PostMapping("users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
		
		//now location addedd in header ex- http://localhost:9090/users/4
		
		//in addn with status code we are returning path of created resource here
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUserById(@PathVariable int id) {
		service.deleteById(id);
		}
	
}
