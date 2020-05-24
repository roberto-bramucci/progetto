package it.univpm.progettoOOP.service;

import java.util.Collection;

import it.univpm.progettoOOP.model.Tweet;

public interface TweetService {
	
	public Collection<Tweet> getData();
	public String getMetadata();

}
