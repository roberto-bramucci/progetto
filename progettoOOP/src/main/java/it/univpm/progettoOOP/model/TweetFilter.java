package it.univpm.progettoOOP.model;

import java.util.ArrayList;


import it.univpm.progettoOOP.util.filter.Filter;
import it.univpm.progettoOOP.util.filter.FilterUtils;

public class TweetFilter implements Filter<Tweet, Object[]> {
	private ArrayList<Tweet> sample;
	private FilterUtils<Tweet> utils;
	
	public TweetFilter(ArrayList<Tweet> sample, FilterUtils<Tweet> utils) {
		this.sample = sample;
		this.utils = utils;
	}
	
	public TweetFilter(ArrayList<Tweet> sample) {
		this.sample = sample;
	}
	
	public TweetFilter() {}

	public ArrayList<Tweet> getSample() {
		return sample;
	}
	
	public void setSample(ArrayList<Tweet> sample) {
		this.sample = sample;
	}
	
	public FilterUtils<Tweet> getUtils() {
		return utils;
	}
	
	public void setUtils(FilterUtils<Tweet> utils) {
		this.utils = utils;
	}
	
	@Override
	public ArrayList<Tweet> chooseFilter(String operator, String city, Double... value) {
		return (ArrayList<Tweet>) utils.select(this.getSample(), operator, city,  value);
	}
}
