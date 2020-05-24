package it.univpm.progettoOOP.service;

import it.univpm.progettoOOP.model.Tweet;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.Collection;
import java.util.HashMap;
import java.net.URL;

@Service
public class TweetServiceImpl implements TweetService {

	private static Map<Integer, Tweet> tweets = new HashMap<>();
	private final static AtomicLong count = new AtomicLong();
	static {
		String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=terremoto&count=2";
		try {
			URLConnection connection = new URL(url).openConnection();
			InputStream input = connection.getInputStream();
			
			String data = "";
			String line = "";
			try {
				InputStreamReader in = new InputStreamReader(input);
				BufferedReader buf = new BufferedReader(in);
				
				while((line = buf.readLine()) != null) {
					data += line;
					System.out.println(line);
					ObjectMapper obj = new ObjectMapper();
					String json = obj.writeValueAsString(line);
					Tweet t = obj.readValue(json, Tweet.class);
					int key = (int)count.incrementAndGet();
					tweets.put(key, t);
				}
				System.out.println(tweets);
			}
			finally {
				input.close();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Collection<Tweet> getData(){
		return tweets.values();
	}
	
	public String getMetadata() {
		try {
			ObjectMapper obj = new ObjectMapper();
			JsonSchemaGenerator gen = new JsonSchemaGenerator(obj);
			JsonSchema schema = gen.generateSchema(Tweet.class);
			return obj.writeValueAsString(schema);	
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		return null;
	}
}
