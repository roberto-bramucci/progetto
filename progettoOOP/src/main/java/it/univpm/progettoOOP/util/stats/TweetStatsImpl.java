package it.univpm.progettoOOP.util.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.progettoOOP.model.*;

public class TweetStatsImpl extends Stats{
	public TweetStatsImpl() {
		
		
	}
	
	public Stats getStatsAncona(Collection<Tweet> sample) {
		Stats statistics = new Stats();
		ArrayList<Double> distances = new ArrayList<Double>();
		for(Tweet t : sample) {
			distances.add(t.getDistance());
		}

		double min = distances.get(0);
		for(int i = 1; i < distances.size(); i++) {
			if(distances.get(i) < min)
				min = distances.get(i);
		}
		statistics.setMinDist(min);
		
		double max = distances.get(0);
		for(int i = 1; i < distances.size(); i++) {
			if(distances.get(i) > max)
				max = distances.get(i);
		}
		statistics.setMaxDist(max);
		
		double sum = 0;
		for(int i = 0; i < distances.size(); i++) {
			sum += distances.get(i);
		}
		statistics.setSumDist(sum);
		statistics.setAvgDist(sum/distances.size());
		
		return statistics;
	}
}
