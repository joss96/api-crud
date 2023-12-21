package com.api.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	Optional<UserEntity>  findByUsername(String username);

}
