package it.univpm.progettoOOP.service;
import it.univpm.progettoOOP.exceptions.GenericServiceException;
import it.univpm.progettoOOP.model.Tweet;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.net.URL;
/**
 * Classe per il collegamento con la API di Twitter e il caricamento dei dati.
 * Contiene l'implementazione dei metodi dichiarati in {@link TweetService} 
 * @author HP
 *
 */
@Service
public class TweetServiceImpl implements TweetService {
	/**
	 * Collection per contenere i dati ottenuti dalla chiamata alla API di Twitter
	 */
	private static Collection<Tweet> tweets = new ArrayList<>();
	
	/**
	 * Costruttore che ottiene i dati e li salva nella Collection
	 * @throws GenericServiceException
	 */
	public TweetServiceImpl() throws GenericServiceException {
		String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/labs/2/tweets?ids=1264994235180253190,1265011663150989314,1269715922270531586,1265019461968343042,1269673618243563520,1269697614120914952,1269700437902589956,1265023704679043072,1269703231560658945,1265023477146357760,1265009995063734272,1265018699704123397,1264978710358155265,1264987144499556352,1264613421569490950,1264967817977307139,1264973453490151424,1262800745730117632,1264827517854191616,1264819444724961280,1265028908723798017,1265023215971241984,1265052257596264448,1265052710027624450,1265167808423505921,1269676942766288897,1265153348698689536,1265189493876781056,1265188848621019136,1264958770758782977,1264850093624233984,1264781761466249216&tweet.fields=geo";
		try {
			URLConnection connection = new URL(url).openConnection();
			InputStream input = connection.getInputStream();
			
			JsonFactory factory = new JsonFactory();
			JsonParser parser = factory.createParser(input);
			for(int i = 0; i < 32; i++){
				Tweet tweet = deserialize(parser);
				tweets.add(tweet);
			}
		}
		catch(UnknownHostException uhEx) {
			uhEx.printStackTrace();
			System.out.println("Errore nell'indirizzo url fornito");
			System.exit(1);
		}
		catch(JsonParseException jsonEx) {
			jsonEx.printStackTrace();
			System.out.println("Errore nella deserializzazione del JSON");
			System.exit(1);
		}
		catch(IOException io) {
			io.printStackTrace();
			System.out.println("Errore nel caricamento dei dati");
			System.exit(1);
		}
	}
	/**
	 * Metodo per la deserializzazione dei dati e il salvataggio dei campi richiesti
	 * @param parser Oggetto di tipo JsonParser
	 * @return Oggetto {@link Tweet} ottenuto dalla deserializzazione
	 * @throws GenericServiceException
	 */
	public Tweet deserialize(JsonParser parser) throws GenericServiceException{
		Tweet tweet = new Tweet();
		try {
			while(!parser.isClosed()) {
				JsonToken tok = parser.nextToken();
				if(JsonToken.FIELD_NAME.equals(tok)){
					String fieldName = parser.getCurrentName();
					if("coordinates".equals(fieldName)){
						while(!parser.isExpectedStartArrayToken())
							tok = parser.nextToken();
						if(parser.isExpectedStartArrayToken()) {
							tok = parser.nextValue();
							double x = parser.getValueAsDouble();
							tok = parser.nextValue();
							double y = parser.getValueAsDouble();
							Point2D.Double geo = new Double(x, y);
							tweet.setGeo(geo);
						}
					}
					if("id".equals(fieldName)) {
						tok = parser.nextValue();
						tweet.setId(parser.getValueAsString());
					}
					if("text".equals(fieldName)) {
						tok = parser.nextValue();
						tweet.setText(parser.getValueAsString());
						tok = parser.nextToken();
						if(JsonToken.END_OBJECT.equals(tok)) {
							return tweet;
						}
					}
				}
			}
		}
		catch(JsonParseException jsonEx) {
			jsonEx.printStackTrace();
			System.out.println("Errore nella deserializzazione del JSON");
			System.exit(1);
		}
		catch(IOException ioEx) {
			ioEx.printStackTrace();
			System.out.println("Errore nel caricamento dei dati");
			System.exit(1);
		}
		throw new GenericServiceException("Errore nella restituzione dei dati");
	}
	
	@Override
	public Collection<Tweet> getData(){
		return tweets;
	}
	
	@Override
	public JsonSchema getMetadata() throws GenericServiceException{
		try {
			ObjectMapper obj = new ObjectMapper();
			JsonSchemaGenerator gen = new JsonSchemaGenerator(obj);
			JsonSchema schema = gen.generateSchema(Tweet.class);
			return schema;
		}
		catch(JsonMappingException e) {
			e.printStackTrace();
			System.out.println("Errore nella mappatura dei dati");
			System.exit(1);
		}
		throw new GenericServiceException("Errore nella restituzione dei metadati");
	}
}
