package com.pjblat.golfscoresappservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GolferNotFoundException extends RuntimeException {

	public GolferNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
