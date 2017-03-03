package fr.esiea.raby_ambassa.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by capshil on 20/02/2017.
 */
public class PlayerList {

    private static PlayerList instance = new PlayerList();

    private ArrayList<Player> players;

    private PlayerList(){
        players = new ArrayList<Player>();
    }

    public static PlayerList getInstance() {
        return instance;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void switchPlayerOrder(int player1, int player2) {
        Collections.swap(players, player1, player2);
    }

    public Player getPlayerAt(int at) {
        return players.get(at);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayerOrder(char[] orderArray) {
        char tmp;
        for(int i=0; i<players.size(); ++i) {
            for(int j=i+1; j<players.size(); ++j) {
                if (orderArray[i] > orderArray[j]) {
                    tmp = orderArray[i];
                    orderArray[i] = orderArray[j];
                    orderArray[j] = tmp;
                    this.switchPlayerOrder(i, j);
                }
            }
        }
        System.out.print("\nPlayer order : ");
        for(int i=0; i<players.size(); i++) {
            System.out.print(players.get(i).getName());
            if(i != players.size()-1) {
                System.out.print(" ==> ");
            }
        }
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return "PlayerList{" +
                "players=" + players +
                '}';
    }
}
