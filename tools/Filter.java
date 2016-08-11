package tools;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {

	public static ArrayList<String> string(String regex, String text) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		ArrayList<String> textList = new ArrayList<String>();

		while (matcher.find()) {
			textList.add(matcher.group(1));
		}
		return textList;
	}

	public static ArrayList<String> arrayList(String regex, ArrayList<String> list) {
		ArrayList<String> textList = new ArrayList<String>();
		Pattern pattern = Pattern.compile(regex);
		for (String i : list) {
			Matcher matcher = pattern.matcher(i);
			while (matcher.find()) {
				textList.add(matcher.group(1));
			}
		}
		return textList;
	}
}
