package it.univpm.progettoOOP.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;
import it.univpm.progettoOOP.exceptions.FilterNotFoundException;
import it.univpm.progettoOOP.exceptions.GenericFilterException;
import it.univpm.progettoOOP.exceptions.IllegalIntervalException;
import it.univpm.progettoOOP.exceptions.NegativeValueException;
import it.univpm.progettoOOP.util.filter.Filter;
import it.univpm.progettoOOP.util.filter.FilterUtils;

/**
 * Classe per la modellazione dei filtri di distanza su dati di tipo {@link Tweet}
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 * @version 1.0
 */

public class TweetFilter implements Filter<Tweet> {
	/**
	 * Dataset su cui effettuare il filtro di distanza
	 */
	private ArrayList<Tweet> sample;
	/**
	 * Oggetto della classe {@link FilterUtils} per la scelta del filtro
	 */
	private FilterUtils<Tweet> utils;
	
	/**
	 * Costruttore con parametri
	 * 
	 * @param sample Dataset da filtrare
	 * @param utils Oggetto della classe {@link FilterUtils} per la scelta del filtro
	 */
	
	public TweetFilter(ArrayList<Tweet> sample, FilterUtils<Tweet> utils) {
		this.sample = sample;
		this.utils = utils;
	}
	
	/**
	 * Costruttore con il solo parametro relativo al campione di dati
	 * 
	 * @param sample Dataset da filtrare
	 */
	
	public TweetFilter(ArrayList<Tweet> sample) {
		this.sample = sample;
	}
	
	/**
	 * Metodo per ottenere il dataset da filtrare
	 * 
	 * @return Dataset da filtrare
	 */
	
	public ArrayList<Tweet> getSample() {
		return sample;
	}
	
	/**
	 * Metodo per impostare il dataset da filtrare
	 * 
	 * @param sample Dataset da filtrare
	 */
	
	public void setSample(ArrayList<Tweet> sample) {
		this.sample = sample;
	}
	
	/**
	 * Metodo per ottenere l'oggetto della classe {@link FilterUtils} per la scelta del filtro
	 * 
	 * @return Oggetto di {@link FilterUtils}
	 */
	
	public FilterUtils<Tweet> getUtils() {
		return utils;
	}
	
	/**
	 * Metodo per impostare l'oggetto della classe {@link FilterUtils} per la scelta del filtro
	 * 
	 * @param utils Oggetto di {@link FilterUtils}
	 */
	
	public void setUtils(FilterUtils<Tweet> utils) {
		this.utils = utils;
	}
	
	/**
	 * Metodo che consente di filtrare i dati in base al filtro di distanza inserito
	 * 
	 * @param json Oggeto della classe JSONObject che contiene il filtro di distanza
	 * @param city Citta' da cui si vuole considerare la distanza 
	 * @return Dataset filtrato relativo al filtro richiesto
	 * @throws FilterNotFoundException Eccezione lanciata se si inserisce un filtro non disponibile
	 * @throws CityNotFoundException Eccezione lanciata se si inserisce una citta' non disponibile
	 * @throws NegativeValueException Eccezione lanciata se si inserisce un valore negativo nel filtro di distanza
	 * @throws IllegalIntervalException Eccezione lanciata se si inserisce nel filtro di distanza un intervallo in cui il primo valore e' maggiore del secondo
	 * @throws GenericFilterException Eccezione lanciata se si verifica un errore generico nella scelta del filtro
	 */
		
	public ArrayList<Tweet> parseFilter(JSONObject json, String city)
			throws FilterNotFoundException, CityNotFoundException, NegativeValueException,
			IllegalIntervalException, GenericFilterException {
		Map<String, ArrayList<Tweet>> filters = new HashMap<String, ArrayList<Tweet>>();
		filters.put("$lt", null);
		filters.put("$gt", null);
		filters.put("$gte", null);
		filters.put("$lte", null);
		filters.put("$bt", null);
		String name = json.keys().next();
		if(!filters.containsKey(name))
			throw new FilterNotFoundException("Il filtro inserito non esiste");
		if(json.get(name) instanceof Number) {
			double rif = json.getDouble(name);
   			filters.put("$lt", chooseFilter(name, city, rif));
   			filters.put("$gt", chooseFilter(name, city, rif));
   			filters.put("$gte", chooseFilter(name, city, rif));
   			filters.put("$lte", chooseFilter(name, city, rif));
   			return filters.get(name);
		}
		else if(json.get(name) instanceof JSONArray) {
			double min = json.getJSONArray(name).getDouble(0);
			double max = json.getJSONArray(name).getFloat(1);
			filters.put("$bt", chooseFilter(name, city, min, max));
			return filters.get(name);
		}
		throw new GenericFilterException("Errore nella scelta del valore del filtro");	
	}
	
	@Override
	public ArrayList<Tweet> chooseFilter(String operator, String city, Double... value) 
			throws CityNotFoundException, NegativeValueException, IllegalIntervalException, GenericFilterException {
		return (ArrayList<Tweet>) utils.select(this.getSample(), operator, city,  value);
	}
}
