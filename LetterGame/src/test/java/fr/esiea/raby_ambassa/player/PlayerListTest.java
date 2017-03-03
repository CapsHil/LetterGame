package fr.esiea.raby_ambassa.player;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Zenika on 03/03/2017.
 */
@RunWith(JUnit4.class)
public class PlayerListTest extends TestCase{

    private PlayerList players;

    @Before
    public void init() {
        players = PlayerList.getInstance();
        players.addPlayer(new Player("Pierre"));
        players.addPlayer(new Player("Thomas"));
        players.addPlayer(new Player("Bastien"));
    }

    @Test
    public void testSwitchPlayerOrder() {
        assertEquals("Pierre", players.getPlayerAt(0).getName());
        assertEquals("Thomas", players.getPlayerAt(1).getName());
        players.switchPlayerOrder(0, 1);
        assertEquals("Thomas", players.getPlayerAt(0).getName());
        assertEquals("Pierre", players.getPlayerAt(1).getName());
        players.switchPlayerOrder(1, 0);
        assertEquals("Pierre", players.getPlayerAt(0).getName());
        assertEquals("Thomas", players.getPlayerAt(1).getName());
    }

//    @Test
//    public void testSetPlayerOrder() {
//        assertEquals("Pierre", players.getPlayerAt(0).getName());
//        assertEquals("Thomas", players.getPlayerAt(1).getName());
//        assertEquals("Bastien", players.getPlayerAt(2).getName());
//        players.setPlayerOrder(new char[]{'b', 'c', 'a'});
//        assertEquals("Thomas", players.getPlayerAt(0).getName());
//        assertEquals("Bastien", players.getPlayerAt(1).getName());
//        assertEquals("Pierre", players.getPlayerAt(2).getName());
//    }
}
