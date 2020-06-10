package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando c'e' un errore nella restituzione di dati o 
 * metadati da parte del service
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 */
public class GenericServiceException extends Exception{
	/**
	 * Costruttore di default
	 */
	public GenericServiceException() {
		super();
	}
	/**
	 * Costruttore con parametri
	 * @param message Messaggio di errore lanciato
	 */
	public GenericServiceException(String message) {
		super(message);
	}
}
