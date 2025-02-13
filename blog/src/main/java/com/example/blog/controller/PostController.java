package com.example.blog.controller;

import com.example.blog.dto.PostRequest;
import com.example.blog.model.Post;
import com.example.blog.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
	private final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@PostMapping
	public Post createPost(@RequestBody PostRequest request, @RequestHeader("Authorization") String token) {
		return postService.createPost(request, token.replace("Bearer ", ""));
	}

	@GetMapping
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}

	@PutMapping("/{postId}")
	public Post updatePost(@PathVariable Long postId, @RequestBody PostRequest request, @RequestHeader("Authorization") String token) {
		return postService.updatePost(postId, request, token.replace("Bearer ", ""));
	}

	@DeleteMapping("/{postId}")
	public String deletePost(@PathVariable Long postId, @RequestHeader("Authorization") String token) {
		return postService.deletePost(postId, token.replace("Bearer ", ""));
	}
}
