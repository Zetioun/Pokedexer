package pokemon;

import java.util.ArrayList;
import java.util.Iterator;

public class Pokemon {
	/*
	public static void main(String[] args){
		new Pokemon("Tangela", 39.914944, -75.160876);
		new Pokemon("Dangela", 39.914944, -75.160876);
		new Pokemon("Dangela", 39.914944, -75.160876);
		new Pokemon("Tangela", 39.1914944, -75.160876);
		new Pokemon("Tangela", 39.914944, -75.1608376);
		new Pokemon("Tangesada", 39.914944, -75.160876);
		new Pokemon("Tangedsla", 39.914944, -75.160876);
		new Pokemon("Tangela", 39.914944, -75.160876);
		new Pokemon("Tangela", 39.914944, -75.160876);
		new Pokemon("Tangelsada", 39.914944, -75.160876);
		new Pokemon("Tangela", 39.914944, -75.160876);
		new Pokemon("Tangesadla", 39.914944, -75.160876);
		new Pokemon("Dangela", 39.9149441, -75.160876);
		new Pokemon("Dangela", 39.9149441, -75.160876);
		new Pokemon("Aangela", 39.914944, -75.160876);
		new Pokemon("Dangela", 39.914944, -75.160876);
		new Pokemon("Tangela", 39.914944, -75.160876);
		new Pokemon("Qangela", 39.914944, -75.160876);
		for(PokemonFactory v: PokemonFactory.pokemonList){
			System.out.println("Name: " + v.toString() );
			for(Coordinates x: v.coordsList){
				System.out.print(" L: " +x.getLatitude() + " Lo: " + x.getLongtidue() + "\n");
			}
		}
	}
	*/
	public Pokemon(String pokemonName, double latitude, double longitude) {
		Coordinates coords = new Coordinates(latitude, longitude); //creates coordinate object (two strings lat & lon)
		new PokemonFactory(pokemonName, coords);  //makes the pokemon
	}

}
