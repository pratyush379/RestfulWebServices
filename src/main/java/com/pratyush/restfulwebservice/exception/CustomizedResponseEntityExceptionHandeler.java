package com.pratyush.restfulwebservice.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pratyush.restfulwebservice.user.UserNotFoundException;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandeler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class) // to handle all expeption and show status 500
	public final ResponseEntity<Object> handleAllExceptions(Exception ex , WebRequest request){
	ErrorDetail errorDetails = new ErrorDetail(LocalDate.now(),ex.getMessage() , request.getDescription(false));	
	
	return new ResponseEntity(errorDetails , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@ExceptionHandler(UserNotFoundException.class) // to handle user not found and show status 404
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex , WebRequest request){
	ErrorDetail errorDetails = new ErrorDetail(LocalDate.now(),ex.getMessage() , request.getDescription(false));	
	
	return new ResponseEntity(errorDetails , HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	//	ErrorDetail errorDetails = new ErrorDetail(LocalDate.now(),ex.getMessage() , request.getDescription(false));
		
		ErrorDetail errorDetails = new ErrorDetail(LocalDate.now(),"total errors : " + ex.getErrorCount() + " ,"+ex.getFieldError().getDefaultMessage(), request.getDescription(false));	
		
		return new ResponseEntity(errorDetails , HttpStatus.BAD_REQUEST);
		
	}
}
	

