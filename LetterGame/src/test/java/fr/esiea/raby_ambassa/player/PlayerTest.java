package fr.esiea.raby_ambassa.player;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.xml.ws.WebFault;

/**
 * Created by Zenika on 03/03/2017.
 */
@RunWith(JUnit4.class)
public class PlayerTest extends TestCase{

    @Before
    public void init() {
        // Nothing to do
    }

    @Test
    public void testPlayerCreation() {
        Player player = new Player("Carl");
        assertEquals("Carl", player.getName());
        assertNotSame("Laurent", player.getName());
    }

}
