package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata 
 * quando viene analizzata una Collection vuota
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * @version 1.0
 */
public class EmptyCollectionException extends Exception{
	/**
	 * Costruttore di default
	 */
	public EmptyCollectionException() {
		super();
	}
	/**
	 * Costruttore con parametri
	 * @param message Messaggio di errore lanciato
	 */
	public EmptyCollectionException(String message) {
		super(message);
	}
}
