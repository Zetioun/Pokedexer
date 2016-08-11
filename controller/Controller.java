package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fileManagment.ReadFromFile;
import fileManagment.WriteToFile;
import model.Logic;
import pokemon.Coordinates;
import pokemon.Pokemon;
import pokemon.PokemonFactory;
import view.GUI;

public class Controller {
	private GUI gui;
	String startLatitude;
	String startLongitude;
	String moveLatitude;
	String moveLongitude;
	String stepLatitude;
	String stepLongitude;
	String regexPokemonName;
	String regexLatitude;
	String regexLongitude;
	String URL;
	ArrayList<PokemonFactory> pokemons = new ArrayList<>();

	public Controller(GUI gui) {
		this.gui = gui;
		
		gui.addActionListenerScan(new registerListenerScan());
		gui.addActionListenerSave(new registerListenerSave());
		gui.addActionListenerPokemonNameList(new listListener());
		gui.addActionListenerCoordinateList(new listListenerCoordinates());
		
		
		loadSave();
	}


	private void loadSave() {
		SaveFile LOAD = new ReadFromFile().objx;
		gui.setTfStartLatitude(LOAD.startLatitude);
		gui.setTfStartLongitude(LOAD.startLongitude);
		gui.setTfMoveLatitude(LOAD.moveLatitude);
		gui.setTfMoveLongitude(LOAD.moveLongitude);
		gui.setTfRegexPokemonName(LOAD.regexPokemonName);
		gui.setTfRegexLatitude(LOAD.regexLatitude);
		gui.setTfRegexLongitude(LOAD.regexLongitude);
		gui.setTfStepsLatitude(LOAD.stepLatitude);
		gui.setTfStepsLongitude(LOAD.stepLongitude);
		gui.setTfURL(LOAD.URL);


	}


	public class registerListenerSave implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			getTextFields();
			SaveFile derp = new SaveFile( startLatitude,  startLongitude,  moveLatitude,  
					moveLongitude, stepLatitude,  stepLongitude,  regexPokemonName,  regexLatitude,  URL,  regexLongitude);
			
			
			new WriteToFile(derp);
			
		}
	}

	public class registerListenerScan implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			getTextFields();

			try {
				new Logic(URL, startLatitude, startLongitude, moveLatitude, moveLongitude, regexPokemonName,
						regexLatitude, regexLongitude, stepLatitude, stepLongitude);
			} catch (Exception e1) {
				System.out.println(e1 + " Controller: actionPerformed Error");
			}

			getPokemonList();
			setPokemonInLists();

		}

		private void setPokemonInLists() {
			DefaultListModel<PokemonFactory> pokes = new DefaultListModel<>();

			for (PokemonFactory v : pokemons) {
				pokes.addElement(v);

			}
			gui.setListPokemon(pokes);

		}

		private void getPokemonList() {
			pokemons = PokemonFactory.pokemonList;
		}

	}

	public class listListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting() == false) {

			} else {
				JList derp = gui.getListPokemon();
				PokemonFactory pkfObj = (PokemonFactory) derp.getSelectedValue();

				DefaultListModel<String> coords = new DefaultListModel<>();
				for (Coordinates x : pkfObj.getCoords()) {
					coords.addElement(x.toString());
				}
				gui.setListCoordinate(coords);
			}

		}

	}

	public class listListenerCoordinates implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting() == false) {

			} else {
				String Name = gui.getListPokemon().getSelectedValue().toString();
				String coords = gui.getListCoordinate().getSelectedValue().toString();
				// String foo = derp.toString();
				gui.setCoordTextField(Name +" " +coords);
			}
		}

	}
	//------------------------------------------Methods--------------------------------
	public void getTextFields() {
		startLatitude = gui.getTfStartLatitude();
		startLongitude = gui.getTfStartLongitude();
		moveLatitude = gui.getTfMoveLatitude();
		moveLongitude = gui.getTfMoveLongitude();
		regexPokemonName = gui.getTfRegexPokemonName();
		regexLatitude = gui.getTfRegexLatitude();
		regexLongitude = gui.getTfRegexLongitude();
		stepLatitude = gui.getTfStepsLatitude();
		stepLongitude = gui.getTfStepsLongitude();
		URL = gui.getTfURL();
	}
}
