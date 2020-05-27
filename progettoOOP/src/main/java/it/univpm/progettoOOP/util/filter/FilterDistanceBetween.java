package it.univpm.progettoOOP.util.filter;

import it.univpm.progettoOOP.model.Tweet;

public class FilterDistanceBetween extends Filter2Distances implements Filter{

	
	public FilterDistanceBetween(Double distance1, Double distance2) {
		super(distance1, distance2);
		
	}

	@Override
	public boolean filter(Tweet tweet) {
		if(tweet.getDistance()<=distance2 && tweet.getDistance()>=distance1)
			return true;
		else
			return false;
	}
	
}
