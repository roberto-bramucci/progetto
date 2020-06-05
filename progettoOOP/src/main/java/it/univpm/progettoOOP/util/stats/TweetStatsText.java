package it.univpm.progettoOOP.util.stats;

import java.util.Collection;

import it.univpm.progettoOOP.exceptions.EmptyCollectionException;
import it.univpm.progettoOOP.model.Tweet;

public interface TweetStatsText {
	public void setStatsText(Collection<Tweet> sample) throws EmptyCollectionException;
	public StatsText getStatsText();
}
