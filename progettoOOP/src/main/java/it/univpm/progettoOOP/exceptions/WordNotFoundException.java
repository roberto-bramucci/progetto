package it.univpm.progettoOOP.exceptions;

public class WordNotFoundException extends Exception{
	
	public WordNotFoundException() {
		super();
	}
	
	public WordNotFoundException(String message) {
		super(message);
	}
}
