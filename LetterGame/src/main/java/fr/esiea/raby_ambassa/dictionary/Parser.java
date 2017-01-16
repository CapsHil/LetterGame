package fr.esiea.raby_ambassa.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

	private Parser() {
		
	}
	
	public static ArrayList<String> parse(String fileURL) {
		FileReader input;
		ArrayList<String> parsedList = new ArrayList<String>();
		try {
			input = new FileReader(fileURL);
			BufferedReader buffRead = new BufferedReader(input);
			String line = null;
			while((line = buffRead.readLine()) != null)
				parsedList.add(line);
			buffRead.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parsedList;
	}
}
