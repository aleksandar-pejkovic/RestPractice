package com.practice.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.rest.entity.UserEntity;
import com.practice.rest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public UserEntity createUser(UserEntity user) {
		return userRepository.save(user);
	}
	
	public List<UserEntity> findAllUsers(){
		return (List<UserEntity>) userRepository.findAll();
	}
	
	public UserEntity findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public UserEntity findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public UserEntity updateUser(UserEntity user) {
		UserEntity currentUser = userRepository.findByUsername(user.getUsername());
		if(user.getPassword()!=null)
		currentUser.setPassword(user.getPassword());
		if(user.getEmail()!=null)
		currentUser.setEmail(user.getEmail());
		return userRepository.save(currentUser);
	}
	public String deleteUser(String username) {
		UserEntity currentUser = userRepository.findByUsername(username);
		userRepository.delete(currentUser);
		String msg = "User " + username + " was deleted!";
		return msg;
	}
	
}
