package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando 
 * viene passato un valore di distanza negativo
 * @author Roberto Bramucci
 * @author Stefano Bonci
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
