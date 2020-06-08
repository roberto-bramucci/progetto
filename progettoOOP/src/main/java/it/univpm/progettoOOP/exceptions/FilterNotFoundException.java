package it.univpm.progettoOOP.exceptions;
/**
 * classe che rappresenta un'eccezione personalizzata che viene lanciata quando il filtro richiesto non esiste
 * @author Roberto Bramucci, Stefano Bonci
 *
 */
public class FilterNotFoundException extends Exception{
	
	public FilterNotFoundException() {
		super();
	}
	
	public FilterNotFoundException(String message) {
		super (message);
	}
}
