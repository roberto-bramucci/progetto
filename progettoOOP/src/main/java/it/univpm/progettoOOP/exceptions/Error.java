package it.univpm.progettoOOP.exceptions;

import java.time.Instant;
/**
 * Classe che rappresenta un errore che viene visualizzato quando viene lanciata un'eccezione personalizzata 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 * @version 1.0
 */
public class Error {
	/**
	 * Istante in cui viene lanciata l'eccezione
	 */
	private Instant time;
	/**
	 * Nome del messaggio di errore
	 */
	private String error;
	/**
	 * Descrizione dell'errore
	 */
	private String message;
	
	/**
	 * Costruttore con parametri
	 * 
	 * @param e Eccezione di cui si vuole visualizzare il messaggio di errore
	 */
	
	public Error(Exception e) {
		this.time = Instant.now();
		this.error = e.getClass().getSimpleName();
		this.message = e.getMessage();
	}
	
	/**
	 * Metodo per ottenere l'istante in cui viene lanciata l'eccezione
	 * @return Istante in cui viene lanciata l'eccezione
	 */
	
	public Instant getTime() {
		return time;
	}
	/**
	 * Metodo per impostare l'istante in cui viene lanciata l'eccezione
	 * @param Istante in cui viene lanciata l'eccezione
	 */
	public void setTime(Instant time) {
		this.time = time;
	}
	/**
	 * Metodo per ottenere il nome del messaggio di errore
	 * @return Nome del messaggio di errore
	 */
	public String getError() {
		return error;
	}
	/**
	 * Metodo per impostare il nome del messaggio di errore
	 * @param Nome del messaggio di errore
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * Metodo per ottenere la descrizione dell'errore
	 * @return Descrizione dell'errore
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * Metodo per impostare la descrizione dell'errore
	 * @return Descrizione dell'errore
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
