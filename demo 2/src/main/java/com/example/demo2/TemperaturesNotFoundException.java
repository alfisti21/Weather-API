package com.example.demo2;

class TemperaturesNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TemperaturesNotFoundException(Long id) {
		super("Could not find Temperature and Advice pair " + id);
	}
}