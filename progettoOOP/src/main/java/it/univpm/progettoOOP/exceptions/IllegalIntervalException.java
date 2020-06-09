package it.univpm.progettoOOP.exceptions;
/**
 * classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene passato un intervallo non corretto
 * @author Roberto Bramucci, Stefano Bonci
 *
 */
public class IllegalIntervalException extends Exception{
	
	public IllegalIntervalException() {
		super();
	}
	
	public IllegalIntervalException(String message) {
		super(message);
	}
}
