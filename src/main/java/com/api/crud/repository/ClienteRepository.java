package com.api.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
}
