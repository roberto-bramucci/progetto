package it.univpm.progettoOOP.util.stats;

import java.util.Collection;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;
import it.univpm.progettoOOP.exceptions.EmptyCollectionException;
import it.univpm.progettoOOP.model.Tweet;
/**
 * Interfaccia per la dichiarazione dei metodi utili per il calcolo delle statistiche relative al campo geo di {@link Tweet}
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 * @version 1.0
 */

public interface TweetStatsGeo {
	/**
	 * Metodo per l'impostazione delle statistiche relative al campo geo di {@link Tweet}
	 * @param sample Campione di {@link Tweet} analizzato
	 * @param city Citta' da cui si vuole calcolare la distanza
	 * @throws EmptyCollectionException {@link EmptyCollectionException}
	 * @throws CityNotFoundException {@link CityNotFoundException}
	 */
	public void setStatsGeo(Collection<Tweet> sample, String city) throws EmptyCollectionException, CityNotFoundException;
	/**
	 * Metodo per ottenere le statistiche relative al campo geo di {@link Tweet}
	 * @return Statistiche relative al campo geo
	 */
	
	public StatsGeo getStatsGeo();
}
