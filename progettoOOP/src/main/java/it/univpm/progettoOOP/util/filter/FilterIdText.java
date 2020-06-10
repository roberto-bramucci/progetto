package it.univpm.progettoOOP.util.filter;

import java.util.Collection;

import it.univpm.progettoOOP.exceptions.IllegalIdException;
import it.univpm.progettoOOP.exceptions.IllegalWordException;
import it.univpm.progettoOOP.exceptions.WordNotFoundException;
import it.univpm.progettoOOP.model.Tweet;
/**
 * Interfaccia per la dichiarazione dei metodi utili per ottenere Tweet in base all'id o al testo
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * 
 * @version 1.0
 */
public interface FilterIdText {
	/**
	 * Metodo per ottenere un dato Tweet in base all'id inserito
	 * 
	 * @param sample Dataset da considerare
	 * @param id id del Tweet
	 * @return Tweet relativo all'id inserito
	 * @throws IllegalIdException
	 */
	public Tweet getTweetFromId(Collection<Tweet> sample, String id) throws IllegalIdException;
	
	/**
	 * Metodo per ottenere un dataset di Tweet filtrato in base ad una parola contenuta nel testo
	 * 
	 * @param sample Dataset da considerare
	 * @param word Parola del testo di Tweet
	 * @return Dataset filtrato in base alla parola inserita
	 * @throws IllegalWordException
	 * @throws WordNotFoundException
	 */
	public Collection<Tweet> getTweetsFromText(Collection<Tweet> sample, String word) 
			throws IllegalWordException, WordNotFoundException;
}
