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
/**
 * Classe Controller per la gestione delle rotte della REST API 
 * 
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * 
 * @version 1.0
 * 
 */
@RestController
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	/**
	 * Rotta per ottenere i metadati relativi al dataset in formato JSON
	 * 
	 * @return Metadati relativi a un dato di tipo Tweet
	 * @throws GenericServiceException Eccezione lanciata nel Service
	 */
	
	@RequestMapping(value ="/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMeta() throws GenericServiceException{
		return new ResponseEntity<>(tweetService.getMetadata(), HttpStatus.OK);
	}
	/**
	 * Rotta per ottenere i dati di tipo Tweet relativi al dataset in formato JSON
	 * 
	 * @return Dati di tipo {@link Tweet}
	 * @throws GenericServiceException {@link GenericServiceException}
	 */
	
	@RequestMapping(value ="/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getData() throws GenericServiceException{
		return new ResponseEntity<>(tweetService.getData(), HttpStatus.OK);
	}
	
	/**
	 * Rotta per ottenere i dati di tipo Tweet filtrati in base alla distanza 
	 * da una delle città disponibili (Ancona, Milano, Napoli, Roma)
	 * 
	 * @param city Citta' da cui si vuole considerare la distanza
	 * @param filter Filtro di distanza da applicare al dataset
	 * @return Dati di tipo Tweet filtrati in base alla citta' scelta, se presenti
	 * @throws GenericServiceException {@link GenericServiceException}
	 * @throws FilterNotFoundException {@link FilterNotFoundException}
	 * @throws CityNotFoundException {@link CityNotFoundException}
	 * @throws NegativeValueException {@link NegativeValueException}
	 * @throws IllegalIntervalException {@link IllegalIntervalException}
	 * @throws GenericFilterException {@link GenericFilterException}
	 * @throws BlankFilterException {@link BlankFilterException}
	 */
	
	@RequestMapping(value ="/data/{city}", method = RequestMethod.POST)
	public ResponseEntity<Object> getDataWithFilter(@PathVariable ("city") String city, 
			@RequestBody String filter) 
					throws GenericServiceException, FilterNotFoundException, CityNotFoundException, NegativeValueException,
					IllegalIntervalException, GenericFilterException, BlankFilterException{
			try {
			JSONObject obj = new JSONObject(filter);
			FilterUtils<Tweet> utl = new FilterUtils<>();
			TweetFilter tweetsFil = new TweetFilter((ArrayList<Tweet>)tweetService.getData(), utl);
			return new ResponseEntity<>(tweetsFil.parseFilter(obj, city), HttpStatus.OK);
			}
			catch(NoSuchElementException e) {
				throw new BlankFilterException("Nessun filtro inserito");
			}
			catch(JSONException e) {
				throw new FilterNotFoundException("Il filtro inserito è incompleto o scorretto");
			}
		}
	
	/**
	 * Rotta per ottenere un dato di tipo Tweet in base al suo id
	 * 
	 * @param id id del dato di tipo {@link Tweet} che si vuole ottenere
	 * @return Tweet corrispondente all'id specificato
	 * @throws GenericServiceException {@link GenericServiceException}
	 * @throws IllegalIdException {@link IllegalIdException}
	 */
		
	@RequestMapping (value = "/data/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweetId (@PathVariable ("id") String id) 
			throws GenericServiceException, IllegalIdException{
		FilterIdText fil = new FilterIdTextImpl();
		return new ResponseEntity<>(fil.getTweetFromId(tweetService.getData(), id), HttpStatus.OK);
	}
	
	/**
	 * Rotta per ottenere i dati di tipo {@link Tweet} filtrati in base ad una parola contenuta nel testo
	 * 
	 * @param word Parola contenuta nel testo del {@link Tweet}
	 * @return {@link Tweet} che contengono la parola specificata, se presenti
	 * @throws GenericServiceException {@link GenericServiceException}
	 * @throws IllegalWordException {@link IllegalWordException}
	 * @throws WordNotFoundException {@link WordNotFoundException}
	 */
	
	@RequestMapping (value = "/data/text/{word}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweetText(@PathVariable ("word") String word)
			throws GenericServiceException, IllegalWordException, WordNotFoundException{
		FilterIdText fil = new FilterIdTextImpl();
		return new ResponseEntity<>(fil.getTweetsFromText(tweetService.getData(), word), HttpStatus.OK);
	}
	
	/**
	 * Rotta per ottenere statistiche relative alla lunghezza del testo di tutti i {@link Tweet} del dataset
	 *  
	 * @return Statistiche sulla lunghezza del testo
	 * @throws GenericServiceException {@link GenericServiceException}
	 * @throws EmptyCollectionException {@link EmptyCollectionException}
	 */
	
	@RequestMapping(value = "data/stats/text", method = RequestMethod.GET)
	public ResponseEntity<Object> getStatsTextNoFilter() 
			throws GenericServiceException, EmptyCollectionException{
		TweetStatsText tweetStatsText = new TweetStatsTextImpl();
		tweetStatsText.setStatsText(tweetService.getData());
		return new ResponseEntity<>(tweetStatsText.getStatsText(), HttpStatus.OK); 
	}
	
	/**
	 * Rotta per ottenere statistiche relative alla lunghezza del testo dei dati di tipo {@link Tweet}
	 * filtrati in base ad una parola contenuta nel testo
	 * 
	 * @param word Parola contenuta nel testo del {@link Tweet}
	 * @return Statistiche sui Tweet che contengono la parola specificata, se presenti
	 * @throws GenericServiceException {@link GenericServiceException}
	 * @throws EmptyCollectionException {@link EmptyCollectionException}
	 * @throws IllegalWordException {@link IllegalWordException}
	 * @throws WordNotFoundException {@link WordNotFoundException}
	 */

	
	
	@RequestMapping(value = "data/stats/text/{word}", method = RequestMethod.GET)
	public ResponseEntity<Object> getStatsText(@PathVariable("word") String word) 
					throws GenericServiceException, EmptyCollectionException, IllegalWordException, WordNotFoundException{
			FilterIdText fil =  new FilterIdTextImpl();
			ArrayList<Tweet> filteredArray = (ArrayList<Tweet>)fil.getTweetsFromText(tweetService.getData(), word);
			TweetStatsText tweetStatsText = new TweetStatsTextImpl();
			tweetStatsText.setStatsText(filteredArray);
			return new ResponseEntity<>(tweetStatsText.getStatsText(), HttpStatus.OK);
		
	}
	/**
	 * Rotta per ottenere statistiche relative alla lunghezza del testo dei dati di tipo {@link Tweet}
	 * filtrati in base ad una parola contenuta nel testo e alla distanza da una delle citta' disponibili
	 *
	 * @param word Parola contenuta nel testo del {@link Tweet}
	 * @param city Citta' da cui si vuole considerare la distanza
	 * @param filter Filtro di distanza ad applicare al dataset
	 * @return Statistiche sul testo dei Tweet che contengono la parola specificata e 
	 * filtrati in base alla citta' scelta
	 * 
	 * @throws GenericServiceException {@link GenericServiceException}
	 * @throws FilterNotFoundException {@link FilterNotFoundException}
	 * @throws EmptyCollectionException {@link EmptyCollectionException}
	 * @throws CityNotFoundException {@link CityNotFoundException}
	 * @throws NegativeValueException {@link NegativeValueException}
	 * @throws IllegalIntervalException {@link IllegalIntervalException}
	 * @throws GenericFilterException {@link GenericFilterException}
	 * @throws IllegalWordException  {@link IllegalWordException}
	 * @throws WordNotFoundException {@link WordNotFoundException}
	 * @throws BlankFilterException {@link BlankFilterException}
	 */
	
	
	@RequestMapping(value = "data/stats/text/{word}/{city}", method = RequestMethod.POST)
	public ResponseEntity<Object> getStatsTextWithFilter(@PathVariable("word") String word, 
			@PathVariable ("city") String city, @RequestBody String filter) 
					throws GenericServiceException, FilterNotFoundException, EmptyCollectionException, CityNotFoundException, NegativeValueException,
					IllegalIntervalException, GenericFilterException, IllegalWordException, WordNotFoundException, BlankFilterException{
		
			try {
				JSONObject obj = new JSONObject(filter);
				FilterUtils<Tweet> utl = new FilterUtils<>();
				TweetFilter tweetsFil = new TweetFilter((ArrayList<Tweet>)tweetService.getData(), utl);
				ArrayList<Tweet> filteredArray = tweetsFil.parseFilter(obj, city);
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
	
	/**
	 * Rotta per ottenere statistiche relative alla distanza dei dati di tipo {@link Tweet} dalla citta' 
	 * specificata, con la possibilita' di inserire filtri di distanza 
	 * 
	 * @param city Città da cui si vuole considerare la distanza
	 * @param filter Filtro di distanza ad applicare al dataset (facoltativo)
	 * @return Statistiche sulla distanza dei {@link Tweet}, eventualmente
	 * filtrati in base alla città scelta
	 * 
	 * @throws GenericServiceException {@link GenericServiceException}
	 * @throws FilterNotFoundException {@link FilterNotFoundException}
	 * @throws EmptyCollectionException {@link EmptyCollectionException}
	 * @throws CityNotFoundException {@link CityNotFoundException}
	 * @throws NegativeValueException {@link NegativeValueException}
	 * @throws IllegalIntervalException {@link IllegalIntervalException}
	 * @throws GenericFilterException {@link GenericFilterException}
	 */
	
	
	
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
				ArrayList<Tweet> filteredArray = tweetsFil.parseFilter(obj, city);
				TweetStatsGeo tweetStatsGeo = new TweetStatsGeoImpl();
				tweetStatsGeo.setStatsGeo(filteredArray, city);
				return new ResponseEntity<>(tweetStatsGeo.getStatsGeo(), HttpStatus.OK);
			}
			catch(JSONException e) {
				throw new FilterNotFoundException("Il filtro inserito è incompleto");
			}
		}
	}
}
