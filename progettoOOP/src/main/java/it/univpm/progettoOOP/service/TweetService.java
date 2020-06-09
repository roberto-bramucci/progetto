package it.univpm.progettoOOP.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.module.jsonSchema.JsonSchema;

import it.univpm.progettoOOP.exceptions.GenericServiceException;
import it.univpm.progettoOOP.exceptions.IllegalIdException;
import it.univpm.progettoOOP.model.Tweet;
import it.univpm.progettoOOP.util.filter.Filter;
/**
 * Interfaccia per la dichiarazione dei metodi che consentono di ottenere dati e metadati relativi al tipo Tweet
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 */
@Service
public interface TweetService {
	/**
	 * Metodo per ottenere un dataset di Tweet
	 * @return Dataset di {@link Tweet}
	 * @throws GenericServiceException
	 */
	public Collection<Tweet> getData() throws GenericServiceException;
	/**
	 * Metodo per ottenere i metadati di Tweet
	 * @return Metadati di {@link Tweet}
	 * @throws GenericServiceException
	 */
	public JsonSchema getMetadata() throws GenericServiceException;
}
