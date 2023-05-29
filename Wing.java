package cwk4;

/**
 * Represents a wing in the United Forces Fleet (UFF) which cannot
 * be sent on fights.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 03/04/2023
 */
public class Wing extends Force {
    private final int strikers;

    /**
     * Constructs a wing object.
     *
     * @param ref   The wing's reference.
     * @param nme   The wing's name.
     * @param cost  The wing's activation fee.
     * @param strik The wing's striker count.
     */
    public Wing(String ref, String nme, int cost, int strik) {
        super(ref, nme, cost, strik * 20);
        strikers = strik;
    }

    /**
     * Get the wing's striker count.
     *
     * @return The wing's striker count.
     */
    public int getStrikers() {
        return strikers;
    }

    /**
     * Determines if the wing can fight in a given battle.
     *
     * @param battleType The battle to check if the force can fight in.
     * @return Whether the wing can fight in the battle or not.
     */
    public boolean canFight(BattleType battleType) {
        // The wing can only fight in skirmishes and ambushes
        switch (battleType) {
            case SKIRMISH:
            case AMBUSH:
                return true;
            default:
                return false;
        }
    }

    /**
     * Get a human-readable representation of this object including the
     * force reference, the force name, the activation cost, the force
     * strength, and the striker count.
     *
     * @return A string representation of this object.
     */
    public String toString() {
        return "<Force Reference: " + getReference() + " - Name: " + getName() + " - Force State: " + getForceState() + " - Activation Fee: " + getFee() + " - Strength: " + getStrength() + " - Striker Count: " + getStrikers() + ">";
    }
}
