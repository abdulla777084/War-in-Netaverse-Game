package cwk4;

import java.io.Serializable;

/**
 * Represents a force in the United Forces Fleet (UFF) which can partake
 * in battles.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 03/04/2023
 */
abstract public class Force implements Serializable {
    private final String reference;
    private final String name;
    private final int fee;
    private final int strength;
    private ForceState forceState;

    /**
     * Constructs a force object.
     *
     * @param ref     The force's reference.
     * @param nme     The force's name.
     * @param cost    The force's activation fee.
     * @param strngth The force's strength.
     */
    public Force(String ref, String nme, int cost, int strngth) {
        reference = ref;
        name = nme;
        fee = cost;
        strength = strngth;
        forceState = ForceState.DOCKED;
    }

    /**
     * Get the force's reference.
     *
     * @return The force's reference.
     */
    public String getReference() {
        return reference;
    }

    /**
     * Get the force's name.
     *
     * @return The force's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the force's activation fee.
     *
     * @return The force's activation fee.
     */
    public int getFee() {
        return fee;
    }

    /**
     * Get the force's strength
     *
     * @return The force's strength.
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Get the force's state.
     *
     * @return The force's state.
     */
    public ForceState getForceState() {
        return forceState;
    }

    /**
     * Determine if the force is in the UFF dock or not.
     *
     * @return Whether the force is in the UFF dock or not.
     */
    public boolean isDocked() {
        return forceState == ForceState.DOCKED;
    }

    /**
     * Determine if the force is active or not.
     *
     * @return Whether the force is active or not.
     */
    public boolean isActive() {
        return forceState == ForceState.ACTIVE;
    }

    /**
     * Determine if the force is destroyed or not.
     *
     * @return Whether the force is destroyed or not.
     */
    public boolean isDestroyed() {
        return forceState == ForceState.DESTROYED;
    }

    /**
     * Set the force's state to docked.
     */
    public void setInDock() {
        // If the force is in the ASF, move it to the UFF
        if (forceState == ForceState.ACTIVE) {
            forceState = ForceState.DOCKED;
        }
    }

    /**
     * Set the force's state to active.
     */
    public void setActive() {
        // If the force is in the UFF, move it to the ASF
        if (forceState == ForceState.DOCKED) {
            forceState = ForceState.ACTIVE;
        }
    }

    /**
     * Set the force's state to destroyed.
     */
    public void setDestroyed() {
        // If the force is in the ASF, destroy it
        if (forceState == ForceState.ACTIVE) {
            forceState = ForceState.DESTROYED;
        }
    }

    /**
     * Determines if the force can fight in a given battle.
     *
     * @param battleType The battle to check if the force can fight in.
     * @return Whether the force can fight in the battle or not.
     */
    abstract boolean canFight(BattleType battleType);

    /**
     * Get a human-readable representation of this object including the
     * force reference, the force name, the activation cost, and the force
     * strength.
     *
     * @return A string representation of this object.
     */
    public String toString() {
        return "<Force Reference: " + getReference() + " - Name: " + getName() + " - Force State: " + getForceState() + " - Activation Fee: " + getFee() + " - Strength: " + getStrength() + ">";
    }
}
