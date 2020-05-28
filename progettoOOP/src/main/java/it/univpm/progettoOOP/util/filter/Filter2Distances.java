package it.univpm.progettoOOP.util.filter;

public class Filter2Distances {
	protected double distance1;
	protected double distance2;
	
	public Filter2Distances(Double distance1, Double distance2) {
		this.distance1 = distance1;
		this.distance2 = distance2;
		if (distance1>distance2) {
			throw new IllegalArgumentException("distance1 must be lower than distance2");
		}
	}

	/**
	 * @return the distance1
	 */
	public double getDistance1() {
		return distance1;
	}

	/**
	 * @param distance1 the distance1 to set
	 */
	public void setDistance1(double distance1) {
		this.distance1 = distance1;
	}

	/**
	 * @return the distance2
	 */
	public double getDistance2() {
		return distance2;
	}

	/**
	 * @param distance2 the distance2 to set
	 */
	public void setDistance2(double distance2) {
		this.distance2 = distance2;
	}
	
	
	
	
}
