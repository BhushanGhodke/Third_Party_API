package com.demo.service;

import com.demo.model.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

	public Mono<Post[]> getAllPosts();
	
	public Flux<Post> getPostBydId(Integer id);
}

