package it.univpm.progettoOOP.util.filter;

import java.util.Collection;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;
import it.univpm.progettoOOP.exceptions.FilterNotFoundException;
import it.univpm.progettoOOP.exceptions.GenericFilterException;
import it.univpm.progettoOOP.exceptions.IllegalIntervalException;
import it.univpm.progettoOOP.exceptions.NegativeValueException;
/**
 * Interfaccia per la dichiarazione del metodo utile per ottenere il filtro di distanza da applicare
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * @version 1.0
 * @param <E> Tipo dell'oggetto da filtrare
 */
public interface Filter<E>{
	/**
	 * Metodo per la scelta del filtro di distanza da applicare al dataset
	 * 
	 * @param operator Operatore del filtro
	 * @param city Citta' da cui si vuole considerare la distanza 
	 * @param value Valori relativi al filtro
	 * @return Dataset filtrato relativo al filtro richiesto
	 * @throws FilterNotFoundException Eccezione lanciata se si inserisce un filtro non disponibile
	 * @throws CityNotFoundException Eccezione lanciata se si inserisce una citta' non disponibile
	 * @throws NegativeValueException Eccezione lanciata se si inserisce un valore negativo nel filtro di distanza
	 * @throws IllegalIntervalException Eccezione lanciata se si inserisce nel filtro di distanza un intervallo in cui il primo valore e' maggiore del secondo
	 * @throws GenericFilterException Eccezione lanciata se si verifica un errore generico nella scelta del filtro
	 * 
	 */
	abstract Collection<E> chooseFilter(String operator, String city, Double... value)  
			throws CityNotFoundException, FilterNotFoundException, NegativeValueException, GenericFilterException, IllegalIntervalException;
}
