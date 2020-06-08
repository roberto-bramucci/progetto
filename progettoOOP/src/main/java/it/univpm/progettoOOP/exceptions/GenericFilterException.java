package it.univpm.progettoOOP.exceptions;
/**
 * classe che rappresenta un'eccezione personalizzata che viene lanciata quando c'è un errore nella richiesta di un filtro
 * @author Roberto Bramucci, Stefano Bonci
 *
 */
public class GenericFilterException extends Exception{
	
	public GenericFilterException() {
		super();
	}
	
	public GenericFilterException(String message) {
		super(message);
	}
}
