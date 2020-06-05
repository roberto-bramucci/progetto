package it.univpm.progettoOOP.util.stats;

public class StatsGeo {
	private final String field = "geo";
	private double avgDist;
	private double maxDist;
	private double minDist;
	private double sumDist;
	private double varDist;
	private double devStdDist;
	private int numTweetAnalyzed;
	
	public StatsGeo() {
		this.avgDist = 0;
		this.maxDist = 0;
		this.minDist = 0;
		this.sumDist = 0;
		this.varDist = 0;
		this.devStdDist = 0;
	}
	
	public String getField() {
		return field;
	}
	
	public double getAvgDist() {
		return avgDist;
	}
	
	public void setAvgDist(double avgDist) {
		this.avgDist = avgDist;
	}
	
	public double getMaxDist() {
		return maxDist;
	}
	
	public void setMaxDist(double maxDist) {
		this.maxDist = maxDist;
	}
	
	public double getMinDist() {
		return minDist;
	}
	
	public void setMinDist(double minDist) {
		this.minDist = minDist;
	}
	
	public double getSumDist() {
		return sumDist;
	}
	
	public void setSumDist(double sumDist) {
		this.sumDist = sumDist;
	}
	
	public double getVarDist() {
		return varDist;
	}
	
	public void setVarDist(double varDist) {
		this.varDist = varDist;
	}
	
	public double getDevStdDist() {
		return devStdDist;
	}
	
	public void setDevStdDist(double devStdDist) {
		this.devStdDist = devStdDist;
	}
	
	public int getNumTweetAnalyzed() {
		return numTweetAnalyzed;
	}

	public void setNumTweetAnalyzed(int numTweetAnalyzed) {
		this.numTweetAnalyzed = numTweetAnalyzed;
	}
}
