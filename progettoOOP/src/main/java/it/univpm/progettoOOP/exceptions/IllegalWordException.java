package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene passata 
 * una parola troppo corta
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 */
public class IllegalWordException extends Exception{
	
	public IllegalWordException() {
		super();
	}
	
	public IllegalWordException(String message) {
		super(message);
	}
}
