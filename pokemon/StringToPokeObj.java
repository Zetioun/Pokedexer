package pokemon;

import java.util.ArrayList;

import tools.Filter;

public class StringToPokeObj {
	private static ArrayList<String> latitude = new ArrayList<>();
	private static ArrayList<String> longitude = new ArrayList<>();
	private static ArrayList<String> pokemonName = new ArrayList<>();

	public StringToPokeObj(String currentString, String pokeReg, String latReg, String lonReg) {
		performRegex(currentString, pokeReg, latReg, lonReg);
		
		for (int i = 0; i < pokemonName.size(); i++) {
			new Pokemon(pokemonName.get(i).toString(), Double.parseDouble(latitude.get(i)), Double.parseDouble(longitude.get(i)));
		}
		
	}
	private void performRegex(String currentUrlString, String pokeReg, String latReg, String lonReg) {
		latitude = Filter.string(latReg, currentUrlString);
		longitude = Filter.string(lonReg, currentUrlString);
		pokemonName = Filter.string(pokeReg, currentUrlString);

	}
}
