package cwk4;

import java.io.Serializable;

/**
 * Stores the different battle scenarios available.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 23/03/2023
 */
public enum BattleType implements Serializable {
    SKIRMISH("Skirmish"), AMBUSH("Ambush"), FIGHT("Fight");
    private final String type;

    /**
     * Constructs a battle type enum.
     *
     * @param typ The type of battle scenario.
     */
    BattleType(String typ) {
        type = typ;
    }

    /**
     * Get a human-readable representation of this enum and the
     * battle scenario it represents.
     *
     * @return A string representation of this enum.
     */
    public String toString() {
        return type;
    }
}
