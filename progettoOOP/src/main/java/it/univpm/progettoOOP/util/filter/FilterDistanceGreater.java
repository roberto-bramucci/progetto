package it.univpm.progettoOOP.util.filter;



import it.univpm.progettoOOP.model.Tweet;

public class FilterDistanceGreater extends FilterDistance implements Filter{

	public FilterDistanceGreater(Integer distance) {
		super(distance);
		
	}
	
	

	@Override
	public boolean filter(Tweet tweet) {
		if(tweet.getDistance(tweet)>distance)
			return true;
		else
			return false;
	}
	
}
