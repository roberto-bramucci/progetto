package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando c'è un errore nella restituzione di dati o 
 * metadati da parte del service
 * @author Roberto Bramucci
 * @author Stefano Bonci
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
