package it.univpm.progettoOOP.util.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.progettoOOP.model.*;

public class TweetStatsGeoImpl extends StatsGeo implements TweetStatsGeo{
	
	private ArrayList<Double> distances = new ArrayList<Double>();
	private StatsGeo statistics = new StatsGeo();
	
	public void setStatsGeo(Collection<Tweet> sample, String city) {
		try {
			for(Tweet t : sample) {
				distances.add(t.chooseCity(city));
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
			statistics.setSumDist(sum);
			for(int i = 0; i < distances.size(); i++) {
				sum += distances.get(i);
			}
			statistics.setSumDist(sum);
			statistics.setAvgDist(sum/distances.size());
		
			double t = 0;
			double a = 0;
			a = sum/distances.size();
			for (int i = 0; i < distances.size(); i++) {
				t += (distances.get(i)-a)*(distances.get(i)-a);
			}
			double var = t/(distances.size());
			statistics.setVarDist(var);
			statistics.setDevStdDist(Math.sqrt(var));
			
			statistics.setNumTweetAnalyzed(distances.size());
		
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public StatsGeo getStatsGeo() {
		return statistics;
	}
	
}
