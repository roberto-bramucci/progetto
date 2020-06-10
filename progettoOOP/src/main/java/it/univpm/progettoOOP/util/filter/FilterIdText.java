package it.univpm.progettoOOP.util.filter;

import java.util.Collection;

import it.univpm.progettoOOP.exceptions.IllegalIdException;
import it.univpm.progettoOOP.exceptions.IllegalWordException;
import it.univpm.progettoOOP.exceptions.WordNotFoundException;
import it.univpm.progettoOOP.model.Tweet;
/**
 * Interfaccia per la dichiarazione dei metodi utili per ottenere {@link Tweet} in base all'id o al testo
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * 
 * @version 1.0
 */
public interface FilterIdText {
	/**
	 * Metodo per ottenere un dato {@link Tweet} in base all'id inserito
	 * 
	 * @param sample Dataset da considerare
	 * @param id id del {@link Tweet}
	 * @return {@link Tweet} relativo all'id inserito
	 * @throws IllegalIdException {@link IllegalIdException}
	 */
	public Tweet getTweetFromId(Collection<Tweet> sample, String id) throws IllegalIdException;
	
	/**
	 * Metodo per ottenere un dataset di {@link Tweet} filtrato in base ad una parola contenuta nel testo
	 * 
	 * @param sample Dataset da considerare
	 * @param word Parola del testo di {@link Tweet}
	 * @return Dataset filtrato in base alla parola inserita
	 * @throws IllegalWordException {@link IllegalIdException}
	 * @throws WordNotFoundException {@link WordNotFoundException}
	 */
	public Collection<Tweet> getTweetsFromText(Collection<Tweet> sample, String word) 
			throws IllegalWordException, WordNotFoundException;
}
