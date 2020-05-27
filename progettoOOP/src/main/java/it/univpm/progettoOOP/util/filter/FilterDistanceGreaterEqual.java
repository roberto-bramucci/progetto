package it.univpm.progettoOOP.util.filter;

import it.univpm.progettoOOP.model.Tweet;

public class FilterDistanceGreaterEqual extends FilterDistance implements Filter {

	public FilterDistanceGreaterEqual(Double distance) {
		super(distance);
		
	}

	@Override
	public boolean filter(Tweet tweet) {
		if(tweet.getDistance()>=distance)
			return true;
		else
			return false;
	}

}
