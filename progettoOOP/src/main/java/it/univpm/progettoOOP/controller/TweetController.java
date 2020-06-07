package it.univpm.progettoOOP.controller;


import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.json.JSONException;
import org.json.JSONObject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import it.univpm.progettoOOP.service.*;
import it.univpm.progettoOOP.util.filter.*;
import it.univpm.progettoOOP.util.stats.*;
import it.univpm.progettoOOP.exceptions.BlankFilterException;
import it.univpm.progettoOOP.exceptions.CityNotFoundException;
import it.univpm.progettoOOP.exceptions.EmptyCollectionException;
import it.univpm.progettoOOP.exceptions.FilterNotFoundException;
import it.univpm.progettoOOP.exceptions.GenericFilterException;
import it.univpm.progettoOOP.exceptions.GenericServiceException;
import it.univpm.progettoOOP.exceptions.IllegalIdException;
import it.univpm.progettoOOP.exceptions.IllegalIntervalException;
import it.univpm.progettoOOP.exceptions.IllegalWordException;
import it.univpm.progettoOOP.exceptions.NegativeValueException;
import it.univpm.progettoOOP.exceptions.WordNotFoundException;
import it.univpm.progettoOOP.model.*;

@RestController
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
		
	
	@RequestMapping(value ="/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMeta() throws GenericServiceException{
		return new ResponseEntity<>(tweetService.getMetadata(), HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value ="/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getData() throws GenericServiceException{
		return new ResponseEntity<>(tweetService.getData(), HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value ="/data/{city}", method = RequestMethod.POST)
	public ResponseEntity<Object> getDataWithFilter(@PathVariable ("city") String city, 
			@RequestBody String filter) 
					throws GenericServiceException, FilterNotFoundException, CityNotFoundException, NegativeValueException,
					IllegalIntervalException, GenericFilterException, BlankFilterException{
			try {
			JSONObject obj = new JSONObject(filter);
			FilterUtils<Tweet> utl = new FilterUtils<>();
			TweetFilter tweetsFil = new TweetFilter((ArrayList<Tweet>)tweetService.getData(), utl);
			return new ResponseEntity<>(parseFilter(tweetsFil, obj, city), HttpStatus.OK);
			}
			catch(NoSuchElementException e) {
				throw new BlankFilterException("Nessun filtro inserito");
			}
			catch(JSONException e) {
				throw new FilterNotFoundException("Il filtro inserito è incompleto o scorretto");
			}
		}
	
	
	
	@RequestMapping (value = "/data/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweetId (@PathVariable ("id") String id) 
			throws GenericServiceException, IllegalIdException{
		FilterIdText fil = new FilterIdTextImpl();
		return new ResponseEntity<>(fil.getTweetFromId(tweetService.getData(), id), HttpStatus.OK);
	}
	
	
	
	@RequestMapping (value = "/data/text/{word}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweetText(@PathVariable ("word") String word)
			throws GenericServiceException, IllegalWordException, WordNotFoundException{
		FilterIdText fil = new FilterIdTextImpl();
		return new ResponseEntity<>(fil.getTweetsFromText(tweetService.getData(), word), HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "data/stats/text", method = RequestMethod.GET)
	public ResponseEntity<Object> getStatsTextNoFilter() 
			throws GenericServiceException, EmptyCollectionException{
		TweetStatsText tweetStatsText = new TweetStatsTextImpl();
		tweetStatsText.setStatsText(tweetService.getData());
		return new ResponseEntity<>(tweetStatsText.getStatsText(), HttpStatus.OK); 
	}

	
	
	@RequestMapping(value = "data/stats/text/{word}", method = RequestMethod.GET)
	public ResponseEntity<Object> getStatsText(@PathVariable("word") String word) 
					throws GenericServiceException, EmptyCollectionException, IllegalWordException, WordNotFoundException{
			FilterIdText fil =  new FilterIdTextImpl();
			ArrayList<Tweet> filteredArray = (ArrayList<Tweet>)fil.getTweetsFromText(tweetService.getData(), word);
			TweetStatsText tweetStatsText = new TweetStatsTextImpl();
			tweetStatsText.setStatsText(filteredArray);
			return new ResponseEntity<>(tweetStatsText.getStatsText(), HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value = "data/stats/text/{word}/{city}", method = RequestMethod.POST)
	public ResponseEntity<Object> getStatsTextWithFilter(@PathVariable("word") String word, 
			@PathVariable ("city") String city, @RequestBody String filter) 
					throws GenericServiceException, FilterNotFoundException, EmptyCollectionException, CityNotFoundException, NegativeValueException,
					IllegalIntervalException, GenericFilterException, IllegalWordException, WordNotFoundException, BlankFilterException{
		
			try {
				JSONObject obj = new JSONObject(filter);
				FilterUtils<Tweet> utl = new FilterUtils<>();
				TweetFilter tweetsFil = new TweetFilter((ArrayList<Tweet>)tweetService.getData(), utl);
				ArrayList<Tweet> filteredArray = parseFilter(tweetsFil, obj, city);
				FilterIdText fil = new FilterIdTextImpl();
				ArrayList<Tweet> newFilteredArray = (ArrayList<Tweet>)fil.getTweetsFromText(filteredArray, word);
				TweetStatsText tweetStatsText = new TweetStatsTextImpl();
				tweetStatsText.setStatsText(newFilteredArray);
				return new ResponseEntity<>(tweetStatsText.getStatsText(), HttpStatus.OK);
			}
			catch(NoSuchElementException e) {
				throw new BlankFilterException("Nessun filtro inserito");
			}
			catch(JSONException e) {
				throw new FilterNotFoundException("Il filtro inserito è incompleto o scorretto");
			}
	}
	
	
	
	@RequestMapping(value = "data/stats/geo/{city}", method = RequestMethod.POST)
	public ResponseEntity<Object> getStatsGeoWithFilter(@PathVariable ("city") String city, 
			@RequestBody (required = false) String filter) 
					throws GenericServiceException, FilterNotFoundException, EmptyCollectionException, CityNotFoundException, NegativeValueException,
					IllegalIntervalException, GenericFilterException{
		if (filter == null) {
			TweetStatsGeo tweetStatsGeo = new TweetStatsGeoImpl();
			tweetStatsGeo.setStatsGeo(tweetService.getData(), city);
			return new ResponseEntity<>(tweetStatsGeo.getStatsGeo(), HttpStatus.OK);
		}
		else {
			try {
				JSONObject obj = new JSONObject(filter);
				FilterUtils<Tweet> utl = new FilterUtils<>();
				TweetFilter tweetsFil = new TweetFilter((ArrayList<Tweet>)tweetService.getData(), utl);
				ArrayList<Tweet> filteredArray = parseFilter(tweetsFil, obj, city);
				TweetStatsGeo tweetStatsGeo = new TweetStatsGeoImpl();
				tweetStatsGeo.setStatsGeo(filteredArray, city);
				return new ResponseEntity<>(tweetStatsGeo.getStatsGeo(), HttpStatus.OK);
			}
			catch(JSONException e) {
				throw new FilterNotFoundException("Il filtro inserito è incompleto");
			}
		}
	}
		
	
	
	private ArrayList<Tweet> parseFilter(TweetFilter twFIl, JSONObject json, String city)
			throws FilterNotFoundException, CityNotFoundException, NegativeValueException,
			IllegalIntervalException, GenericFilterException {
		String name = json.keys().next();
		switch (name) {
		case "$lt":
        case "$gt":
        case "$gte":
        case "$lte":
        case "$eq":
    	{
    		double rif = json.getDouble(name);
			return twFIl.chooseFilter(name, city, rif);
    	}
        case "$bt":
        {
        	 double min = json.getJSONArray(name).getDouble(0);
             double max = json.getJSONArray(name).getFloat(1);
             return twFIl.chooseFilter(name, city, min, max);
        }
        default:
        	throw new FilterNotFoundException("Il filtro inserito non esiste");
		}	
	} 
}