package it.univpm.progettoOOP.exceptions;
/**
 * classe che rappresenta un'eccezione personalizzata che viene lanciata quando c'è un errore nella restituzione di dati o 
 * metadati da parte del service
 * @author Roberto Bramucci, Stefano Bonci
 *
 */
public class GenericServiceException extends Exception{
	public GenericServiceException() {
		super();
	}
	
	public GenericServiceException(String message) {
		super(message);
	}
}
