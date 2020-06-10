package it.univpm.progettoOOP.util.stats;

import it.univpm.progettoOOP.model.Tweet;

/**
 * Classe per la modellazione delle statistiche relative al campo text di un campione di dati di tipo {@link Tweet}
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 * @version 1.0
 */
public class StatsText {
	/**
	 * Campo su cui vengono calcolate le statistiche
	 */
	private final String field = "text";
	/**
	 * Statistica relativa alla lunghezza media del testo dei {@link Tweet} analizzati
	 */
	private double avgLength;
	/**
	 * Statistica relativa alla lunghezza massima del testo dei {@link Tweet} analizzati
	 */
	private double maxLength;
	/**
	 * Statistica relativa alla lunghezza minima del testo dei {@link Tweet} analizzati
	 */
	private double minLength;
	/**
	 * Statistica relativa alla lunghezza totale del testo dei {@link Tweet} analizzati
	 */
	private double sumLength;
	/**
	 * Numero di Tweet analizzati per calcolare le statistiche 
	 */
	private int numTweetAnalyzed;
	
	/**
	 * Costruttore che inizializza a zero tutti i parametri numerici
	 */
	public StatsText() {
		this.avgLength = 0;
		this.maxLength = 0;
		this.minLength = 0;
		this.sumLength = 0;
	}
	
	/**
	 * Metodo per ottenere il campo su cui vengono calcolate le statistiche
	 * @return Campo delle statistiche
	 */
	public String getField() {
		return field;
	}
	
	/**
	 * Metodo per ottenere la lunghezza media
	 * @return Lunghezza media
	 */
	public double getAvgLength() {
		return avgLength;
	}
	
	/**
	 * Metodo per impostare la lunghezza media
	 * @param avgLength Lunghezza media
	 */
	public void setAvgLength(double avgLength) {
		this.avgLength = avgLength;
	}
	/**
	 * Metodo per ottenere la lunghezza massima
	 * @return Lunghezza massima
	 */
	
	public double getMaxLength() {
		return maxLength;
	}
	
	/**
	 * Metodo per impostare la lunghezza massima
	 * @param maxLength Lunghezza massima
	 */
	
	public void setMaxLength(double maxLength) {
		this.maxLength = maxLength;
	}
	
	/**
	 * Metodo per ottenere la lunghezza minima
	 * @return Lunghezza minima
	 */
	
	public double getMinLength() {
		return minLength;
	}
	
	/**
	 * Metodo per impostare la lunghezza minima
	 * @param minLength Lunghezza minima
	 */
	
	public void setMinLength(double minLength) {
		this.minLength = minLength;
	}
	
	/**
	 * Metodo per ottenere la lunghezza totale
	 * @return Lunghezza totale
	 */
	
	public double getSumLength() {
		return sumLength;
	}
	
	/**
	 * Metodo per impostare la lunghezza totale
	 * @param sumLength Lunghezza totale
	 */
	
	public void setSumLength(double sumLength) {
		this.sumLength = sumLength;
	}
	/**
	 * Metodo per ottenere il numero di {@link Tweet} analizzati
	 * @return Numero di {@link Tweet} analizzati
	 */

	public int getNumTweetAnalyzed() {
		return numTweetAnalyzed;
	}
	
	/**
	 * Metodo per impostare il numero di {@link Tweet} analizzati
	 * @param numTweetAnalyzed Numero di {@link Tweet} analizzati
	 */

	public void setNumTweetAnalyzed(int numTweetAnalyzed) {
		this.numTweetAnalyzed = numTweetAnalyzed;
	}
}
