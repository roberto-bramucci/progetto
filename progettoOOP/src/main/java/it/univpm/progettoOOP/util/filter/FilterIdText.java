package it.univpm.progettoOOP.util.filter;

import java.util.Collection;

import it.univpm.progettoOOP.exceptions.IllegalIdException;
import it.univpm.progettoOOP.exceptions.IllegalWordException;
import it.univpm.progettoOOP.exceptions.WordNotFoundException;
import it.univpm.progettoOOP.model.Tweet;

public interface FilterIdText {
	
	public Tweet getTweetFromId(Collection<Tweet> sample, String id) throws IllegalIdException;
	public Collection<Tweet> getTweetsFromText(Collection<Tweet> sample, String word) 
			throws IllegalWordException, WordNotFoundException;
}
