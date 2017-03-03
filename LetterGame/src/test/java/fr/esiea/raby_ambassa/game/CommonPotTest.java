package fr.esiea.raby_ambassa.game;

import fr.esiea.raby_ambassa.game.CommonPot;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Zenika on 03/03/2017.
 */
@RunWith(JUnit4.class)
public class CommonPotTest extends TestCase{

    private CommonPot commonPot;

    @Before
    public void init() {
        commonPot = CommonPot.getInstance();
        commonPot.addLetter('a');
        commonPot.addLetter('b');
        commonPot.addLetter('c');
    }

    @Test
    public void testIfLetterExists() {
        assertTrue(commonPot.isWordAvailable("abc"));
        assertFalse(commonPot.isWordAvailable("def"));
    }

    @Test
    public void testRemoveLetter() {
        commonPot.removeLetters("ab");
        assertTrue(commonPot.isWordAvailable("c"));
        assertFalse(commonPot.isWordAvailable("abc"));
    }


}
