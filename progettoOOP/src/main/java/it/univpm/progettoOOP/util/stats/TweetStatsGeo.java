package it.univpm.progettoOOP.util.stats;

import java.util.Collection;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;
import it.univpm.progettoOOP.exceptions.EmptyCollectionException;
import it.univpm.progettoOOP.model.Tweet;
/**
 * Interfaccia per la dichiarazione dei metodi utili per il calcolo delle statistiche relative al campo geo di Tweet
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 * @version 1.0
 */

public interface TweetStatsGeo {
	/**
	 * Metodo per l'impostazione delle statistiche relative al campo geo di Tweet
	 * @param sample Campione di Tweet analizzato
	 * @param city Città da cui si vuole calcolare la distanza
	 * @throws EmptyCollectionException
	 * @throws CityNotFoundException
	 */
	public void setStatsGeo(Collection<Tweet> sample, String city) throws EmptyCollectionException, CityNotFoundException;
	/**
	 * Metodo per ottenere le statistiche relative al campo geo di Tweet
	 * @return Statistiche relative al campo geo
	 */
	
	public StatsGeo getStatsGeo();
}
