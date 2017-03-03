package fr.esiea.raby_ambassa.dictionnary;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit test sample for Dictionary.
 */
@RunWith(JUnit4.class)
public class DictionaryTest extends TestCase{

    private IDictionary dictionary;

    @Before
    public void init() {
        dictionary = Dictionnary.getInstance();
    }

    @Test
    public void testIsWord() {
        assertTrue(dictionary.isWord("maman"));
        assertFalse(dictionary.isWord("namam"));
    }
}
