package cwk4;

import java.io.Serializable;

/**
 * This interface specifies the behaviour expected from the WIN
 * system as required for 5COM2007.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 03/04/2023
 */
public interface WIN extends Serializable {
    /**
     * Get a human-readable representation of the state of the
     * game including the name of the admiral, the state of the
     * war chest, and whether defeated or not.
     *
     * @return A string representation of the state of the game.
     **/
    public String toString();

    /**
     * Determines if the admiral is defeated or not. It returns
     * true if the war chest <= 0 and the ASF has no forces which
     * can be recalled.
     *
     * @return Whether the admiral is defeated or not.
     */
    public boolean isDefeated();

    /**
     * Get the number of bit coins in the war chest.
     *
     * @return The number of bit coins in the war chest.
     */
    public int getWarchest();

    /**
     * Get a list of all forces in the system listing all forces
     * in the ASF, the UFF dock, and destroyed forces.
     *
     * @return A list of all forces in the system.
     */
    public String getAllForces();

    /**
     * Determines if a force reference is in the UFF dock.
     *
     * @param ref The reference of the force.
     * @return Whether the force is in the UFF dock or not.
     **/
    public boolean isInUFFDock(String ref);

    /**
     * Get a list of all forces in the UFF dock.
     *
     * @return A list of all forces in the UFF dock.
     **/
    public String getForcesInDock();

    /**
     * Get a list of all destroyed forces in the system.
     *
     * @return A list of all destroyed forces in the system.
     */
    public String getDestroyedForces();

    /**
     * Get a force's details from a given force reference or "No
     * such force" if one doesn't exist.
     *
     * @param ref The reference of the force.
     * @return The force's details from a given force reference.
     **/
    public String getForceDetails(String ref);

    /**
     * Activates a force into the ASF only if there are enough
     * resources for the activation fee. The force's state is
     * then set to "active".
     *
     * @param ref The reference of the force.
     * @return 0 if the force is activated, 1 if the force is not
     * in the UFF dock or is destroyed, 2 if there is not enough
     * bit coins, or -1 if the force doesn't exist.
     **/
    public int activateForce(String ref);

    /**
     * Determines if a given force reference exists in the ASF.
     *
     * @param ref The reference of the force.
     * @return Whether the given force reference exists in the
     * ASF or not.
     **/
    public boolean isInASFleet(String ref);

    /**
     * Get a list of all forces in the ASF.
     *
     * @return A list of all forces in the ASF.
     **/
    public String getASFleet();

    /**
     * Recalls a force from the ASF back to the UFF dock.
     *
     * @param ref The reference of the force.
     **/
    public void recallForce(String ref);

    /**
     * Determines if a given number represents a battle.
     *
     * @param num The number of the battle.
     * @return Whether the given number represents a battle or not.
     **/
    public boolean isBattle(int num);

    /**
     * Get a battle's details from a given battle number or
     * "No such battle" is one doesn't exist.
     *
     * @param num The number of the battle.
     * @return The battle's details from a given battle number.
     **/
    public String getBattle(int num);

    /**
     * Get a list of all battles in the system.
     *
     * @return A list of all battles in the system.
     **/
    public String getAllBattles();

    /**
     * Simulates a battle by locating a force from the ASF
     * which can engage in the battle. The result of the
     * battle will be one of the following:
     * 0 - Battle won so the gains are added to the
     * war chest.
     * 1 - Battle lost as no suitable force is available
     * so losses are deducted from the war chest.
     * 2 - Battle lost on battle strength so losses are
     * deducted from the war chest and the force is destroyed.
     * 3 - Battle lost and the admiral is completely defeated
     * (war chest is empty and no forces to recall).
     * -1 - No such battle is found.
     *
     * @param battleNo The number of the battle.
     * @return An integer showing the result of the battle.
     */
    public int doBattle(int battleNo);

    /**
     * Writes the game state to a specified file.
     *
     * @param fname The name of the file to store the game state.
     */
    public void saveGame(String fname);

    /**
     * Initialise a SpaceWars object from a given filename
     * storing the game state.
     *
     * @param fname The name of the file storing the game state.
     * @return The initialised SpaceWars object.
     */
    public SpaceWars restoreGame(String fname);
}
