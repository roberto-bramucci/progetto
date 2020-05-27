package it.univpm.progettoOOP.model;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

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
	
	public double getDistance(Tweet t) {
		   double rifx = 13.516584634780884;
	       double rify = 43.616962794315526;
	       //Point2D.Double rifAnc = new Point2D.Double(rifx, rify);
	       double R = 6372.795477598;
           double lat = t.getGeo().y;
           double lon = t.getGeo().x;
           double dist =  R * Math.acos(Math.sin(lat) * Math.sin(rify) + Math.cos(lat) * Math.cos(rify) * Math.cos(lon-rifx));
           return dist;
	}
}
