package it.univpm.progettoOOP.exceptions;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(FilterNotFoundException.class)
	public ResponseEntity<Object> filterNotFoundExceptionHandler(FileNotFoundException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalIdException.class)
	public ResponseEntity<Object> illegalIdExceptionHandler(IllegalIdException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<Object> cityNotFoundHandler(CityNotFoundException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyCollectionException.class)
	public ResponseEntity<Object> emptyCollectionHandler(EmptyCollectionException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NegativeValueException.class)
	public ResponseEntity<Object> negativeValueException(NegativeValueException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalIntervalException.class)
	public ResponseEntity<Object> illegalIntervalException(IllegalIntervalException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(GenericFilterException.class)
	public ResponseEntity<Object> genericFilterException(GenericFilterException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	
	
}
