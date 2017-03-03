package fr.esiea.raby_ambassa.utils;

import java.util.Random;

/**
 * Created by capshil on 02/03/2017.
 */
public class LetterGenerator {

    public static char getRandomLetter() {
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        System.out.println("You get letter "+Character.toUpperCase(c));
        return Character.toUpperCase(c);
    }
}
