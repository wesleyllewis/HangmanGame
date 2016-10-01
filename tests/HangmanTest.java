import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

/**
 * Created by WesleyLewis on 9/30/16.
 */
public class HangmanTest {

    @Test
    public void testPopulateSecretWordList() {
        Hangman.populateBlankList();
        Hangman.populateSecretWordList("Bicycle");
        Assert.assertFalse(Hangman.secretWordList.contains("T"));
        Assert.assertTrue(Hangman.secretWordList.contains("B"));
    }
    @Test
    public void testCheckGuess(){
        Hangman.populateBlankList();
        Hangman.populateSecretWordList("Bicycle");
        Hangman.checkGuess("B");
        Hangman.checkGuess("i");
        Assert.assertTrue(Hangman.displayList.contains("B"));
        Assert.assertFalse(Hangman.displayList.contains("X"));
    }
    @Test
    public void testWinCon(){
        Hangman.populateBlankList();
        Hangman.populateSecretWordList("Bicycle");
        Hangman.checkGuess("B");
        Hangman.checkGuess("i");
        Hangman.checkGuess("c");
        Hangman.checkGuess("y");
        Hangman.winCondition();
        Hangman.checkGuess("l");
        Hangman.checkGuess("e");
        Hangman.winCondition();
    }
    @Test
    public void testLossCon(){
        int testTurns = Hangman.turns + 10;
        Hangman.turns = testTurns;
        Hangman.lossCondition();
    }



}