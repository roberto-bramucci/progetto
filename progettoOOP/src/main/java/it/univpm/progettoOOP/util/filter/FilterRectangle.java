package it.univpm.progettoOOP.util.filter;


import java.awt.geom.Rectangle2D;


public class FilterRectangle {
	
	protected Rectangle2D.Double rectangle;
	
	//costruttore
	public FilterRectangle(Rectangle2D.Double rectangle) {
		this.rectangle = rectangle;
	}

	public Rectangle2D.Double getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle2D.Double rectangle) {
		this.rectangle = rectangle;
	}	
	
}
