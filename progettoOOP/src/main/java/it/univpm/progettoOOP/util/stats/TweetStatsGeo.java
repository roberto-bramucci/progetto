package it.univpm.progettoOOP.util.stats;

import java.util.Collection;


import it.univpm.progettoOOP.model.Tweet;

public interface TweetStatsGeo {
	
	public void setStatsGeo(Collection<Tweet> sample, String city);
	public StatsGeo getStatsGeo();
}
