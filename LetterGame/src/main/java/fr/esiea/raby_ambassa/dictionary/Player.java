package fr.esiea.raby_ambassa.dictionary;

/**
 * Created by capshil on 20/02/2017.
 */
public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
