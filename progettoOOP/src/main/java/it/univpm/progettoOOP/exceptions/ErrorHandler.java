package it.univpm.progettoOOP.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(FilterNotFoundException.class)
	public ResponseEntity<Object> filterNotFoundExceptionHandler(FilterNotFoundException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalIdException.class)
	public ResponseEntity<Object> illegalIdExceptionHandler(IllegalIdException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<Object> cityNotFoundExceptionHandler(CityNotFoundException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyCollectionException.class)
	public ResponseEntity<Object> emptyCollectionExceptionHandler(EmptyCollectionException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NegativeValueException.class)
	public ResponseEntity<Object> negativeValueExceptionHandler(NegativeValueException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalIntervalException.class)
	public ResponseEntity<Object> illegalIntervalExceptionHandler(IllegalIntervalException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(GenericFilterException.class)
	public ResponseEntity<Object> genericFilterExceptionHandler(GenericFilterException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalWordException.class)
	public ResponseEntity<Object> illegalWordExceptionHandler(IllegalWordException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WordNotFoundException.class)
	public ResponseEntity<Object> wordNotFoundExceptionHandler(WordNotFoundException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BlankFilterException.class)
	public ResponseEntity<Object> blankFilterExceptionHandler(BlankFilterException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(GenericServiceException.class)
	public ResponseEntity<Object> genericServiceExceptionHandler(GenericServiceException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	
		
}
