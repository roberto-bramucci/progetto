package it.univpm.progettoOOP;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;
import it.univpm.progettoOOP.exceptions.FilterNotFoundException;
import it.univpm.progettoOOP.exceptions.GenericFilterException;
import it.univpm.progettoOOP.exceptions.IllegalIdException;
import it.univpm.progettoOOP.exceptions.IllegalIntervalException;
import it.univpm.progettoOOP.exceptions.NegativeValueException;
import it.univpm.progettoOOP.model.Tweet;
import it.univpm.progettoOOP.util.filter.FilterIdTextImpl;
import it.univpm.progettoOOP.util.filter.FilterUtils;

public class TestExceptions<T> {
	
	private Tweet t = new Tweet();
	private FilterIdTextImpl fiti = new FilterIdTextImpl();
	
	
	
	@Test
	public void cityNotFoundExceptionSucceeds() {
		Exception exception = assertThrows(CityNotFoundException.class, () -> { t.chooseCity("TO");});
		
		String expectedMessage = "Questa città non è disponibile";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void illegalIdExceptionSucceeds() {
		Exception exception = assertThrows(IllegalIdException.class, () -> { Collection<Tweet> sample = new ArrayList<Tweet>();
		fiti.getTweetFromId(sample, "126499423518025319");});
		
		String expectedMessage = "Questo id non esiste";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void filterNotFoundExceptionSucceeds() {
		Exception exception = assertThrows(FilterNotFoundException.class, () -> { 
		Point2D.Double p = new Point2D.Double(7.6777,45.0702);
		Tweet value = new Tweet("1264994235180253190","TRICOLOR!!!\n\nThe Italian Frecce Tricolore (the acrobatic Italian Air Force Squad) flew over Turin today.\n\nThey started from #Codogno (the town which the symbol of the fight against #covid_19) and will fly over many… https://t.co/i99LXh2k8K",p);
		Double th = 10.0;
		FilterUtils.check(value, "$lts", "AN", th);});
		String expectedMessage = "Il filtro inserito non esiste";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void illegalIntervalExceptionSucceeds() {
		Exception exception = assertThrows(IllegalIntervalException.class, () -> { 
		Point2D.Double p = new Point2D.Double(7.6777,45.0702);
		Tweet value = new Tweet("1264994235180253190","TRICOLOR!!!\n\nThe Italian Frecce Tricolore (the acrobatic Italian Air Force Squad) flew over Turin today.\n\nThey started from #Codogno (the town which the symbol of the fight against #covid_19) and will fly over many… https://t.co/i99LXh2k8K",p);
		//Double th = 10.0;
		FilterUtils.check(value, "$bt", "AN", 10.0, 5.0);});
		String expectedMessage = "Il primo valore deve essere maggiore del secondo";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void negativeValueExceptionSucceeds() {
		Exception exception = assertThrows(NegativeValueException.class, () -> { 
		Point2D.Double p = new Point2D.Double(7.6777,45.0702);
		Tweet value = new Tweet("1264994235180253190","TRICOLOR!!!\n\nThe Italian Frecce Tricolore (the acrobatic Italian Air Force Squad) flew over Turin today.\n\nThey started from #Codogno (the town which the symbol of the fight against #covid_19) and will fly over many… https://t.co/i99LXh2k8K",p);
		Double th = -10.0;
		FilterUtils.check(value, "$lt", "AN", th);});
		String expectedMessage = "Il valore inserito è negativo";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void genericFilterExceptionSucceeds() {
		Exception exception = assertThrows(GenericFilterException.class, () -> { 
		Tweet value = null;
		Double th = null ;
		FilterUtils.check(value, "$lt", "AN",th );});
		String expectedMessage = "Errore nella scelta del filtro";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}

}

