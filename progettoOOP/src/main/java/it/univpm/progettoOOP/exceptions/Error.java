package it.univpm.progettoOOP.exceptions;

import java.time.Instant;

public class Error {
	private Instant time;
	private String error;
	private String message;
	
	public Error(Exception e) {
		this.time = Instant.now();
		this.error = e.getClass().getSimpleName();
		this.message = e.getMessage();
	}
	
	public Instant getTime() {
		return time;
	}
	public void setTime(Instant time) {
		this.time = time;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
