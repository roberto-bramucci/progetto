package it.univpm.progettoOOP;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.web.client.RestTemplate;

import it.univpm.progettoOOP.model.Tweet;
import it.univpm.progettoOOP.util.stats.TweetStatsGeoImpl;
import it.univpm.progettoOOP.util.stats.TweetStatsTextImpl;

/**
 * Classe che esegue i test sulle chiamate del TweetContoller
 * @author Roberto Bramucci
 * @author Stefano Bonci
 *
 */
class ProgettoOopApplicationTests {
	
	@BeforeEach
	void setUp() throws Exception {		
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Test che verifica se la chiamata del controller getMeta avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
	public void testGetMetadataSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/metadata";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	/**
	 * Test che verifica se la chiamata del controller getData avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
	public void testGetDataSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/data";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<Collection> result = restTemplate.getForEntity(uri, Collection.class);
	    
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	/**
	 * Test che verifica se la chiamata del controller getDataWithFilter avviene con successo
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
         
        assertEquals(200, result.getStatusCodeValue());
    }
	
	/**
	 * Test che verifica se la chiamata del controller getTweetId avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
	public void testGetTweetFromIdSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/data/id/1264994235180253190";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<Tweet> result = restTemplate.getForEntity(uri, Tweet.class);
	    
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	/**
	 * Test che verifica se la chiamata del controller getTweetText avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
	public void testGetTweetsFromTextSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/data/text/Tricolore";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<Collection> result = restTemplate.getForEntity(uri, Collection.class);
	    
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	
	/**
	 * Test che verifica se la chiamata del controller getStatsTextNoFilter avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
	public void testGetStatsTextNoFilterSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/data/stats/text";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<TweetStatsTextImpl> result = restTemplate.getForEntity(uri, TweetStatsTextImpl.class);
	     
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	
	/**
	 * Test che verifica se la chiamata del controller getStatsText avviene con successo
	 * @throws URISyntaxException
	 */
	@Test
	public void testGetStatsWithTextSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/data/stats/text/Tricolore";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<TweetStatsTextImpl> result = restTemplate.getForEntity(uri, TweetStatsTextImpl.class);
	   
	    assertEquals(200, result.getStatusCodeValue());
	  
	}
	
	/**
	 * Test che verifica se la chiamata del controller getStatsTextWithFilter avviene con successo
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
        
        assertEquals(200, result.getStatusCodeValue());
    }
	
	/**
	 * Test che verifica se la chiamata del controller getStatsGeoWithFilter avviene con successo
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
        
        assertEquals(200, result.getStatusCodeValue());
    }
	
}
