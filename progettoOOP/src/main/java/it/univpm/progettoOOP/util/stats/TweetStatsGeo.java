package it.univpm.progettoOOP.util.stats;

import java.util.Collection;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;
import it.univpm.progettoOOP.exceptions.EmptyCollectionException;
import it.univpm.progettoOOP.model.Tweet;

public interface TweetStatsGeo {
	
	public void setStatsGeo(Collection<Tweet> sample, String city) throws EmptyCollectionException, CityNotFoundException;
	public StatsGeo getStatsGeo();
}
