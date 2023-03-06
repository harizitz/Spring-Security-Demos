package com.securejwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.securejwt.config.UserDetailsServiceImpl;
import com.securejwt.model.AuthRequest;
import com.securejwt.model.AuthResponse;
import com.securejwt.model.User;
import com.securejwt.repository.UserRepository;
import com.securejwt.util.JwtUtil;

@RestController
public class Controller {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository repository;

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@PostMapping("/save")
	public String newUser(@RequestBody User newUser) {
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		repository.save(newUser);
		return "Saved";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> authrequest(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Bad Credentials", e);
		}
		final UserDetails usr = userDetailsService.loadUserByUsername(authRequest.getUsername());
		final String jwtkey = jwtUtil.generateToken(usr);
		return ResponseEntity.ok(new AuthResponse(jwtkey));
	}
}
