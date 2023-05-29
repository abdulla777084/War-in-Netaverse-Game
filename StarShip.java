package cwk4;

/**
 * Represents a starship in the United Forces Fleet (UFF) which cannot
 * be sent on ambushes.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 03/04/2023
 */
public class StarShip extends Force {
    private final int laserCannons;
    private final int photonTorpedoes;

    /**
     * Constructs a starship object.
     *
     * @param ref    The starship's reference.
     * @param nme    The starship's name.
     * @param laser  How many laser cannons the starship has.
     * @param photon How many photon torpedoes the starship has.
     */
    public StarShip(String ref, String nme, int laser, int photon) {
        super(ref, nme, laser * 30, (photon * 5) + (laser * 10));
        laserCannons = laser;
        photonTorpedoes = photon;
    }

    /**
     * Get the starship's laser cannon count.
     *
     * @return The starship's laser cannon count.
     */
    public int getLaserCannons() {
        return laserCannons;
    }

    /**
     * Get the starship's photon torpedo count.
     *
     * @return The starship's photon torpedo count.
     */
    public int getPhotonTorpedoes() {
        return photonTorpedoes;
    }

    /**
     * Determines if the starship can fight in a given battle.
     *
     * @param battleType The battle to check if the force can fight in.
     * @return Whether the starship can fight in the battle or not.
     */
    public boolean canFight(BattleType battleType) {
        // The starship can only fight in skirmishes and fights
        switch (battleType) {
            case SKIRMISH:
            case FIGHT:
                return true;
            default:
                return false;
        }
    }

    /**
     * Get a human-readable representation of this object including the
     * force reference, the force name, the activation cost, the force
     * strength, the laser cannon count, and the photon torpedo count.
     *
     * @return A string representation of this object.
     */
    public String toString() {
        return "<Force Reference: " + getReference() + " - Name: " + getName() + " - Force State: " + getForceState() + " - Activation Fee: " + getFee() + " - Strength: " + getStrength() + " - Laser Cannon Count: " + getLaserCannons() + " - Photon Torpedo Count: " + getPhotonTorpedoes() + ">";
    }
}
