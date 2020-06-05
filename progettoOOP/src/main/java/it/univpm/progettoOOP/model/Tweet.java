package it.univpm.progettoOOP.model;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;

public class Tweet {
	private String id;
	private String text;
	private Point2D.Double geo;
	
	public Tweet() {}
	
	public Tweet(String id, String text, Double geo) {
		this.id = id;
		this.text = text;
		this.geo = geo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Point2D.Double getGeo() {
		return geo;
	}

	public void setGeo(Point2D.Double geo) {
		this.geo = geo;
	}
	
	public double chooseCity(String city) throws CityNotFoundException{
		if(city.equals("AN"))
			return getDistanceAncona();
		else if(city.equals("RM"))
			return getDistanceRoma();
		else if(city.equals("MI"))
			return getDistanceMilano();
		else if(city.equals("NP"))
			return getDistanceNapoli();
		else
			throw new CityNotFoundException("Questa città non è disponibile");
	}
	
	public double getDistanceAncona() {
		double rifx = 13.516584634780884 * Math.PI/180;
		double rify = 43.616962794315526 * Math.PI/180;
		return calculateDistance(rifx, rify);

	}
	
	public double getDistanceRoma() {
		double rifx = 12.492329478263855 * Math.PI/180;
		double rify = 41.890250028939036 * Math.PI/180;
		return calculateDistance(rifx, rify);
	}
    
	public double getDistanceMilano() {
		double rifx = 9.189870357513428 * Math.PI/180;
		double rify = 45.46421670802236 * Math.PI/180;
		return calculateDistance(rifx, rify);
	}
	
	public double getDistanceNapoli() {
		double rifx = 14.248559474945068 * Math.PI/180;
		double rify = 40.83589597467399 * Math.PI/180;
		return calculateDistance(rifx, rify);
	}
	
	public double calculateDistance(double rifx, double rify) {
		double R = 6372.795477598;
		double lat = getGeo().y * Math.PI/180;
		double lon = getGeo().x * Math.PI/180;
		double dist =  R * Math.acos(Math.sin(lat) * Math.sin(rify) + Math.cos(lat) * Math.cos(rify) * Math.cos(lon-rifx));
		return dist;
	}
}
