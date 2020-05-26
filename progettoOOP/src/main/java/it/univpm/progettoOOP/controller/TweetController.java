package it.univpm.progettoOOP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.progettoOOP.service.TweetService;

@RestController
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	
	@RequestMapping(value ="/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMeta() {
		return new ResponseEntity<>(tweetService.getMetadata(), HttpStatus.OK);
	}
	
	@RequestMapping(value ="/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweetNoFilter(){
		return new ResponseEntity<>(tweetService.getData(), HttpStatus.OK);
	}
	
	//@RequestMapping(value ="/data/geo/{geo}", method = RequestMethod.GET)
	//public ResponseEntity<Object> getTweetWithFilter(@RequestBody String filter){
		//inserire filtro
	//}
}
