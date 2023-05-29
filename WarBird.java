package cwk4;

/**
 * Represents a warbird in the United Forces Fleet (UFF) which cannot
 * be sent on skirmishes and can only be sent on ambushes if they have
 * a cloaking device.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 03/04/2023
 */
public class WarBird extends Force {
    private final boolean cloaking;

    /**
     * Constructs a warbird object.
     *
     * @param ref     The warbird's reference.
     * @param nme     The warbird's name.
     * @param strngth The warbird's strength.
     * @param cloak   Whether the warbird has a cloaking device or not.
     */
    public WarBird(String ref, String nme, int strngth, boolean cloak) {
        super(ref, nme, cloak ? 400 : 300, strngth);
        cloaking = cloak;
    }

    /**
     * Determines if the warbird has a cloaking device or not.
     *
     * @return Whether the warbird has a cloaking device or not.
     */
    public boolean isCloaking() {
        return cloaking;
    }

    /**
     * Determines if the warbird can fight in a given battle.
     *
     * @param battleType The battle to check if the force can fight in.
     * @return Whether the force can fight in the battle or not.
     */
    public boolean canFight(BattleType battleType) {
        // The warbird can only fight in fights and ambushes (if they have cloaking)
        switch (battleType) {
            case AMBUSH:
                return isCloaking();
            case FIGHT:
                return true;
            default:
                return false;
        }
    }

    /**
     * Get a human-readable representation of this object including the
     * force reference, the force name, the activation cost, the force
     * strength, and whether the warbird has a cloaking device or not.
     *
     * @return A string representation of this object.
     */
    public String toString() {
        return "<Force Reference: " + getReference() + " - Name: " + getName() + " - Force State: " + getForceState() + " - Activation Fee: " + getFee() + " - Strength: " + getStrength() + " - Cloaking Device: " + isCloaking() + ">";
    }
}
