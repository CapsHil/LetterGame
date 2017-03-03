package fr.esiea.raby_ambassa.dictionary;

import java.util.ArrayList;

/**
 * Created by capshil on 02/03/2017.
 */
public class CommonPot {

    private static CommonPot instance = new CommonPot();

    private ArrayList<Character> commonPot;
    private ArrayList<Character> tmp;

    private CommonPot() {
        commonPot = new ArrayList<Character>();
    }

    public static CommonPot getInstance() {
        return instance;
    }

    public void addLetter(char letter) {
        commonPot.add(letter);
    }

    private boolean removeLetter(Character letter) {
        return commonPot.remove(letter);
    }

    private boolean removeLetterFromTmp(Character letter) {
        return tmp.remove(letter);
    }

    public void removeLetters(String letters) {
        for (Character character : letters.toCharArray()) {
            this.removeLetter(character);
        }
    }

    public boolean isWordAvailable(String word) {

        tmp = (ArrayList<Character>) commonPot.clone();
        for (Character character: word.toCharArray())
            if(!this.removeLetterFromTmp(character))
                return false;
        return true;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Current common pot : ");
        for(int i=0; i<commonPot.size(); i++) {
            stringBuilder.append(Character.toUpperCase(commonPot.get(i)));
            if(i != commonPot.size()-1)
                stringBuilder.append(" - ");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "CommonPot{" +
                "commonPot=" + commonPot +
                '}';
    }
}
