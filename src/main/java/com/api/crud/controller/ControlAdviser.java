package com.api.crud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControlAdviser {
	
	@ExceptionHandler(RuntimeException.class)
	ResponseEntity<com.api.crud.model.Error> handlerException(RuntimeException re){
		return new ResponseEntity<com.api.crud.model.Error>(new com.api.crud.model.Error(re.getMessage()),HttpStatus.BAD_REQUEST);
		
	}
}
