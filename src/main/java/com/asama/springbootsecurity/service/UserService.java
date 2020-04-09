package com.asama.springbootsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asama.springbootsecurity.UserRepository;
import com.asama.springbootsecurity.domain.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserByName(String name) {
		return userRepository.findByUsername(name);
	}
}
