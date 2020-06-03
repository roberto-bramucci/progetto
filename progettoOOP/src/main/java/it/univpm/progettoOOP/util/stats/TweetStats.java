package it.univpm.progettoOOP.util.stats;

import java.util.Collection;

import org.json.JSONObject;

import it.univpm.progettoOOP.model.Tweet;

public interface TweetStats {
	
	public void setStats(Collection<Tweet> sample, String city);
	public Stats getStats();
}
