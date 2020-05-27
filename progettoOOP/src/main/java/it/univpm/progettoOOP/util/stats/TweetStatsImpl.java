package it.univpm.progettoOOP.util.stats;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import it.univpm.progettoOOP.model.*;
import it.univpm.progettoOOP.service.*;
import java.lang.Math;

public class TweetStatsImpl extends Stats{
	public TweetStatsImpl() {
		
		
	}
	
	public Stats getStatsAncona(Collection<Tweet> sample) {
		double rifx = 13.511831760406494;
		double rify = 43.61944828866362;
		Point2D.Double rifAnc = new Point2D.Double(rifx, rify);
		double R = 6372.795477598;
		ArrayList<Double> distances = new ArrayList<Double>();
		for(Tweet t:sample) {
			double lat = t.getGeo().y;
			double lon = t.getGeo().x;
			double dist =  R * Math.acos(Math.sin(lat) * Math.sin(rify) + Math.cos(lat) * Math.cos(rify) * Math.cos(lon-rifx));
			distances.add(dist);
		}
		
		Iterator<Double> it = distances.iterator();
		double min = 0;
		while(it.hasNext()) {
			min = distances.get(0);
			if(it.next() < min)
				min = it.next();
		}
		
		
	}
}
