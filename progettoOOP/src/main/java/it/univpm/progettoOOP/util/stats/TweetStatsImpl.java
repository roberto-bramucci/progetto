package it.univpm.progettoOOP.util.stats;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import it.univpm.progettoOOP.model.*;
import it.univpm.progettoOOP.service.TweetService;

public class TweetStatsImpl extends Stats implements TweetStats{
	
	private static ArrayList<Double> distances = new ArrayList<Double>();
	private static Stats statistics = new Stats();
	
	public TweetStatsImpl() {}
	
	public void setStats(Collection<Tweet> sample) {
		try {
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
			
			double t = 0;
			double a = 0;
			a = sum/distances.size();
			for (int i = 0; i < distances.size(); i++) {
				t += (distances.get(i)-a)*(distances.get(i)-a);
			}
			double var = t/(distances.size());
			statistics.setVarDist(var);
			statistics.setDevStdDist(Math.sqrt(var));
			
			
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public Stats getStatsAncona() {
		return statistics;
	}
}
