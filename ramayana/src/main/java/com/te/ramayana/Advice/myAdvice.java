package com.te.ramayana.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.te.ramayana.exception.handleEmptyInput;
import com.te.ramayana.reponce.HeroResponce;

@RestControllerAdvice
public class myAdvice  {
	
	@ExceptionHandler(value=handleEmptyInput.class)
	public ResponseEntity<HeroResponce> handleEmptyInput1(handleEmptyInput obj){
		return new ResponseEntity<HeroResponce>(new HeroResponce(true, obj.getMessage(), "No data found"), HttpStatus.OK);
		
	}
	
	
	
	
	

}
