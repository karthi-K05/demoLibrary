package com.example.demoLibrary.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoLibrary.entity.AppUser;
import com.example.demoLibrary.service.CustomAppUserService;

@RestController
@RequestMapping("/api/library/user")
public class AppUserController {

	private CustomAppUserService customAppUserService;
	
	public AppUserController(CustomAppUserService customAppUserService) {
		this.customAppUserService = customAppUserService;
		
	}

	@PostMapping
	public ResponseEntity<String> addAppUser(@RequestBody AppUser appUser){
		customAppUserService.addAppUser(appUser);
		
		return ResponseEntity.ok("AppUser add Successfully");
	}
	
}
