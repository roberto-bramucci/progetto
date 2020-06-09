package it.univpm.progettoOOP.exceptions;
/**
 * classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene passato un id non presente tra quelli 
 * disponibili
 * @author Roberto Bramucci, Stefano Bonci
 *
 */
public class IllegalIdException extends Exception {
	
	public IllegalIdException() {
		super();
	}
	
	public IllegalIdException (String message) {
		super(message);
	}
}
