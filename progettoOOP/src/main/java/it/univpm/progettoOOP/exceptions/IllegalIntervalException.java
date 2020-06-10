package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene passato 
 * un intervallo di distanze non corretto nel filtro
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 */
public class IllegalIntervalException extends Exception{
	/**
	 * Costruttore di default
	 */
	public IllegalIntervalException() {
		super();
	}
	/**
	 * Costruttore con parametri
	 * @param message Messaggio di errore lanciato
	 */
	public IllegalIntervalException(String message) {
		super(message);
	}
}
