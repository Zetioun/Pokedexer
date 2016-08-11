package fileManagment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


import controller.SaveFile;

public class WriteToFile{
	/**
	 * 
	 */

	private String path = "data.bin";

	
	public WriteToFile(SaveFile objX){
		write(objX);
	}

	private void write(SaveFile objX) {
		try{
			FileOutputStream outStream = new FileOutputStream(path);
			ObjectOutputStream objStream = new ObjectOutputStream(outStream);
			System.out.println(objX.moveLatitude);
			objStream.writeObject(objX);

			   
			
			//close stream
			System.out.println("saved");
			objStream.close();
			outStream.close();
		} catch (FileNotFoundException e) {
			System.out.println(e + "File path not found");
		} catch (IOException e) {
			System.out.println(e + "Object Stream Error");
		}
		
	}
	
}
