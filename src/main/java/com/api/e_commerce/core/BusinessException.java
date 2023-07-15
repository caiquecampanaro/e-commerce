package com.api.e_commerce.core;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;


@SuppressWarnings("serial")
@AllArgsConstructor
public class BusinessException extends RuntimeException{
	

	public String title;
	
	public HttpStatus status;
	
	public String detail;
	
   public BusinessException (String title, HttpStatus status) {
	  super(); 
	  this.title = title;
	  this.status = status;
   }
	
}
