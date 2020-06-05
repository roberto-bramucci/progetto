package it.univpm.progettoOOP.util.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.progettoOOP.exceptions.EmptyCollectionException;
import it.univpm.progettoOOP.model.Tweet;

public class TweetStatsTextImpl extends StatsText implements TweetStatsText{
	
	private ArrayList<Integer> length = new ArrayList<Integer>();
	private StatsText statistics = new StatsText();
	
	public void setStatsText(Collection<Tweet> sample) throws EmptyCollectionException {
		try {
			for(Tweet t : sample) {
				length.add(t.getText().length());
			}
			
			statistics.setNumTweetAnalyzed(length.size());
			
			if(length.size() != 0) {
				double min = length.get(0);
				for(int i = 1; i < length.size(); i++) {
					if(length.get(i) < min)
						min = length.get(i);
				}
				statistics.setMinLength(min);
	
				double max = length.get(0);
				for(int i = 1; i < length.size(); i++) {
					if(length.get(i) > max)
						max = length.get(i);
				}
				statistics.setMaxLength(max);
				
				double sum = 0;
				statistics.setSumLength(sum);
				for(int i = 0; i < length.size(); i++) {
					sum += length.get(i);
				}
				statistics.setSumLength(sum);
				statistics.setAvgLength(sum/length.size());
			}
			else
				throw new EmptyCollectionException("Nessun dato analizzabile con questo filtro");

			}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public StatsText getStatsText() {
		return statistics;
	}
		
}
