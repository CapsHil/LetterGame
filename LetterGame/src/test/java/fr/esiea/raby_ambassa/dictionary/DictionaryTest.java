package fr.esiea.raby_ambassa.dictionary;

import org.junit.Before;

import fr.esiea.raby_ambassa.dictionary.IDictionary;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Unit test sample for Dictionary.
 */
public class DictionaryTest {

    private IDictionary dictionary;

    @Before
    public void setup() {
        //TODO
    }

    public void testIsWord() {
        assertTrue(dictionary.isWord("maman"));
        assertFalse(dictionary.isWord("namam"));
    }
}
