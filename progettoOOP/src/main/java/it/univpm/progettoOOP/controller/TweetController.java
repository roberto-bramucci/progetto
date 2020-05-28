package it.univpm.progettoOOP.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	//@RequestMapping(value ="/data/geo", method = RequestMethod.GET)
	//public ResponseEntity<Object> getTweetWithFilter(@RequestBody Filter filter){
	//	return new ResponseEntity<>(tweetService.getDataFilter(filter), HttpStatus.OK);
	//}
	
	@RequestMapping(value ="/data/stats", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweetStats(){;
		tweetStats.setStats(tweetService.getData());
		return new ResponseEntity<>(tweetStats.getStatsAncona(), HttpStatus.OK);
	}
	
}