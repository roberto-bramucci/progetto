package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando la parola passata non è disponibile
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 */
public class WordNotFoundException extends Exception{
	
	public WordNotFoundException() {
		super();
	}
	
	public WordNotFoundException(String message) {
		super(message);
	}
}
