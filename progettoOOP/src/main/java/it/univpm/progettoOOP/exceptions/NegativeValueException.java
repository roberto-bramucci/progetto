package it.univpm.progettoOOP.exceptions;

public class NegativeValueException extends IllegalArgumentException{

	public NegativeValueException() {
		super();
	}
	
	public NegativeValueException(String message) {
		super(message);
	}
	
}
