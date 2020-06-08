package it.univpm.progettoOOP;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.web.client.RestTemplate;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;
import it.univpm.progettoOOP.model.Tweet;
import it.univpm.progettoOOP.util.stats.TweetStatsGeo;
import it.univpm.progettoOOP.util.stats.TweetStatsGeoImpl;
import it.univpm.progettoOOP.util.stats.TweetStatsTextImpl;

/**
 * Rappresenta la classe che esegue i test sulle chiamate al controller
 * @author Roberto Bramucci, Stefano Bonci
 *
 */
class ProgettoOopApplicationTests {

	
	private Tweet t = new Tweet();

	/**
	 * il test verifica se la chiamata del controller getMeta avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
	public void testGetMetadataSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/metadata";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	
	/**
	 * il test verifica se la chiamata del controller getData avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
	public void testGetDataSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/data";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<Collection> result = restTemplate.getForEntity(uri, Collection.class);
	     
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	
	/**
	 * il test verifica se la chiamata del controller getDataWithFilter avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
    public void testGetDataWithCitySuccess() throws URISyntaxException 
    {
        final String baseUrl = "http://localhost:"+8080+"/data/AN";
        URI uri = new URI(baseUrl);
        
       
        String filter = new String("{\"$gt\":100}");
       
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
 
        HttpEntity<String> request = new HttpEntity<String>(filter, headers);
        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<Collection> result = restTemplate.postForEntity(uri, request, Collection.class);
         
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
    }
	
	/**
	 * il test verifica se la chiamata del controller getTweetId avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
	public void testGetTweetFromIdSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/data/id/1264994235180253190";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<Tweet> result = restTemplate.getForEntity(uri, Tweet.class);
	     
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	
	/**
	 * il test verifica se la chiamata del controller getTweetText avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
	public void testGetTweetsFromTextSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/data/text/Tricolore";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<Collection> result = restTemplate.getForEntity(uri, Collection.class);
	     
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	
	/**
	 * il test verifica se la chiamata del controller getStatsTextNoFilter avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
	public void testGetStatsTextNoFilterSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/data/stats/text";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<TweetStatsTextImpl> result = restTemplate.getForEntity(uri, TweetStatsTextImpl.class);
	     
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	
	/**
	 * il test verifica se la chiamata del controller getStatsText avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
	public void testGetStatsWithTextSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/data/stats/text/Tricolore";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<TweetStatsTextImpl> result = restTemplate.getForEntity(uri, TweetStatsTextImpl.class);
	     
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	
	/**
	 * il test verifica se la chiamata del controller getStatsTextWithFilter avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
    public void testGetStatsGeoSuccess() throws URISyntaxException 
    {
        final String baseUrl = "http://localhost:"+8080+"/data/stats/geo/AN";
        URI uri = new URI(baseUrl);
        
       
        String filter = new String("{\"$gt\":100}");
       
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
 
        HttpEntity<String> request = new HttpEntity<String>(filter, headers);
        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<TweetStatsGeoImpl> result = restTemplate.postForEntity(uri, request, TweetStatsGeoImpl.class);
         
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
    }
	
	/**
	 * il test verifica se la chiamata del controller getStatsGeoWithFilter avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
    public void testGetStatsWithTextAndCitySuccess() throws URISyntaxException 
    {
        final String baseUrl = "http://localhost:"+8080+"/data/stats/text/Tricolore/AN";
        URI uri = new URI(baseUrl);
        
       
        String filter = new String("{\"$gt\":100}");
       
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
 
        HttpEntity<String> request = new HttpEntity<String>(filter, headers);
        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<TweetStatsTextImpl> result = restTemplate.postForEntity(uri, request, TweetStatsTextImpl.class);
         
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
    }
	
}
