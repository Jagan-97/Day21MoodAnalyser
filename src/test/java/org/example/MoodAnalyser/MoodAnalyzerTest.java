package org.example.MoodAnalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class MoodAnalyzerTest {
    /*
     *This Test Case Excepts
     * Sad Mood
     */
    @Test
    public void givenMessgae_WhenSad_ShouldReturn_Sad() throws MoodAnalyserException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD", mood);
    }

    /*
     *This Test Case Excepts
     * Happy Mood
     */
    @Test
    public void givenMessage_WhenNotSad_ShouldReturn_Happy() throws MoodAnalyserException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in any Mood");
        String mood = moodAnalyzer.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }

    /*
     *This Test Case Will Check For
     * Null Pointer Exception
     */
    @Test
    public void givenNullMood_ShouldReturn_Happy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        String mood;
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyserException e) {
            assertEquals(MoodAnalyserException.exceptionType.ENTERED_NULL, e.type);
        }
    }

    /*
     *This Test Case Will Check For
     * Null Pointer Exception
     * for empty and null values
     */
    @Test
    public void givenNullMood_ShouldThrow_Exception() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            moodAnalyzer.analyseMood(null);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.exceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenEmptyMood_ShouldThrow_Exception() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(" ");
        try {
            moodAnalyzer.analyseMood(" ");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.exceptionType.ENTERED_EMPTY, e.type);
        }
    }

}