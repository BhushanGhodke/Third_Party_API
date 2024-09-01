package com.demo.service;

import com.demo.model.User;

import reactor.core.publisher.Mono;

public interface UserService {

  public Mono<User[]> getAllUser();
	
}
