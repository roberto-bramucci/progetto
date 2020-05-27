package it.univpm.progettoOOP.util.filter;

import java.awt.geom.Point2D;

public class FilterDistance {
	private Point2D.Double point = new Point2D.Double(13.516584634780884, 43.616962794315526);
	
	public FilterDistance(Point2D.Double point) {
		this.point = point;
	}

	/**
	 * @return the point
	 */
	public Point2D.Double getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint(Point2D.Double point) {
		this.point = point;
	}
	
	
}
