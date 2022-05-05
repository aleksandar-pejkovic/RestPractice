package com.practice.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.rest.entity.UserEntity;
import com.practice.rest.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public UserEntity createUser(@RequestBody UserEntity user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/findAllUsers")
	public List<UserEntity> findAllUsers(){
		return userService.findAllUsers();
	}
	
	@GetMapping("/findByUsername/{username}")
	public UserEntity findByUsername(@PathVariable String username) {
		return userService.findUserByUsername(username);
	}
	
	@GetMapping("/findByEmail/{email}")
	public UserEntity findByEmail(@PathVariable String email) {
		return userService.findUserByEmail(email);
	}
	
	@PutMapping("/update")
	public UserEntity updateUser(@RequestBody UserEntity user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/delete/{username}")
	public String deleteUser(@PathVariable String username) {
		return userService.deleteUser(username);
	}

}
