package com.acmefresh.exceptions;

import java.time.LocalDateTime;

import javax.persistence.RollbackException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	 @ExceptionHandler(LoginException.class)
	  public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException e, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
      }
	
	
	  @ExceptionHandler(CustomerException.class)
	   public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException e, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
      }
	
	
	 @ExceptionHandler(RollbackException.class)
	  public ResponseEntity<MyErrorDetails> rollbackHandler(RollbackException e, WebRequest wr){
	
		System.out.println("Inside the Exception Handler...");
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
      }
	

	
	   @ExceptionHandler(NoHandlerFoundException.class)
       public ResponseEntity<MyErrorDetails> wrongApiHandler(NoHandlerFoundException e, WebRequest wr){
		
		  System.out.println("Inside the NoHandlerFoundException Handler...");
		
		  MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		
		  return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	   }
	

	
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	   public ResponseEntity<MyErrorDetails> methodHandler(MethodArgumentNotValidException ie,WebRequest req) {
		
			System.out.println("inside MethodArgumentNotValidException Handler...");
			
			MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
			
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
	
	   }
	   
	   
	   @ExceptionHandler(Exception.class)
		  public ResponseEntity<MyErrorDetails> logicalHandler(Exception e, WebRequest wr){
		
			System.out.println("Inside the Exception Handler...");
			
			MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
			
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
				
	   }
	
}
