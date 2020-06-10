package it.univpm.progettoOOP.model;

import java.util.ArrayList;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;
import it.univpm.progettoOOP.exceptions.FilterNotFoundException;
import it.univpm.progettoOOP.exceptions.GenericFilterException;
import it.univpm.progettoOOP.exceptions.IllegalIntervalException;
import it.univpm.progettoOOP.exceptions.NegativeValueException;
import it.univpm.progettoOOP.util.filter.Filter;
import it.univpm.progettoOOP.util.filter.FilterUtils;

/**
 * Classe per la modellazione dei filtri geo su dati di tipo @see Tweet
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
	 * Oggetto della classe FilterUtils per la scelta del filtro
	 */
	private FilterUtils<Tweet> utils;
	
	/**
	 * Costruttore con parametri
	 * 
	 * @param sample Dataset da filtrare
	 * @param utils Oggetto della classe FilterUtils per la scelta del filtro
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
	 * Metodo per ottenere l'oggetto della classe FilterUtils per la scelta del filtro
	 * 
	 * @return Oggetto di FilterUtils
	 */
	
	public FilterUtils<Tweet> getUtils() {
		return utils;
	}
	
	/**
	 * Metodo per impostare l'oggetto della classe FilterUtils per la scelta del filtro
	 * 
	 * @param utils Oggetto di FilterUtils
	 */
	
	public void setUtils(FilterUtils<Tweet> utils) {
		this.utils = utils;
	}
	
	/**
	 * Metodo per la scelta del filtro geo da applicare al dataset
	 * 
	 * @param operator Operatore del filtro
	 * @param city Città da cui si vuole considerare la distanza 
	 * @param value Valori relativi al filtro
	 * @return
	 * @throws {@link FilterNotFoundException}
	 * @throws {@link CityNotFoundException}
	 * @throws {@link NegativeValueException}
	 * @throws {@link IllegalIntervalException}
	 * @throws {@link GenericFilterException}
	 * 
	 */
	
	@Override
	public ArrayList<Tweet> chooseFilter(String operator, String city, Double... value) 
			throws FilterNotFoundException, CityNotFoundException, NegativeValueException, IllegalIntervalException, GenericFilterException {
		return (ArrayList<Tweet>) utils.select(this.getSample(), operator, city,  value);
	}
}
