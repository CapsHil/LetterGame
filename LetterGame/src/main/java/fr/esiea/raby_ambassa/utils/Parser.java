package fr.esiea.raby_ambassa.utils;

import fr.esiea.raby_ambassa.word.Word;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

	private Parser() {
		
	}
	
	public static ArrayList<Word> parse(String fileURL) {
		FileReader input;
		ArrayList<Word> parsedList = new ArrayList<Word>();
		try {
			input = new FileReader(fileURL);
			BufferedReader buffRead = new BufferedReader(input);
			String line;
			while((line = buffRead.readLine()) != null)
				parsedList.add(new Word(line, null));
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
