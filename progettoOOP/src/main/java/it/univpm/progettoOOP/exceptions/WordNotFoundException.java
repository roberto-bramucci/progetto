package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando la parola passata non è disponibile
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 */
public class WordNotFoundException extends Exception{
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
