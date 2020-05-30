package it.univpm.progettoOOP.controller;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import it.univpm.progettoOOP.service.*;
import it.univpm.progettoOOP.util.filter.*;
import it.univpm.progettoOOP.util.stats.*;
import it.univpm.progettoOOP.model.*;

@RestController
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	
	private TweetStats tweetStats = new TweetStatsImpl();
	
	
	@RequestMapping(value ="/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMeta() {
		return new ResponseEntity<>(tweetService.getMetadata(), HttpStatus.OK);
	}
	
	@RequestMapping(value ="/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweetNoFilter(){
		return new ResponseEntity<>(tweetService.getData(), HttpStatus.OK);
	}
	
	@RequestMapping (value = "/tweet/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweetFromId(@PathVariable String id){
		return new ResponseEntity<>(tweetService.getTweetFromId(id), HttpStatus.OK);
	}
	
	@RequestMapping(value ="/data/geo", method = RequestMethod.POST)
	public ResponseEntity<Object> getTweetWithFilter(@RequestBody String filter){
		JSONObject obj = new JSONObject(filter);
		FilterUtils<Tweet> utl = new FilterUtils<>();
		TweetFilter tweetsFil = new TweetFilter((ArrayList<Tweet>)tweetService.getData(), utl);
		return new ResponseEntity<>(parseFilter(tweetsFil, obj), HttpStatus.OK);
	}
	
	@RequestMapping(value ="/data/stats", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweetStats(){;
		tweetStats.setStats(tweetService.getData());
		return new ResponseEntity<>(tweetStats.getStatsAncona(), HttpStatus.OK);
	}
	
	private ArrayList<Tweet> parseFilter(TweetFilter twFIl, JSONObject json) {
		String name = json.keys().next();
		switch (name) {
		case "$lt":
        case "$gt":
        case "$gte":
        case "$lte":
        case "$eq":
    	{
    		double rif = json.getDouble(name);
			return twFIl.chooseFilter(name, rif);
    	}
        case "$bt":
        {
        	 double min = json.getJSONArray(name).getDouble(0);
             double max = json.getJSONArray(name).getFloat(1);
             return twFIl.chooseFilter(name, min, max);
        }
        default:
        	return null;
		}
		
	} 
}