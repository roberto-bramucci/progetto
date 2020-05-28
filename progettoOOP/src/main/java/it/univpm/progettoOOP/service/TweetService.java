package it.univpm.progettoOOP.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.module.jsonSchema.JsonSchema;

import it.univpm.progettoOOP.model.Tweet;
import it.univpm.progettoOOP.util.filter.Filter;

@Service
public interface TweetService {
	
	public Collection<Tweet> getData();
	public JsonSchema getMetadata();
}
