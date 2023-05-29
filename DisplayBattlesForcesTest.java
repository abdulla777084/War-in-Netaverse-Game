package Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Holds tests related to the displaying battles and forces.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 01/04/2023
 */
public class DisplayBattlesForcesTest {
    // Define the WIN interface variable to use for testing
    WIN swim;

    /**
     * Set up a test before it executes.
     */
    @Before
    public void setUp() {
        swim = new SpaceWars("Bob");
    }

    /**
     * Determine if a string contains text from a string array.
     *
     * @param text The string to check.
     * @param str  The string array to check if its elements exist in text.
     * @return Whether the string contains text from a string array or not.
     */
    private boolean containsText(String text, String[] str) {
        boolean result = true;
        for (String temp : str) {
            result = result && (text.toLowerCase()).contains(temp.toLowerCase());
        }
        return result;
    }

    /**
     * Test if all battles are displayed (part 1).
     */
    @Test
    public void battleNo1Displayed() {
        String[] battleOne = {"1", "Fight", "Borg"};
        assertTrue(containsText(swim.getAllBattles(), battleOne));
    }

    /**
     * Test if all battles are displayed (part 2).
     */
    @Test
    public void battleNo2Displayed() {
        String[] battleTwo = {"2", "Skirmish", "Kardassians"};
        assertTrue(containsText(swim.getAllBattles(), battleTwo));
    }

    /**
     * Test if all battles are displayed (part 3).
     */
    @Test
    public void battleNo3Displayed() {
        String[] battleThree = {"3", "Ambush", "Ferengi"};
        assertTrue(containsText(swim.getAllBattles(), battleThree));
    }

    /**
     * Test if all battles are displayed (part 4).
     */
    @Test
    public void battleNo4Displayed() {
        String[] battleFour = {"4", "Fight", "Ewoks"};
        assertTrue(containsText(swim.getAllBattles(), battleFour));
    }

    /**
     * Test if all battles are displayed (part 5).
     */
    @Test
    public void battleNo5Displayed() {
        String[] battleFive = {"5", "Ambush", "Borg"};
        assertTrue(containsText(swim.getAllBattles(), battleFive));
    }

    /**
     * Test if all battles are displayed (part 6).
     */
    @Test
    public void battleNo6Displayed() {
        String[] battleSix = {"6", "Skirmish", "Groaners"};
        assertTrue(containsText(swim.getAllBattles(), battleSix));
    }

    /**
     * Test if all forces in the dock are displayed (part 1).
     */
    @Test
    public void forceFleetIW1Displayed() {
        String[] forceIW1 = {"IW1", "Twister"};
        assertTrue(containsText(swim.getForcesInDock(), forceIW1));
    }

    /**
     * Test if all forces in the dock are displayed (part 2).
     */
    @Test
    public void forceFleetSS2Displayed() {
        String[] forceSS2 = {"SS2", "Enterprise"};
        assertTrue(containsText(swim.getForcesInDock(), forceSS2));
    }

    /**
     * Test if all forces in the dock are displayed (part 3).
     */
    @Test
    public void forceFleetWB3Displayed() {
        String[] forceWB3 = {"WB3", "Droop"};
        assertTrue(containsText(swim.getForcesInDock(), forceWB3));
    }

    /**
     * Test if all forces in the dock are displayed (part 4).
     */
    @Test
    public void forceFleetIW4Displayed() {
        String[] forceIW4 = {"IW4", "Winger"};
        assertTrue(containsText(swim.getForcesInDock(), forceIW4));
    }

    /**
     * Test if all forces in the dock are displayed (part 5).
     */
    @Test
    public void forceFleetWB5Displayed() {
        String[] forceWB5 = {"WB5", "Hang"};
        assertTrue(containsText(swim.getForcesInDock(), forceWB5));
    }

    /**
     * Test if all forces in the dock are displayed (part 6).
     */
    @Test
    public void forceFleetSS6Displayed() {
        String[] forceSS6 = {"SS6", "Voyager"};
        assertTrue(containsText(swim.getForcesInDock(), forceSS6));
    }

    /**
     * Test if all forces in the dock are displayed (part 7).
     */
    @Test
    public void forceFleetSS7Displayed() {
        String[] forceSS7 = {"SS7", "Explorer"};
        assertTrue(containsText(swim.getForcesInDock(), forceSS7));
    }

    /**
     * Test if all forces in the dock are displayed (part 8).
     */
    @Test
    public void forceFleetWB9Displayed() {
        String[] forceWB9 = {"WB9", "Hover"};
        assertTrue(containsText(swim.getForcesInDock(), forceWB9));
    }

    /**
     * Test if all forces in the dock are displayed (part 9).
     */
    @Test
    public void forceFleetIW10Displayed() {
        String[] forceIW10 = {"IW10", "Flyer"};
        assertTrue(containsText(swim.getForcesInDock(), forceIW10));
    }
}
