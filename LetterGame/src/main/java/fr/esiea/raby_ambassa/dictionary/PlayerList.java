package fr.esiea.raby_ambassa.dictionary;

import java.util.ArrayList;

/**
 * Created by capshil on 20/02/2017.
 */
public class PlayerList {

    private ArrayList<Player> players;

    public PlayerList(){
        players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public String toString() {
        return "PlayerList{" +
                "players=" + players +
                '}';
    }
}
