package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene restituita una Collection vuota
 * @author Roberto Bramucci
 * @author Stefano Bonci
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
