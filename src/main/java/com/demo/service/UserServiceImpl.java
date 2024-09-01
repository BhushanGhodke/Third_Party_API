package com.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.demo.model.User;

import reactor.core.publisher.Mono;
@Service
public class UserServiceImpl implements UserService {

	
	String url="https://jsonplaceholder.typicode.com/users";
	
	@Override
	public Mono<User[]> getAllUser() {
		
		WebClient client = WebClient.create();
		
		 Mono<User[]> mono = client.get().uri(url).retrieve().bodyToMono(User[].class);
		
		 return mono;
	
	}

}
