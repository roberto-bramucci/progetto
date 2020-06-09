package it.univpm.progettoOOP.exceptions;

/**
 * classe che rappresenta un'eccezione personalizzata che viene lanciata quando il filtro inserito è vuoto
 * @author Roberto Bramucci, Stefano Bonci
 *
 */
public class BlankFilterException extends Exception{
	
	public BlankFilterException() {
		super();
	}
	
	public BlankFilterException(String message) {
		super(message);
	}
}	
