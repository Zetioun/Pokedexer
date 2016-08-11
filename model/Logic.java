package model;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import http.URLReader;
import pokemon.Coordinates;
import pokemon.Pokemon;
import pokemon.PokemonFactory;
import pokemon.StringToPokeObj;

public class Logic {

	String currentString;
	double VAR1, VAR2, VAR3, VAR4;
	int stepsLatitude, stepsLongitude;

	public Logic(String URL, String var1, String var2, String var3, String var4, String pokeReg, String latReg,
			String lonReg, String stepsLat, String stepsLon) throws Exception {
		this.VAR1 = Double.parseDouble(var1);
		this.VAR2 = Double.parseDouble(var2);
		this.VAR3 = Double.parseDouble(var3);
		this.VAR4 = Double.parseDouble(var4);
		this.stepsLatitude = Integer.parseInt(stepsLat);
		this.stepsLongitude = Integer.parseInt(stepsLon);
		

		
		System.out.println(VAR1 + " " + VAR2 + " " + VAR3 + " " + VAR4 + "-Logic linj 24");

		for (int i = 0; i < stepsLatitude; i++) {
			for (int j = 0; j < stepsLongitude; j++) {
				
				currentString = stringifyURL(URL, VAR1, VAR2, VAR1+(stepsLatitude*i), VAR2*(stepsLongitude*j));
				new StringToPokeObj(currentString, pokeReg, latReg, lonReg);
				

			}
		}
		for(PokemonFactory v: PokemonFactory.pokemonList){
			System.out.println(v.toString());
			for(Coordinates x: v.getCoords()){
				System.out.println(x.toString());
			}
		}
		


	}

	private String stringifyURL(String url, double VAR1, double VAR2, double VAR3, double VAR4) throws Exception {
		URLReader derp = new URLReader(url, VAR1, VAR2, VAR3, VAR4);
		return derp.toString();
	}

}
