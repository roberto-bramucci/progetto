package it.univpm.progettoOOP.service;

import java.util.Collection;

import com.fasterxml.jackson.module.jsonSchema.JsonSchema;

import it.univpm.progettoOOP.model.Tweet;

public interface TweetService {
	
	public Collection<Tweet> getData();
	public JsonSchema getMetadata();

}
