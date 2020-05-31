package it.univpm.progettoOOP.util.stats;

import java.util.Collection;


import it.univpm.progettoOOP.model.Tweet;

public interface TweetStats {
	
	public void setStats(Collection<Tweet> sample);
	public Stats getStatsAncona();
}
