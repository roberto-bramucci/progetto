package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando la parola passata
 *  non e' disponibile
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * @version 1.0
 */
public class WordNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Costruttore di default
	 */
	public WordNotFoundException() {
		super();
	}
	/**
	 * Costruttore con parametri
	 * @param message Messaggio di errore lanciato
	 */
	public WordNotFoundException(String message) {
		super(message);
	}
}
