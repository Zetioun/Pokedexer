package controller;

import java.io.Serializable;

public class SaveFile implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String startLatitude;
	public String startLongitude;
	public String moveLatitude;
	public String moveLongitude;
	public String stepLatitude;
	public String stepLongitude;
	public String regexPokemonName;
	public String regexLatitude;
	public String regexLongitude;
	public String URL;


	public SaveFile(String startLatitude, String startLongitude, String moveLatitude, String moveLongitude,
			String stepLatitude, String stepLongitude, String regexPokemonName, String regexLatitude, String URL, String regexLongitude) {
		this.startLatitude = startLatitude;
		this.startLongitude = startLongitude;
		this.moveLatitude = moveLatitude;
		this.moveLongitude = moveLongitude;
		this.stepLatitude = stepLatitude;
		this.stepLongitude = stepLongitude;
		this.regexPokemonName = regexPokemonName;
		this.regexLatitude = regexLatitude;
		this.regexLongitude = regexLongitude;
		this.URL = URL;
	}



	
}
