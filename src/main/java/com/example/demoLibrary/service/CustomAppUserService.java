package com.example.demoLibrary.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demoLibrary.entity.AppUser;
import com.example.demoLibrary.repository.AppUserRepository;

@Service
public class CustomAppUserService implements UserDetailsService{
	
	private AppUserRepository appUserRepository;
	private PasswordEncoder passwordEncoder;
	
	public CustomAppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
		this.appUserRepository = appUserRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public void addAppUser(AppUser appUser) {
		appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
		appUserRepository.save(appUser);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser appUser = appUserRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		return User.builder().username(appUser.getUsername()).password(appUser.getPassword()).roles(appUser.getRole()).build();
	}
	
	
	
}
