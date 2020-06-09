package it.univpm.progettoOOP.exceptions;
/**
 * classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene passata una parola non valida
 * @author Roberto Bramucci, Stefano Bonci
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
