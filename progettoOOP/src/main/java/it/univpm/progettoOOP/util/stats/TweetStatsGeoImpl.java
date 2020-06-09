package it.univpm.progettoOOP.util.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;
import it.univpm.progettoOOP.exceptions.EmptyCollectionException;
import it.univpm.progettoOOP.model.*;
/**
 * Classe che contiene l'implementazione dei metodi dichiarati in TweetStatsGeo
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * 
 * @version 1.0
 */
public class TweetStatsGeoImpl extends StatsGeo implements TweetStatsGeo{
	/**
	 * Collection che contiene i dati Tweet su cui calcolare le statistiche relative al campo geo
	 */
	private ArrayList<Double> distances = new ArrayList<Double>();
	/**
	 * Oggetto di tipo StatsGeo che contiene le statistiche calcolate
	 */
	private StatsGeo statistics = new StatsGeo();
	/**
	 * Implementazione del metodo definito nell'interfaccia TweetStatsGeo
	 */
	@Override
	public void setStatsGeo(Collection<Tweet> sample, String city) throws EmptyCollectionException, CityNotFoundException{
		try {
			for(Tweet t : sample) {
				distances.add(t.chooseCity(city));
			}
			
			statistics.setNumTweetAnalyzed(distances.size());
			
			if(distances.size() != 0) {
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
			}
			else
				throw new EmptyCollectionException("Nessun dato analizzabile con questo filtro");
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public StatsGeo getStatsGeo() {
		return statistics;
	}
	
}
