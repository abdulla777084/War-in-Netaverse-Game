package Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Holds tests related to the force activation.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 31/03/2023
 */
public class ForceActivationTest {
    // Define the WIN interface variable to use for testing
    WIN game;

    /**
     * Set up a test before it executes.
     */
    @Before
    public void setUp() {
        game = new SpaceWars("Olenka");
    }

    /**
     * Test if a force is activated correctly.
     */
    @Test
    public void forceActivationReturn() {
        assertEquals(game.activateForce("IW1"), 0);
    }

    /**
     * Test if an activated force is added to the ASF.
     */
    @Test
    public void forceActivationWorks() {
        game.activateForce("IW1");
        assertTrue(game.isInASFleet("IW1"));
    }

    /**
     * Test if the warChest decreases after a force activation.
     */
    @Test
    public void warchestAfterForceActivated() {
        game.activateForce("IW1");
        assertEquals(800, game.getWarchest());
    }

    /**
     * Test if a force is now active after activation.
     */
    @Test
    public void statusActiveForActivatedForce() {
        game.activateForce("IW1");
        assertTrue(game.getForceDetails("IW1").toLowerCase().contains("active"));
    }

    /**
     * Test warChest value after multiple activations.
     */
    @Test
    public void notEnoughCreditInWarchest() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.activateForce("WB5");
        assertEquals(200, game.getWarchest());
    }

    /**
     * Test if a force activation fails if there is not enough bit coins.
     */
    @Test
    public void returnValueForNotEnoughInWarchest() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        assertEquals(2, game.activateForce("WB5"));
    }

    /**
     * Test if an invalid force activation fails if there are not enough bit coins.
     */
    @Test
    public void returnValueForNotEnoughInWarchestOnNonExistentForce() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.activateForce("WB5");
        assertEquals(-1, game.activateForce("XX3"));
    }

    /**
     * Test if activating an activated force has no effect.
     */
    @Test
    public void reactivateExistingForceHasNoEffectOnWarchest() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.activateForce("IW1");
        assertEquals(200, game.getWarchest());
    }

    /**
     * Test if recalling an active force updates the warChest.
     */
    @Test
    public void forceRecallUpdatesWarchestForActivatedForce() {
        game.activateForce("WB5");
        game.recallForce("WB5");
        assertEquals(800, game.getWarchest());
    }

    /**
     * Test if recalling an inactive force does not update the warChest.
     */
    @Test
    public void forceRecallDoesNotUpdateWarchestForNonActiveForce() {
        game.activateForce("WB5");
        game.recallForce("WB5");
        game.recallForce("IW1");
        assertEquals(800, game.getWarchest());
    }

    /**
     * Test if recalling an invalid force does not update the warChest.
     */
    @Test
    public void forceRecallDoesNotUpdateWarchestForNonExistentForce() {
        game.activateForce("WB5");
        game.recallForce("WB5");
        game.recallForce("XX3");
        assertEquals(800, game.getWarchest());
    }

    // ******************** CUSTOM TESTS ********************

    /**
     * Test if an invalid force can be activated.
     */
    @Test
    public void invalidForceActivate() {
        assertEquals(game.activateForce("XX3"), -1);
    }

    /**
     * Test if a destroyed force can be reactivated.
     */
    @Test
    public void destroyedForceReactivation() {
        game.activateForce("IW1");
        game.doBattle(2);
        assertEquals(game.activateForce("IW1"), 1);
    }

    /**
     * Test if an activated force can be activated.
     */
    @Test
    public void activateActivatedForce() {
        game.activateForce("IW1");
        assertEquals(game.activateForce("IW1"), 1);
    }

    /**
     * Test if an inactivated force is in the ASF.
     */
    @Test
    public void inactivatedForceInASF() {
        assertFalse(game.isInASFleet("IW1"));
    }
}
