package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando il filtro richiesto non esiste
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 */
public class FilterNotFoundException extends Exception{
	/**
	 * Costruttore di default
	 */
	public FilterNotFoundException() {
		super();
	}
	/**
	 * Costruttore con parametri
	 * @param message Messaggio di errore lanciato
	 */
	public FilterNotFoundException(String message) {
		super (message);
	}
}
