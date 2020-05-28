package it.univpm.progettoOOP.util.stats;

import java.util.Collection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import it.univpm.progettoOOP.model.Tweet;

public interface TweetStats {
	
	public void setStats(Collection<Tweet> sample);
	public Stats getStatsAncona();
}
