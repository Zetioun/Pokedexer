package main;

import java.util.regex.Pattern;

import controller.Controller;
import http.URLReader;
import pokemon.Pokemon;
import tools.Filter;
import view.GUI;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class Main {

	public static void main(String[] args) throws Exception {

		//new logic();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					new Controller(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
