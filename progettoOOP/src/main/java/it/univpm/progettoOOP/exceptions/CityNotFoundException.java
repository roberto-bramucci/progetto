package it.univpm.progettoOOP.exceptions;

/**
 * classe che rappresenta un'eccezione personalizzata che viene lanciata quando viene passata una città non presente tra quelle 
 * possibili per il filtraggio o la richiesta di statistiche
 * @author Roberto Bramucci, Stefano Bonci
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
