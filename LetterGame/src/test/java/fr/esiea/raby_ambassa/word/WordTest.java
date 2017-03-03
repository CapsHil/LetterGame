package fr.esiea.raby_ambassa.word;

import fr.esiea.raby_ambassa.player.Player;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Zenika on 03/03/2017.
 */

@RunWith(JUnit4.class)
public class WordTest extends TestCase{

    @Test
    public void addWordTest() {
        Player wordOwner = new Player("Alexandre");
        Word word = new Word("Coucou", wordOwner);
        assertEquals("Coucou", word.getWord());
        assertEquals("Alexandre", word.getOwner().getName());
    }
}
