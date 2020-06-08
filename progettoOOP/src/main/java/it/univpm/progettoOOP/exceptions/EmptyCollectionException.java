package it.univpm.progettoOOP.exceptions;
/**
 * classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene restituita una collection vuota
 * @author Roberto Bramucci, Stefano Bonci
 *
 */
public class EmptyCollectionException extends Exception{

	public EmptyCollectionException() {
		super();
	}
	
	public EmptyCollectionException(String message) {
		super(message);
	}
}
