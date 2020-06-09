package it.univpm.progettoOOP.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * Classe per la gestione delle eccezioni personalizzate e i relativi oggetti Error
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 */
@ControllerAdvice
public class ErrorHandler {
	/**
	 * Metodo per la gestione dell'eccezione personalizzata {@link FilterNotFoundException}
	 * @param e Eccezione di tipo {@link FilterNotFoundException}
	 * @return {@link Error} relativo all'eccezione {@link FilterNotFoundException}
	 */
	
	@ExceptionHandler(FilterNotFoundException.class)
	public ResponseEntity<Object> filterNotFoundExceptionHandler(FilterNotFoundException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	/**
	 * Metodo per la gestione dell'eccezione personalizzata {@link IllegalIdException}
	 * @param e Eccezione di tipo {@link IllegalIdException}
	 * @return {@link Error} relativo all'eccezione {@link IllegalIdException}
	 */
	
	@ExceptionHandler(IllegalIdException.class)
	public ResponseEntity<Object> illegalIdExceptionHandler(IllegalIdException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	/**
	 * Metodo per la gestione dell'eccezione personalizzata {@link CityNotFoundException}
	 * @param e Eccezione di tipo {@link CityNotFoundException}
	 * @return {@link Error} relativo all'eccezione {@link CityNotFoundException}
	 */
	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<Object> cityNotFoundExceptionHandler(CityNotFoundException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	/**
	 * Metodo per la gestione dell'eccezione personalizzata {@link EmptyCollectionException}
	 * @param e Eccezione di tipo {@link EmptyCollectionException}
	 * @return {@link Error} relativo all'eccezione {@link EmptyCollectionException}
	 */
	
	@ExceptionHandler(EmptyCollectionException.class)
	public ResponseEntity<Object> emptyCollectionExceptionHandler(EmptyCollectionException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	/**
	 * Metodo per la gestione dell'eccezione personalizzata {@link NegativeValueException}
	 * @param e Eccezione di tipo {@link NegativeValueException}
	 * @return {@link Error} relativo all'eccezione {@link NegativeValueException}
	 */
	
	@ExceptionHandler(NegativeValueException.class)
	public ResponseEntity<Object> negativeValueExceptionHandler(NegativeValueException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	/**
	 * Metodo per la gestione dell'eccezione personalizzata {@link IllegalIntervalException}
	 * @param e Eccezione di tipo {@link IllegalIntervalException}
	 * @return {@link Error} relativo all'eccezione {@link IllegalIntervalException}
	 */
	@ExceptionHandler(IllegalIntervalException.class)
	public ResponseEntity<Object> illegalIntervalExceptionHandler(IllegalIntervalException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	/**
	 * Metodo per la gestione dell'eccezione personalizzata {@link GenericFilterException}
	 * @param e Eccezione di tipo {@link GenericFilterException}
	 * @return {@link Error} relativo all'eccezione {@link GenericFilterException}
	 */
	@ExceptionHandler(GenericFilterException.class)
	public ResponseEntity<Object> genericFilterExceptionHandler(GenericFilterException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	/**
	 * Metodo per la gestione dell'eccezione personalizzata {@link IllegalWordException}
	 * @param e Eccezione di tipo {@link IllegalWordException}
	 * @return {@link Error} relativo all'eccezione {@link IllegalWordException}
	 */
	@ExceptionHandler(IllegalWordException.class)
	public ResponseEntity<Object> illegalWordExceptionHandler(IllegalWordException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	/**
	 * Metodo per la gestione dell'eccezione personalizzata {@link WordNotFoundException}
	 * @param e Eccezione di tipo {@link WordNotFoundException}
	 * @return {@link Error} relativo all'eccezione {@link WordNotFoundException}
	 */
	@ExceptionHandler(WordNotFoundException.class)
	public ResponseEntity<Object> wordNotFoundExceptionHandler(WordNotFoundException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	/**
	 * Metodo per la gestione dell'eccezione personalizzata {@link BlankFilterException}
	 * @param e Eccezione di tipo {@link BlankFilterException}
	 * @return {@link Error} relativo all'eccezione {@link BlankFilterException}
	 */
	@ExceptionHandler(BlankFilterException.class)
	public ResponseEntity<Object> blankFilterExceptionHandler(BlankFilterException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
	/**
	 * Metodo per la gestione dell'eccezione personalizzata {@link GenericServiceException}
	 * @param e Eccezione di tipo {@link GenericServiceException}
	 * @return {@link Error} relativo all'eccezione {@link GenericServiceException}
	 */
	@ExceptionHandler(GenericServiceException.class)
	public ResponseEntity<Object> genericServiceExceptionHandler(GenericServiceException e){
		return new ResponseEntity<>(new Error(e), HttpStatus.BAD_REQUEST);
	}
}
