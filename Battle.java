package cwk4;

import java.io.Serializable;

/**
 * Represents a battle between the Active Star Fleet (ASF) and the
 * enemy.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 03/04/2023
 */
public class Battle implements Serializable {
    private final int battleNumber;
    private final BattleType battleType;
    private final String enemy;
    private final int enemyStrength;
    private final int losses;
    private final int gains;

    /**
     * Constructs a battle object.
     *
     * @param number   The battle's number.
     * @param type     The battle's type.
     * @param enmy     The enemy in the battle.
     * @param strength The enemy's strength in the battle.
     * @param loss     The losses that the admiral can take from losing
     *                 this battle.
     * @param gain     The gains that the admiral can take from winning
     *                 this battle.
     */
    public Battle(int number, BattleType type, String enmy, int strength, int loss, int gain) {
        battleNumber = number;
        battleType = type;
        enemy = enmy;
        enemyStrength = strength;
        losses = loss;
        gains = gain;
    }

    /**
     * Get the battle's number.
     *
     * @return The battle's number.
     */
    public int getBattleNumber() {
        return battleNumber;
    }

    /**
     * Get the battle's type.
     *
     * @return The battle's type.
     */
    public BattleType getBattleType() {
        return battleType;
    }

    /**
     * Get the enemy in the battle.
     *
     * @return The enemy in the battle.
     */
    public String getEnemy() {
        return enemy;
    }

    /**
     * Get the enemy's strength in the battle.
     *
     * @return The enemy's strength in the battle.
     */
    public int getEnemyStrength() {
        return enemyStrength;
    }

    /**
     * Get the losses that the admiral can take losing this battle.
     *
     * @return The losses that the admiral can take losing this battle.
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Get the gains that the admiral can take from winning this battle.
     *
     * @return The gains that the admiral can take from winning this battle.
     */
    public int getGains() {
        return gains;
    }

    /**
     * Get a human-readable representation of this object including the
     * battle number, the battle type, the enemy, the enemy's strength,
     * the losses, and the gains.
     *
     * @return A string representation of this object.
     */
    public String toString() {
        return "<Battle number: " + battleNumber + " - Battle Type: " + battleType + " - Enemy: " + enemy + " - Enemy Strength: " + enemyStrength + " - Losses: " + losses + " - Gains: " + gains + ">";
    }
}
