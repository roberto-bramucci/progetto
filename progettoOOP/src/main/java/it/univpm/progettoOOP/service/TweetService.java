package it.univpm.progettoOOP.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.module.jsonSchema.JsonSchema;

import it.univpm.progettoOOP.exceptions.GenericServiceException;
import it.univpm.progettoOOP.model.Tweet;
/**
 * Interfaccia per la dichiarazione dei metodi che consentono di ottenere dati e metadati relativi al tipo {@link Tweet}
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * @version 1.0
 */
@Service
public interface TweetService {
	/**
	 * Metodo per ottenere un dataset di {@link Tweet}
	 * @return Dataset di {@link Tweet}
	 * @throws GenericServiceException Eccezione lanciata se si verifica un errore nella deserializzazione dei dati caricati
	 */
	public Collection<Tweet> getData() throws GenericServiceException;
	/**
	 * Metodo per ottenere i metadati di {@link Tweet}
	 * @return Metadati di {@link Tweet}
	 * @throws GenericServiceException Eccezione lanciata se si verifica un errore nella deserializzazione dei dati caricati
	 */
	public JsonSchema getMetadata() throws GenericServiceException;
}
