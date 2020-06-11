package it.univpm.progettoOOP.exceptions;

/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene passata una citta' non presente tra quelle 
 * disponibili per il filtro o la richiesta di statistiche
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * @version 1.0
 */
public class CityNotFoundException extends Exception{
	/**
	 * Costruttore di default
	 */
	public CityNotFoundException() {
		super();
	}
	/**
	 * Costruttore con parametri
	 * @param message Messaggio di errore lanciato
	 */
	public CityNotFoundException(String message) {
		super(message);
	}
}
