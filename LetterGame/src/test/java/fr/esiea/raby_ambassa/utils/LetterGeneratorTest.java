package fr.esiea.raby_ambassa.utils;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Zenika on 03/03/2017.
 */
@RunWith(JUnit4.class)
public class LetterGeneratorTest extends TestCase{

    @Test
    public void getRandomLetterTest() {
        assertNotNull(LetterGenerator.getRandomLetter());
    }
}
