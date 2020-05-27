package it.univpm.progettoOOP.util.filter;



public class FilterDistance {
	protected double distance;
	
	public FilterDistance(Double distance) {
		this.distance = distance;
	}

	/**
	 * @return the distance
	 */
	public Double getDistance() {
		return distance;
	}

	/**
	 * @param point the point to set
	 */
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	
}
