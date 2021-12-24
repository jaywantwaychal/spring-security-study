package com.jdsolutions.springbasicsecurity.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class User {
	
	@GetMapping("/")
	public String getMessage() {
		return "Default Message";
	}
	
	@GetMapping("/customer")
	public String getUserMessage() {
		return "Default Message: User";
	}
	
	@GetMapping("/admin")
	public String getAdminMessage() {
		return "Default Message: Admin";
	}

}
