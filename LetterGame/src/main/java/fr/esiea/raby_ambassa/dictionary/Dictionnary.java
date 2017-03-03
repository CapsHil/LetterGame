package fr.esiea.raby_ambassa.dictionary;

import fr.esiea.raby_ambassa.utils.Log;
import fr.esiea.raby_ambassa.utils.Parser;
import fr.esiea.raby_ambassa.word.Word;

import java.util.ArrayList;

public class Dictionnary implements IDictionary{

	private static Dictionnary instance = new Dictionnary();
	private ArrayList<Word> dictionnary;
	
	private Dictionnary() {
		dictionnary = Parser.parse("src/main/resources/dico.txt");
		Log.verbose(dictionnary.toString());
	}
	
	public static Dictionnary getInstance() {
		return instance;
	}
	
	public boolean isWord(String existingWord) {
		for (Word word : dictionnary)
			if(word.getWord().toUpperCase().equals(existingWord.toUpperCase()))
				return true;
		return false;
	}
	
	
	
}
