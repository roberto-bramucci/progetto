package it.univpm.progettoOOP.exceptions;

/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando il filtro inserito e' vuoto
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * @version 1.0
 */
public class BlankFilterException extends Exception{
	/**
	 * Costruttore di default
	 */
	public BlankFilterException() {
		super();
	}
	/**
	 * Costruttore con parametri
	 * @param message Messaggio di errore lanciato
	 */
	
	public BlankFilterException(String message) {
		super(message);
	}
}	
