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
}
