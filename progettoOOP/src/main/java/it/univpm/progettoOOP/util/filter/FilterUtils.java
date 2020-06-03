package it.univpm.progettoOOP.util.filter;

import java.util.ArrayList;
import java.util.Collection;


import it.univpm.progettoOOP.model.Tweet;

public class FilterUtils<T> {
	
	public static boolean check(Tweet value, String operator, Double... th){
		if (th.length == 1 && th[0] instanceof Double && value instanceof Tweet) {	
			Double thC = (Double)th[0];
			Double valuec = value.getDistance();
			if (operator.equals("$gt"))
				return valuec > thC;
			else if (operator.equals("$gte"))
				return valuec >= thC;
			else if (operator.equals("$lt"))
				return valuec < thC;
			else if (operator.equals("$lte"))
				return valuec <= thC;
			
		}
		else if (th.length == 2 && th[0] instanceof Double && th[1] instanceof Double && value instanceof Tweet) {
			Double thC1 = (Double)th[0];
			Double thC2 = (Double)th[1];
			Double valuec = value.getDistance();
			if (operator.equals("$bt")) {
				if (thC1<=thC2)
					return valuec >= thC1 && valuec <= thC2;
				else
					throw new IllegalArgumentException("thC1 must be lower than thC2");
			}
		}
	return false;
	}
	
	public Collection<Tweet> select(Collection<Tweet> src, String operator, Double... value) {
		Collection<Tweet> out = new ArrayList<>();
		for(Tweet item : src) {
			try {
				if(FilterUtils.check(item, operator, value))
					out.add(item);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		return out;
	}
}
