package it.univpm.progettoOOP.service;

import it.univpm.progettoOOP.model.Tweet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.net.URL;

public class TweetServiceImpl implements TweetService{
	Map<Integer, Tweet> tweets = new HashMap<>();
	 AtomicLong count = new AtomicLong();
	
	static {
		String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=terremoto&count=100";
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
				}
			}
			finally {
				input.close();
			}
		
			try {
				JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
