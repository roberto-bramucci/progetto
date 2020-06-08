package it.univpm.progettoOOP.exceptions;
/**
 * classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene passato un valore negativo
 * @author Roberto Bramucci, Stefano Bonci
 *
 */
public class NegativeValueException extends Exception{

	public NegativeValueException() {
		super();
	}
	
	public NegativeValueException(String message) {
		super(message);
	}
	
}
