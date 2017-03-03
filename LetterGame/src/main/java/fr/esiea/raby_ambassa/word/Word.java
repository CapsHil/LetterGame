package fr.esiea.raby_ambassa.word;

import fr.esiea.raby_ambassa.player.Player;

/**
 * Created by capshil on 20/02/2017.
 */
public class Word {

    private String word;
    private Player owner;

    public Word(String word, Player owner) {
        this.word = word;
        this.owner = owner;
    }

    public String getWord() {
        return word;
    }

    public Player getOwner() {
        return owner;
    }
}

