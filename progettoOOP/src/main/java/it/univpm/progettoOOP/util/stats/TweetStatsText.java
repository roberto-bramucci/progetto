package it.univpm.progettoOOP.util.stats;

import java.util.Collection;

import it.univpm.progettoOOP.exceptions.EmptyCollectionException;
import it.univpm.progettoOOP.model.Tweet;
/**
 * Interfaccia per la dichiarazione dei metodi utili per il calcolo delle statistiche relative al campo text di {@link Tweet}
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 * @version 1.0
 */
public interface TweetStatsText {
	/**
	 * Metodo per l'impostazione delle statistiche relative al campo text di {@link Tweet}
	 * @param sample Campione di {@link Tweet} analizzato
	 * @throws EmptyCollectionException Eccezione lanciata quando viene analizzata una Collection vuota}
	 */
	public void setStatsText(Collection<Tweet> sample) throws EmptyCollectionException;
	/**
	 * Metodo per ottenere le statistiche relative al campo text di {@link Tweet}
	 * @return Statistiche relative al campo text
	 */
	public StatsText getStatsText();
}
