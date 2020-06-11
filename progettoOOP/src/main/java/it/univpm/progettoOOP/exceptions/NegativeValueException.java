package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando 
 * viene passato un valore di distanza negativo
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * @version 1.0
 */
public class NegativeValueException extends Exception{
	/**
	 * Costruttore di default
	 */
	public NegativeValueException() {
		super();
	}
	/**
	 * Costruttore con parametri
	 * @param message Messaggio di errore lanciato
	 */
	public NegativeValueException(String message) {
		super(message);
	}
	
}
