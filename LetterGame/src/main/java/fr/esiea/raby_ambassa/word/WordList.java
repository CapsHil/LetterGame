package fr.esiea.raby_ambassa.word;

import fr.esiea.raby_ambassa.player.Player;
import javafx.print.PageLayout;

import java.util.HashSet;

/**
 * Created by capshil on 02/03/2017.
 */
public class WordList {

    private HashSet<Word> words;

    private static WordList ourInstance = new WordList();

    public static WordList getInstance() {
        return ourInstance;
    }

    private WordList() {
        words = new HashSet<Word>();
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public boolean removeWord(String word) {
        for (Word w : words) {
            if(w.getWord().equals(word)) {
                words.remove(w);
                return true;
            }
        }
        return false;
    }

    public boolean contains(String existingWord) {
        for (Word word : words)
            if(word.getWord().equals(existingWord))
                return true;
        return false;
    }

    public String getWordsOf(Player player) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Words of " + player.getName() + " :\n");
        for (Word word: words) {
           if(word.getOwner().equals(player)) {
                stringBuilder.append(word.getWord() + "\n");
           }
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public int getNumberOfWordsOf(Player player) {
        int numberOfWord = 0;
        for (Word word: words) {
            if(word.getOwner().equals(player)) {
                numberOfWord++;
            }
        }
        return numberOfWord;
    }

    @Override
    public String toString() {
        return "WordList{" +
                "words=" + words +
                '}';
    }
}
