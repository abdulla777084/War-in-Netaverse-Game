package cwk4;

import java.io.Serializable;

/**
 * Stores the different force states available.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 03/04/2023
 */
public enum ForceState implements Serializable {
    DOCKED("In dock"), ACTIVE("Active"), DESTROYED("Destroyed");
    private final String state;

    /**
     * Constructs a battle type enum.
     *
     * @param st The type of force state.
     */
    ForceState(String st) {
        state = st;
    }

    /**
     * Get a human-readable representation of this enum and the
     * battle scenario it represents.
     *
     * @return A string representation of this enum.
     */
    public String toString() {
        return state;
    }
}
