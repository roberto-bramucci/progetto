package it.univpm.progettoOOP.exceptions;

/**
 * Classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene passata una città non presente tra quelle 
 * disponibili per il filtraggio o la richiesta di statistiche
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 */
public class CityNotFoundException extends Exception{
	
	public CityNotFoundException() {
		super();
	}
	
	public CityNotFoundException(String message) {
		super(message);
	}
}
