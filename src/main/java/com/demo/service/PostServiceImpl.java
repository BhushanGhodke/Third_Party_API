package com.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.model.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostServiceImpl implements PostService{

	
	String url="https://jsonplaceholder.typicode.com/posts";
	
	@Override
	public Mono<Post[]> getAllPosts() {
		
		WebClient client= WebClient.create(); 
		
		Mono<Post[]> bodyToMono = client.get().uri(url).retrieve().bodyToMono(Post[].class);

		return bodyToMono;
	}
	
	@Override
	public Flux<Post> getPostBydId(Integer id) {
		
		String postById= "https://jsonplaceholder.typicode.com/posts/"+id;
		
		System.out.println(postById);
	
		WebClient client = WebClient.create();
		 
		Flux<Post> post = client.get().uri(postById).retrieve().bodyToFlux(Post.class);
		return  post;
	}
	
}
