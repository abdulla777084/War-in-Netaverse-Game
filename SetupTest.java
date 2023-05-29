package Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Holds tests related to the initialisation of the game.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 03/04/2023
 */
public class SetupTest {
    // Define the WIN interface variable to use for testing
    WIN game;

    /**
     * Set up a test before it executes.
     */
    @Before
    public void setUp() {
        game = new SpaceWars("David");
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
     * Test if the game is correctly initialised.
     */
    @Test
    public void gameCorrectlyInitialised() {
        String[] details = {"David", "1000", ""};
        assertTrue(containsText(game.toString(), details));
    }

    /**
     * Test if warChest has 1000 bit coins before a battle.
     */
    @Test
    public void warChestWhenNoBattle() {
        assertEquals(1000, game.getWarchest());
    }

    /**
     * Test if a battle is initialised at setup.
     */
    @Test
    public void battleAtSetup() {
        assertTrue(game.isBattle(3));
    }

    /**
     * Test if all battles are initialised at setup.
     */
    @Test
    public void allBattleLoadedAtSetup() {
        boolean result = true;
        for (int i = 1; i < 8; i++) {
            result = result && game.isBattle(i);
        }
        assertTrue(result);
    }

    /**
     * Test if a force is in UFF at setup.
     */
    @Test
    public void forceInUFFAtSetup() {
        assertTrue(game.isInUFFDock("IW1"));
    }

    /**
     * Test if all forces are in UFF at setup.
     */
    @Test
    public void UFFleetLoadedAtTheBeginning() {
        boolean result = true;
        String[] forces = {"IW1", "WB3", "SS2", "IW4", "WB5", "SS6", "SS7", "WB9", "IW10"};
        for (String force : forces) {
            result = result && game.isInUFFDock(force);
        }
        assertTrue(result);
    }

    /**
     * Test if ASF is empty at setup.
     */
    @Test
    public void ASFleetEmptyAtTheBeginning() {
        boolean result = true;
        String[] forces = {"IW1", "WB3", "SS2", "IW4", "WB5", "SS6", "SS7", "WB9", "IW10"};
        for (String force : forces) {
            result = result && !game.isInASFleet(force);
        }
        assertTrue(result);
    }

    /**
     * Get details of a warbird.
     */
    @Test
    public void detailsOfWB3() {
        String[] target = {"WB3", "Droop", "100", "300", "In dock", "false"};
        assertTrue(containsText(game.getForceDetails("WB3"), target));
    }

    /**
     * Get details of a starship.
     */
    @Test
    public void detailsOfSS2() {
        String[] target = {"SS2", "Enterprise", "200", "300", "In dock", "20", "10"};
        assertTrue(containsText(game.getForceDetails("SS2"), target));
    }

    /**
     * Get details of a wing.
     */
    @Test
    public void detailsOfIW1() {
        String[] target = {"IW1", "Twister", "200", "200", "In dock", "10"};
        assertTrue(containsText(game.getForceDetails("IW1"), target));
    }

    /**
     * Get details of an invalid force.
     */
    @Test
    public void detailsOfNonExistentForce() {
        String[] target = {"No such force"};
        assertTrue(containsText(game.getForceDetails("XX3"), target));
    }

    /**
     * Get details of valid battle.
     */
    @Test
    public void detailsOfBattle() {
        String[] details = {"2", "Skirmish", "Kardassians", "700", "200", "120"};
        assertTrue(containsText(game.getBattle(2), details));
    }

    // ******************** CUSTOM TESTS ********************

    /**
     * Test if an invalid battle is initialised at setup
     */
    @Test
    public void invalidBattleAtSetup() {
        assertFalse(game.isBattle(-1));
    }

    /**
     * Get details of an invalid battle.
     */
    @Test
    public void detailsOfInvalidBattle() {
        String[] target = {"No such battle"};
        assertTrue(containsText(game.getBattle(-1), target));
    }

    /**
     * Test if an invalid force is not in the dock.
     */
    @Test
    public void invalidForceNotInDock() {
        assertFalse(game.isInUFFDock("XX3"));
    }

    /**
     * Test if an invalid force is in the ASF.
     */
    @Test
    public void invalidForceInASF() {
        assertFalse(game.isInASFleet("XX3"));
    }

    /**
     * Test if no forces are destroyed at setup.
     */
    @Test
    public void destroyedForcesEmpty() {
        String[] target = {"No forces"};
        assertTrue(containsText(game.getDestroyedForces(), target));
    }
}
