package it.univpm.progettoOOP.util.filter;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.progettoOOP.exceptions.IllegalIdException;
import it.univpm.progettoOOP.model.Tweet;

public class FilterIdTextImpl implements FilterIdText{
	
	Collection<Tweet> filteredTexts = new ArrayList<Tweet>();
	
	public Tweet getTweetFromId(Collection<Tweet> sample, String id) throws IllegalIdException{
		for (Tweet t : sample) {
			if(t.getId().equalsIgnoreCase(id)) {
				return t;
			}
		}
		throw new IllegalIdException("Questo id non esiste");		
	}
	
	public Collection<Tweet> getTweetsFromText(Collection<Tweet> sample, String word){
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
} //indexoutofbound se numero 
