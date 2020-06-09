package it.univpm.progettoOOP.util.stats;
/**
 * Classe per la modellazione delle statistiche relative al campo geo di un campione di dati di tipo Tweet
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 * @version 1.0
 */
public class StatsGeo {
	/**
	 * Campo su cui vengono calcolate le statistiche
	 */
	private final String field = "geo";
	/**
	 * Statistica relativa alla distanza media dalla città scelta dei Tweet analizzati
	 */
	private double avgDist;
	/**
	 * Statistica relativa alla distanza massima dalla città scelta dei Tweet analizzati 
	 */
	private double maxDist;
	/**
	 * Statistica relativa alla distanza minima dalla città scelta dei Tweet analizzati
	 */
	private double minDist;
	/**
	 * Statistica relativa alla distanza totale dalla città scelta dei Tweet analizzati 
	 */
	private double sumDist;
	/**
	 * Statistica relativa alla varianza della distanza dalla città scelta dei Tweet analizzati 
	 */
	private double varDist;
	/**
	 * Statistica relativa alla deviazione standard della distanza dalla città scelta dei Tweet analizzati 
	 */
	private double devStdDist;
	/**
	 * Numero di Tweet analizzati per calcolare le statistiche 
	 */
	private int numTweetAnalyzed;
	
	/**
	 * Costruttore che inizializza a zero tutti i parametri numerici
	 */
	
	public StatsGeo() {
		this.avgDist = 0;
		this.maxDist = 0;
		this.minDist = 0;
		this.sumDist = 0;
		this.varDist = 0;
		this.devStdDist = 0;
	}
	
	/**
	 * Metodo per ottenere il campo su cui vengono calcolate le statistiche
	 * @return Campo delle statistiche
	 */
	
	public String getField() {
		return field;
	}
	/**
	 * Metodo per ottenere la distanza media
	 * @return Distanza media
	 */
	
	public double getAvgDist() {
		return avgDist;
	}
	/**
	 * Metodo per impostare la distanza media
	 * @param avgDist Distanza media
	 */
	
	public void setAvgDist(double avgDist) {
		this.avgDist = avgDist;
	}
	/**
	 * Metodo per ottenere la distanza massima
	 * @return Distanza massima
	 */
	
	public double getMaxDist() {
		return maxDist;
	}
	
	/**
	 * Metodo per impostare la distanza massima
	 * @param maxDist Distanza massima
	 */
	
	public void setMaxDist(double maxDist) {
		this.maxDist = maxDist;
	}
	/**
	 * Metodo per ottenere la distanza minima
	 * @return Distanza minima
	 */
	
	public double getMinDist() {
		return minDist;
	}
	/**
	 * Metodo per impostare la distanza minima
	 * @param minDist Distanza minima
	 */
	
	public void setMinDist(double minDist) {
		this.minDist = minDist;
	}
	/**
	 * Metodo per ottenere la distanza totale
	 * @return Distanza totale
	 */
	
	public double getSumDist() {
		return sumDist;
	}
	/**
	 * Metodo per impostare la distanza totale
	 * @param sumDist Distanza totale
	 */
	
	public void setSumDist(double sumDist) {
		this.sumDist = sumDist;
	}
	/**
	 * Metodo per ottenere la varianza della distanza
	 * @return Varianza della distanza
	 */
	
	public double getVarDist() {
		return varDist;
	}
	/**
	 * Metodo per impostare la varianza della distanza
	 * @param varDist Varianza della distanza
	 */
	
	public void setVarDist(double varDist) {
		this.varDist = varDist;
	}
	/**
	 * Metodo per ottenere la deviazione standard della distanza
	 * @return Deviazione standard della distanza
	 */
	
	public double getDevStdDist() {
		return devStdDist;
	}
	/**
	 * Metodo per impostare la deviazione standard della distanza
	 * @param devStdDist Deviazione standard della distanza
	 */
	
	public void setDevStdDist(double devStdDist) {
		this.devStdDist = devStdDist;
	}
	
	/**
	 * Metodo per ottenere il numero di Tweet analizzati
	 * @return Numero di Tweet analizzati
	 */
	
	public int getNumTweetAnalyzed() {
		return numTweetAnalyzed;
	}
	/**
	 * Metodo per impostare il numero di Tweet analizzati
	 * @param numTweetAnalyzed Numero di Tweet analizzati
	 */

	public void setNumTweetAnalyzed(int numTweetAnalyzed) {
		this.numTweetAnalyzed = numTweetAnalyzed;
	}
}
