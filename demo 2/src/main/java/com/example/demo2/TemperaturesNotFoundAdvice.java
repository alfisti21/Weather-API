package com.example.demo2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class TemperaturesNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(TemperaturesNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String TemperaturesNotFoundHandler(TemperaturesNotFoundException ex) {
		return ex.getMessage();
	}
}