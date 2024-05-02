package com.example.REST.demo.DB.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.REST.demo.DB.Exception.CustomersNotFound;
import com.example.REST.demo.DB.controller.ErrorResponse;

@RestControllerAdvice
public class Exceptionclass {

	@ExceptionHandler(CustomersNotFound.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity handleExceptionForService(CustomersNotFound e) {
		ErrorResponse res = new ErrorResponse("Failure", 404, e.getMessage());
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

//	@ExceptionHandler(SQLException.class)
//	@ResponseStatus(HttpStatus.CONFLICT)
//	public ResponseEntity<Response> sqlException(SQLException e) {
//		Response res = new Response(false, 409, e.getMessage());
//		return new ResponseEntity<>(res, HttpStatus.CONFLICT);
//
//	}

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity nullpointerException(NullPointerException e) {
		ErrorResponse res = new ErrorResponse("Failure", 500, "NullPointerException");
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);

	}

//	@ExceptionHandler(SQLServerException.class)
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	public ResponseEntity<Response> sqlServerException(SQLServerException e) {
//		Response res = new Response(false, 500, "Could not connect to DB.Check your credentials");
//		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
//	}

}