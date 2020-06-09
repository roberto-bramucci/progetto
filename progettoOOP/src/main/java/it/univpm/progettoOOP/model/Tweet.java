package it.univpm.progettoOOP.model;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import it.univpm.progettoOOP.exceptions.CityNotFoundException;

/**
 * Classe per la modellazione di un dato di tipo Tweet
 * 
 * @author Roberto Bramucci
 * @author Stefano Bonci
 * 
 * @version 1.0
 *
 */

public class Tweet {
	/**
	 * id del Tweet
	 */
	private String id;
	/**
	 * Testo del Tweet
	 */
	private String text;
	/**
	 * Coordinate del Tweet
	 */
	private Point2D.Double geo;
	
	/**
	 * Costruttore di default
	 */
	public Tweet() {}
	
	/**
	 * Costruttore con parametri
	 * 
	 * @param id id del Tweet
	 * @param text Testo del Tweet
	 * @param geo Coordinate del Tweet
	 */
	
	public Tweet(String id, String text, Double geo) {
		this.id = id;
		this.text = text;
		this.geo = geo;
	}
	
	/**
	 * Metodo per ottenere l'id del Tweet
	 * @return id del Tweet
	 */

	public String getId() {
		return id;
	}
	
	/**
	 * Metodo per impostare l'id del Tweet
	 * @param id id del Tweet
	 */

	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Metodo per ottenere il testo del Tweet
	 * @return Testo del Tweet
	 */

	public String getText() {
		return text;
	}
	
	/**
	 * Metodo per impostare il testo del Tweet
	 * @param text Testo del Tweet
	 */

	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Metodo per ottenere le coordinate del Tweet
	 * @return Coordinate del Tweet
	 */

	public Point2D.Double getGeo() {
		return geo;
	}
	
	/**
	 * Metodo per impostare le coordinate del Tweet
	 * @param geo Coordinate del Tweet
	 */

	public void setGeo(Point2D.Double geo) {
		this.geo = geo;
	}
	
	/**
	 * Metodo che determina la città da considerare per filtri e statistiche
	 * 
	 * @param city Città da cui si vuole considerare la distanza 
	 * @return La distanza del Tweet dalla città specificata
	 * @throws CityNotFoundException
	 */
	
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
	
	/**
	 * Metodo per ottenere la distanza in chilometri del Tweet da Ancona
	 * 
	 * @return Distanza in chilometri del Tweet da Ancona
	 */
	
	public double getDistanceAncona() {
		double rifx = 13.516584634780884 * Math.PI/180;
		double rify = 43.616962794315526 * Math.PI/180;
		return calculateDistance(rifx, rify);

	}
	
	/**
	 * Metodo per ottenere la distanza in chilometri del Tweet da Roma
	 * 
	 * @return Distanza in chilometri del Tweet da Roma
	 */
	
	public double getDistanceRoma() {
		double rifx = 12.492329478263855 * Math.PI/180;
		double rify = 41.890250028939036 * Math.PI/180;
		return calculateDistance(rifx, rify);
	}
	
	/**
	 * Metodo per ottenere la distanza in chilometri del Tweet da Milano
	 * 
	 * @return Distanza in chilometri del Tweet da Milano
	 */
    
	public double getDistanceMilano() {
		double rifx = 9.189870357513428 * Math.PI/180;
		double rify = 45.46421670802236 * Math.PI/180;
		return calculateDistance(rifx, rify);
	}
	
	/**
	 * Metodo per ottenere la distanza in chilometri del Tweet da Napoli
	 * 
	 * @return Distanza in chilometri del Tweet da Napoli
	 */
	
	public double getDistanceNapoli() {
		double rifx = 14.248559474945068 * Math.PI/180;
		double rify = 40.83589597467399 * Math.PI/180;
		return calculateDistance(rifx, rify);
	}
	
	/**
	 * Metodo che calcola la distanza in chilometri dalla posizione specificata in longitudine e latidine
	 * 
	 * @param rifx Longitudine 
	 * @param rify Latitudine
	 * @return Distanza in chilometri dalla posizione specificata
	 */
	
	public double calculateDistance(double rifx, double rify) {
		double R = 6372.795477598;
		double lat = getGeo().y * Math.PI/180;
		double lon = getGeo().x * Math.PI/180;
		double dist =  R * Math.acos(Math.sin(lat) * Math.sin(rify) + Math.cos(lat) * Math.cos(rify) * Math.cos(lon-rifx));
		return dist;
	}
}
