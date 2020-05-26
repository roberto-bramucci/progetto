package it.univpm.progettoOOP.util.filter;


import java.awt.geom.Rectangle2D;

import it.univpm.progettoOOP.model.Tweet;

public class FilterRectangleAncona extends FilterRectangle implements Filter {

	public FilterRectangleAncona(Rectangle2D.Double rectangle) {
		super(rectangle = new Rectangle2D.Double(13.47198486328125,43.56646172588961,0.0817108154,0.0629042155));
	}
	
	public Rectangle2D.Double getRectangle() {
		return rectangle;
	}



		
	
	@Override
	public boolean filter(Tweet tweet) {
		if (FilterRectangleAncona.getRectangle().contains(tweet.getGeo()))
			return true;
		else 
			return false;
	
	}

}
