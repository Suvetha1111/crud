package com.example.blog.controller;

import com.example.blog.dto.AuthRequest;
import com.example.blog.dto.SignupRequest;
import com.example.blog.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthController {
	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/signup")
	public String signup(@RequestBody SignupRequest request) {
		return authService.signup(request);
	}

	@PostMapping("/signin")
	public String signin(@RequestBody AuthRequest request) {
		return authService.signin(request);
	}
}
