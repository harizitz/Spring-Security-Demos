package com.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/admin")
	public String getAdmin() {
		return "Welcome Admin !!";
	}
	
	@GetMapping("/user")
	public String getUser() {
		return "Welcome User !!";
	}
}
