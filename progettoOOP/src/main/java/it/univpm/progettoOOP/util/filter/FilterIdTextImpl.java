package it.univpm.progettoOOP.util.filter;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.progettoOOP.exceptions.IllegalIdException;
import it.univpm.progettoOOP.exceptions.IllegalWordException;
import it.univpm.progettoOOP.exceptions.WordNotFoundException;
import it.univpm.progettoOOP.model.Tweet;
/**
 * Classe che contiene l'implementazione dei metodi dichiarati in FilterIdText 
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * 
 * @version 1.0
 *
 */
public class FilterIdTextImpl implements FilterIdText{
	/**
	 * Collection che contiene i dati Tweet filtrati in base al campo text
	 */
	Collection<Tweet> filteredTexts = new ArrayList<Tweet>();
	
	@Override
	public Tweet getTweetFromId(Collection<Tweet> sample, String id) throws IllegalIdException{
		for (Tweet t : sample) {
			if(t.getId().equalsIgnoreCase(id)) {
				return t;
			}
		}
		throw new IllegalIdException("Questo id non esiste");		
	}
	
	@Override
	public Collection<Tweet> getTweetsFromText(Collection<Tweet> sample, String word) throws IllegalWordException, WordNotFoundException{
		if(word.length() == 1)
			throw new IllegalWordException("Inserire una parola più lunga");
		try {
			for(Tweet t : sample) {
				String text = t.getText();
				if(text.contains(word)) {
					boolean cont = false;
					do {
						cont = false;
						int prev;
						char p;
						if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')
							p = ' ';
						else {
							prev = text.indexOf(word) - 1;
							p = text.charAt(prev);
						}
						int succ = text.indexOf(word) + word.length();
						char s = text.charAt(succ);
						if((p == ' ' || p == '#' || p == '\'') && (s == ' ' || s == '.' || s == ',' || s == '!' || s == '?'))
							if(!filteredTexts.contains(t))
								filteredTexts.add(t);
						text = text.substring(succ);
						if(text.contains(word))
							cont = true;
					}
					while(cont);
				}
			}
			return filteredTexts;
		}
		catch(IndexOutOfBoundsException iEx) {
			throw new WordNotFoundException("La parola inserita non è disponibile");
		}
	}
}
