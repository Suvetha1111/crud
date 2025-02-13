package com.example.blog.service;

import com.example.blog.dto.PostRequest;
import com.example.blog.model.Post;
import com.example.blog.model.User;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import com.example.blog.security.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	private final JwtUtil jwtUtil;

	public PostService(PostRepository postRepository, UserRepository userRepository, JwtUtil jwtUtil) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
		this.jwtUtil = jwtUtil;
	}

	public Post createPost(PostRequest request, String token) {
		String email = jwtUtil.extractEmail(token);
		User user = userRepository.findByEmail(email)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found"));

		Post post = new Post();
		post.setTitle(request.getTitle());
		post.setContent(request.getContent());
		post.setUser(user);

		return postRepository.save(post);
	}

	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Transactional
	public Post updatePost(Long postId, PostRequest request, String token) {
		String email = jwtUtil.extractEmail(token);
		Post post = postRepository.findById(postId)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));

		if (!post.getUser().getEmail().equals(email)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You can only update your own posts");
		}

		post.setTitle(request.getTitle());
		post.setContent(request.getContent());

		return postRepository.save(post);
	}

	@Transactional
	public String deletePost(Long postId, String token) {
		String email = jwtUtil.extractEmail(token);
		Post post = postRepository.findById(postId)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));

		if (!post.getUser().getEmail().equals(email)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You can only delete your own posts");
		}

		postRepository.delete(post);
		return "Post deleted successfully";
	}
}
