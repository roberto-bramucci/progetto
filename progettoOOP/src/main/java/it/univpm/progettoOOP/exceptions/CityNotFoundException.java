package it.univpm.progettoOOP.exceptions;

public class CityNotFoundException extends Exception{
	
	public CityNotFoundException() {
		super();
	}
	
	public CityNotFoundException(String message) {
		super(message);
	}
}
