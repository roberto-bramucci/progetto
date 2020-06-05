package it.univpm.progettoOOP.util.stats;

import java.util.Collection;

import it.univpm.progettoOOP.model.Tweet;

public interface TweetStatsText {
	public void setStatsText(Collection<Tweet> sample);
	public StatsText getStatsText();
}
