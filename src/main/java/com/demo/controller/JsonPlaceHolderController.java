package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Post;
import com.demo.model.User;
import com.demo.service.PostService;
import com.demo.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class JsonPlaceHolderController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/get")
	public ResponseEntity<Mono<Post[]>> getAllPost(){
		
		return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Flux<Post>> getPostById(@PathVariable(name="id") Integer id){
		
		return new ResponseEntity<>(postService.getPostBydId(id), HttpStatus.OK);
	}
	
	@GetMapping("/user/get")
	public ResponseEntity<Mono<User[]>> getAllUser(){
	return new ResponseEntity<Mono<User[]>>(userService.getAllUser(), HttpStatus.OK);
		
	}
	
}
