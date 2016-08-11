package http;

import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class URLReader {
	private String myString = "";

	String currentURL;

	public URLReader(String url, double firstX, double firstY, double secondX, double secondY) throws Exception {
		currentURL = url;
		// modifies string with VAR1,VAR2,VAR3,VAR4 to coords
		currentURL = modifyURL(currentURL, firstX, firstY, secondX, secondY);
		// gets the text from the proper modified url.
		myString = getStringFromURL(currentURL);
	}

	private String getStringFromURL(String currentURL) throws Exception {
		String currentString = "";
		URL yahoo = new URL(currentURL);
		URLConnection yc = yahoo.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			currentString = inputLine;
		in.close();
		return currentString;
	}

	private String modifyURL(String url, double firstX, double firstY, double secondX, double secondY) {
		String toMod = url;
		toMod = toMod.replace("VAR1", Double.toString(firstX));
		toMod = toMod.replaceAll("VAR2", Double.toString(firstY));
		toMod = toMod.replaceAll("VAR3", Double.toString(secondX));
		toMod = toMod.replaceAll("VAR4", Double.toString(secondY));
		return toMod;
	}

	public String toString() {
		return myString;
	}
}