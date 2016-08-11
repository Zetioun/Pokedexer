package pokemon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class PokemonFactory implements Comparable<PokemonFactory>{
	String name;
	ArrayList<Coordinates> coordsList = new ArrayList<>();
	public static ArrayList<PokemonFactory> pokemonList = new ArrayList<>();

	public PokemonFactory(String name, Coordinates coord) {

		addNameAndCoord(name, coord);

		ArrayList<Coordinates> myCoordinates = getCoordsListFromThisPokemonName(name);
		if(isThisCoordInTheList(myCoordinates, coord)){
			Iterator <Coordinates> foo = myCoordinates.iterator();
			
			while(foo.hasNext()){
				Coordinates der = foo.next();
				if(der.getLatitude().equals(coord.getLatitude()) && der.getLongtidue().equals(coord.getLongtidue())){
					foo.remove();
				}
				
			}
			addNameAndCoord(name, coord);
		}
		
		
		
		// {

		//}
		Collections.sort(pokemonList);

	}

	private boolean isThisCoordInTheList(ArrayList<Coordinates> myCoordinates, Coordinates coords) {
		try{
		Iterator <Coordinates> tempCoords = myCoordinates.iterator();
		while(tempCoords.hasNext()){
			Coordinates derp = tempCoords.next();
			if(derp.getLatitude().equals(coords.getLatitude()) && derp.getLongtidue().equals(coords.getLongtidue())){
				return true;
			}
		}
		return false;
		}catch(java.lang.NullPointerException e){
			return false;
		}
	}

	private ArrayList<Coordinates> getCoordsListFromThisPokemonName(String nameVar) {
		try {
			Iterator<PokemonFactory> itPokeList = pokemonList.iterator();

			while (itPokeList.hasNext()) {
				PokemonFactory temp = itPokeList.next();
				if (temp.getName().equals(nameVar)) {
					return temp.coordsList;
				}
			}
			return null;
		} catch (java.lang.NullPointerException e) {
			System.out.println("empty string");
			return null;
		}
	}

	private void removeDuplicateCoords(String names, Coordinates coord) {
		System.out.println("Removal on");
		boolean foundCoords = false;
		boolean removedDuplicateCoord = false;
		ArrayList<Coordinates> currentCoords = null;
		Iterator<PokemonFactory> pokeList = PokemonFactory.pokemonList.iterator();
		while (pokeList.hasNext()) {
			PokemonFactory factoryTemp = pokeList.next();
			System.out.println("Has Next");
			if (factoryTemp.toString().equals(name)) {
				currentCoords = factoryTemp.getCoords();
				foundCoords = true;
				System.out.println("Coords Found");
			}
		}
		if (foundCoords) {
			System.out.println("FOUND coords");
			Iterator<Coordinates> itCoords = currentCoords.iterator();
			while (itCoords.hasNext()) {
				System.out.println("---while");
				Coordinates itCurrentCoords = itCoords.next();
				double x1 = Math.abs(Math.abs(itCurrentCoords.getLatitude()) - Math.abs(coord.getLatitude()));
				double x2 = Math.abs(Math.abs(itCurrentCoords.getLongtidue()) - Math.abs(coord.getLongtidue()));
				if (x1 == 0.0 && x2 == 0.0) {
					System.out.println("removed:\n" + itCurrentCoords.getLatitude() + " " + coord.getLatitude() + "\n"
							+ itCurrentCoords.getLongtidue() + " " + coord.getLongtidue());
					removedDuplicateCoord = true;
					itCoords.remove();

				}
			}
			if (removedDuplicateCoord) {
				addNameAndCoord(name, coord);
			}
		}
	}

	private void addNameAndCoord(String name, Coordinates coord) {
		boolean temp = false;
		Iterator<PokemonFactory> kulltemp = pokemonList.iterator();
		while (kulltemp.hasNext()) {
			if (kulltemp.next().toString().equals(name)) {
				temp = true;
			}
		}
		if (temp) {
			for (PokemonFactory v : pokemonList) {
				if (v.toString().equals(name)) {
					// removeDuplicateCoords(name, coord);
					v.coordsList.add(coord);
				}
			}
		} else {
			this.name = name;
			coordsList.add(coord);
			pokemonList.add(this);
		}

	}

	public ArrayList<Coordinates> getCoords() {
		return coordsList;
	}

	public void setCoords(ArrayList<Coordinates> coords) {
		this.coordsList = coords;
	}

	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(PokemonFactory name){
		return this.name.compareTo(name.getName());
	}
	

}
