package fileManagment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.SaveFile;



public class ReadFromFile implements java.io.Serializable{
	String filename = "data.bin";
	public SaveFile objx;
	public ReadFromFile() {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
			
			objx = (SaveFile) is.readObject();

			is.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
