package it.univpm.progettoOOP.util.filter;

import java.util.Collection;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;
import it.univpm.progettoOOP.exceptions.FilterNotFoundException;
import it.univpm.progettoOOP.exceptions.GenericFilterException;
import it.univpm.progettoOOP.exceptions.IllegalIntervalException;
import it.univpm.progettoOOP.exceptions.NegativeValueException;

public interface Filter<E,T> {
	abstract Collection<E> chooseFilter(String operator, String city, Double... value)  
			throws CityNotFoundException, FilterNotFoundException, NegativeValueException, GenericFilterException, IllegalIntervalException;
}
