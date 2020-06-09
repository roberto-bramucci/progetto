package it.univpm.progettoOOP.util.filter;

import java.util.Collection;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;
import it.univpm.progettoOOP.exceptions.FilterNotFoundException;
import it.univpm.progettoOOP.exceptions.GenericFilterException;
import it.univpm.progettoOOP.exceptions.IllegalIntervalException;
import it.univpm.progettoOOP.exceptions.NegativeValueException;
/**
 * Interfaccia per la dichiarazione del metodo utile per ottenere il filtro geo da applicare
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 * @param <E> Tipo dell'oggetto da filtrare
 */
public interface Filter<E>{
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
	abstract Collection<E> chooseFilter(String operator, String city, Double... value)  
			throws CityNotFoundException, FilterNotFoundException, NegativeValueException, GenericFilterException, IllegalIntervalException;
}
