package fr.esiea.raby_ambassa.word;

import fr.esiea.raby_ambassa.player.Player;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Zenika on 03/03/2017.
 */

@RunWith(JUnit4.class)
public class WordListTest extends TestCase{

    private WordList wordList;
    private Player wordOwner;

    @Before
    public void init() {
        wordOwner = new Player("Pierre");
        wordList = WordList.getInstance();
        wordList.addWord(new Word("Burger", wordOwner));
        wordList.addWord(new Word("Bagel", wordOwner));
        wordList.addWord(new Word("Pizza", wordOwner));
    }

    @Test
    public void existingWordTest() {
        assertTrue(wordList.contains("Burger"));
        assertFalse(wordList.contains("Salade"));
        wordList.addWord(new Word("Salade", wordOwner));
        assertTrue(wordList.contains("Salade"));
        wordList.removeWord("Salade");
    }

    @Test
    public void getNumberOfWordOf() {
        assertEquals(3, wordList.getNumberOfWordsOf(wordOwner));
    }

    @Test
    public void removeWordTest() {
        wordList.addWord(new Word("Salade", wordOwner));
        wordList.removeWord("Salade");
        assertFalse(wordList.contains("Salade"));
    }
}
