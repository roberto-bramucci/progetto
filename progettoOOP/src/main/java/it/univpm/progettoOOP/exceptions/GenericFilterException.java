package it.univpm.progettoOOP.exceptions;
/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando c'e' un errore nella richiesta di un filtro
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 */
public class GenericFilterException extends Exception{
	/**
	 * Costruttore di default
	 */
	public GenericFilterException() {
		super();
	}
	/**
	 * Costruttore con parametri
	 * @param message Messaggio di errore lanciato
	 */
	public GenericFilterException(String message) {
		super(message);
	}
}
