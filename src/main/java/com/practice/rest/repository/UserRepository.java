package com.practice.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.practice.rest.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	UserEntity findByUsername(String username);
	UserEntity findByEmail(String email);
	
	
}
