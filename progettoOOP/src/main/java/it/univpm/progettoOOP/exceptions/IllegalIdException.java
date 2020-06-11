package it.univpm.progettoOOP.exceptions;
/**
 * classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene passato un id non presente tra quelli 
 * disponibili
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * @version 1.0
 */
public class IllegalIdException extends Exception {
	/**
	 * Costruttore di default
	 */
	public IllegalIdException() {
		super();
	}
	/**
	 * Costruttore con parametri
	 * @param message Messaggio di errore lanciato
	 */
	public IllegalIdException (String message) {
		super(message);
	}
}
