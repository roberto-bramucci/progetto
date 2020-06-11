package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene passata 
 * una parola troppo corta
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * @version 1.0
 */
public class IllegalWordException extends Exception{
	/**
	 * Costruttore di default
	 */
	public IllegalWordException() {
		super();
	}
	/**
	 * Costruttore con parametri
	 * @param message Messaggio di errore lanciato
	 */
	public IllegalWordException(String message) {
		super(message);
	}
}
