package fr.esiea.raby_ambassa.dictionary;

import java.util.ArrayList;

public class Dictionnary implements IDictionary{

	private static Dictionnary instance = new Dictionnary();
	
	private Dictionnary() {
		ArrayList<String> parsedDictionnary = Parser.parse("dico.txt");
		System.out.println(parsedDictionnary);
	}
	
	public static Dictionnary getInstance() {
		return instance;
	}
	
	public boolean isWord(String word) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
