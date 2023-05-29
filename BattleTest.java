package Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Holds tests related to the doing battles.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 03/04/2023
 */
public class BattleTest {
    // Define the WIN interface variable to use for testing
    WIN game;

    /**
     * Set up a test before it executes.
     */
    @Before
    public void setUp() {
        game = new SpaceWars("Jean");
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
     * Test if a wing facing a skirmish will win.
     */
    @Test
    public void wingFacingSkirmishWins() {
        game.activateForce("IW1");
        game.doBattle(6);
        assertEquals(900, game.getWarchest());
    }

    /**
     * Test if a wing facing a skirmish will lose on strength.
     */
    @Test
    public void wingFacingSkirmishLoseOnStrength() {
        game.activateForce("IW1");
        game.doBattle(2);
        assertEquals(600, game.getWarchest());
    }

    /**
     * Test if a wing facing an ambush wins.
     */
    @Test
    public void wingFacingAmbushWins() {
        game.activateForce("IW1");
        game.doBattle(3);
        assertEquals(950, game.getWarchest());
    }

    /**
     * Test if a wing facing an ambush loses on skill.
     */
    @Test
    public void wingFacingAmbushLoseOnSkill() {
        game.activateForce("IW1");
        game.doBattle(5);
        assertEquals(400, game.getWarchest());
    }

    /**
     * Test if a wing facing a fight is not allowed.
     */
    @Test
    public void wingFacingBattleNotAllowed() {
        game.activateForce("IW1");
        game.doBattle(1);
        assertEquals(500, game.getWarchest());
    }

    /**
     * Test if a starship facing a skirmish will win.
     */
    @Test
    public void starshipFacingSkirmishWins() {
        game.activateForce("SS6");
        game.doBattle(6);
        assertEquals(650, game.getWarchest());
    }

    /**
     * Test if a starship facing a skirmish will lose on strength.
     */
    @Test
    public void starshipFacingSkirmishLoseOnStrength() {
        game.activateForce("SS2");
        game.doBattle(2);
        assertEquals(500, game.getWarchest());
    }

    /**
     * Test if a starship facing an ambush is not allowed.
     */
    @Test
    public void starshipFacingAmbushNotAllowed() {
        game.activateForce("SS2");
        game.doBattle(3);
        assertEquals(300, game.getWarchest());
    }

    /**
     * Test if a starship facing a fight wins.
     */
    @Test
    public void starshipFacingBattleWins() {
        game.activateForce("SS6");
        game.doBattle(1);
        assertEquals(650, game.getWarchest());
    }

    /**
     * Test if a starship facing a fight loses on strength.
     */
    @Test
    public void starshipFacingBattleLoseOnStrength() {
        game.activateForce("SS7");
        game.doBattle(1);
        assertEquals(580, game.getWarchest());
    }

    /**
     * Test if a warbird facing a skirmish is not allowed.
     */
    @Test
    public void warbirdFacingSkirmishNotAllowed() {
        game.activateForce("WB9");
        game.doBattle(6);
        assertEquals(600, game.getWarchest());
    }

    /**
     * Test if a warbird with no cloaking facing an ambush is not allowed.
     */
    @Test
    public void warbirdNoCloakingFacingAmbushNotAllowed() {
        game.activateForce("WB9");
        game.doBattle(3);
        assertEquals(300, game.getWarchest());
    }

    /**
     * Test if a warbird with cloaking facing an ambush wins.
     */
    @Test
    public void warbirdWithCloakingFacingAmbushWins() {
        game.activateForce("WB5");
        game.doBattle(3);
        assertEquals(750, game.getWarchest());
    }

    /**
     * Test if a warbird with cloaking facing an ambush loses on strength
     */
    @Test
    public void warbirdWithCloakingFacingAmbushLoseOnStrength() {
        game.activateForce("WB5");
        game.doBattle(5);
        assertEquals(200, game.getWarchest());
    }

    /**
     * Test if a warbird facing a fight wins.
     */
    @Test
    public void warbirdFacingBattleWinsOnStrength() {
        game.activateForce("WB5");
        game.doBattle(1);
        assertEquals(700, game.getWarchest());
    }

    /**
     * Test if a warbird facing a fight loses on strength.
     */
    @Test
    public void warbirdFacingBattleLoseOnStrength() {
        game.activateForce("WB3");
        game.doBattle(4);
        assertEquals(100, game.getWarchest());
    }

    /**
     * Test if recalling a destroyed force in a battle doesn't affect the warChest.
     */
    @Test
    public void recallingDestroyedForceInFightDoesntAffectWarchest() {
        game.activateForce("IW1");
        game.doBattle(2);
        game.recallForce("IW1");
        assertEquals(600, game.getWarchest());
    }

    /**
     * Test if activating a destroyed force doesn’t affect the warChest.
     */
    @Test
    public void recallingDestroyedInFightForceDoesntAffectWarchestOnReactivation() {
        game.activateForce("IW1");
        game.doBattle(2);
        game.activateForce("IW1");
        assertEquals(600, game.getWarchest());
    }

    /**
     * Test if the admiral is not defeated if they still have active forces.
     */
    @Test
    public void checkNotDefeatedWhileStillActiveForces() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.doBattle(4);
        game.doBattle(5);
        assertFalse(game.isDefeated());
    }

    /**
     * Test if the admiral is defeated if they have no more bit coins.
     */
    @Test
    public void checkDefeatedWhenGoingBust() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.doBattle(4);
        game.doBattle(5);
        game.doBattle(4);
        assertTrue(game.isDefeated());
    }

    // ******************** CUSTOM TESTS ********************
    /**
     * Test if a destroyed force is displayed.
     */
    @Test
    public void listDestroyedForcesHasAForce() {
        String[] target = {"IW1", "Twister", "200", "200", "Destroyed", "10"};
        game.activateForce("IW1");
        game.doBattle(2);
        assertTrue(containsText(game.getDestroyedForces(), target));
    }
}
